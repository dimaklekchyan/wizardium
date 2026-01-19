package com.dimaklekchyan.wizardium.data.network

import com.dimaklekchyan.wizardium.core.AppError
import com.dimaklekchyan.wizardium.core.appJson
import io.ktor.client.HttpClient
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.headers
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess
import io.ktor.http.parameters
import kotlinx.serialization.SerializationException
import kotlinx.serialization.serializer
import kotlin.reflect.KType
import kotlin.reflect.typeOf

open class BaseApi(
    private val httpClient: HttpClient,
) {
    suspend inline fun <reified R: Any> get(
        url: String,
        queryParameters: List<RequestParameter> = listOf(),
        headers: Map<String, String> = mapOf(),
        decodeTo: KType = typeOf<R>(),
        decodeErrorTo: KType = typeOf<R>()
    ): Result<R> {
        return request<R>(
            url = url,
            decodeTo = decodeTo,
            decodeErrorTo = decodeErrorTo,
            requestBuilder = {
                method = HttpMethod.Get

                url {
                    parameters.apply {
                        queryParameters.forEach { (key, value) ->
                            append(key, value)
                        }
                    }
                }

                headers {
                    headers.forEach { (key, value) ->
                        append(key, value)
                    }
                }
            }
        )
    }

    suspend inline fun <reified R: Any> post(
        url: String,
        queryParameters: List<RequestParameter> = listOf(),
        bodyParameters: List<RequestParameter> = listOf(),
        headers: Map<String, String> = mapOf(),
        decodeTo: KType = typeOf<R>(),
        decodeErrorTo: KType = typeOf<R>()
    ): Result<R> {
        return request<R>(
            url = url,
            decodeTo = decodeTo,
            decodeErrorTo = decodeErrorTo,
            requestBuilder = {
                method = HttpMethod.Post

                url {
                    parameters.apply {
                        queryParameters.forEach { (key, value) ->
                            append(key, value)
                        }
                    }
                }

                val body = FormDataContent(
                    formData = parameters {
                        bodyParameters.forEach { (key, value) ->
                            append(key, value)
                        }
                    }
                )
                setBody(body)

                headers {
                    headers.forEach { (key, value) ->
                        append(key, value)
                    }
                }
            }
        )
    }

    suspend fun <R: Any> request(
        url: String,
        requestBuilder: HttpRequestBuilder.() -> Unit,
        decodeTo: KType,
        decodeErrorTo: KType,
    ): Result<R> {
        return try {
            val response =  httpClient.request(urlString = url) { requestBuilder(this) }
            val body = response.bodyAsText()

            if (response.status.isSuccess()) {
                parseResult(body, decodeTo)
            } else {
                when(response.status) {
                    HttpStatusCode.NotFound, HttpStatusCode.UnprocessableEntity -> {
                        Result.failure(AppError.InvalidURL)
                    }
                    HttpStatusCode.InternalServerError, HttpStatusCode.BadGateway, HttpStatusCode.GatewayTimeout -> {
                        Result.failure(AppError.ServerFailure)
                    }
                    else -> {
                        parseResult(body, decodeErrorTo)
                    }
                }
            }
        } catch (ex: SocketTimeoutException) {
            Result.failure(AppError.TimedOut)
        } catch (ex: SerializationException) {
            Result.failure(AppError.InvalidJSON)
        } catch (ex: IllegalArgumentException) {
            Result.failure(AppError.InvalidJSON)
        } catch (ex: Exception) {
            if (isInternetConnectionError(ex)) {
                Result.failure(AppError.NetworkConnectionLost)
            } else {
                Result.failure(AppError.Default)
            }
        }
    }

    private fun <R : Any> parseResult(
        body: String,
        decodeTo: KType
    ): Result<R> {
        val serializer = appJson.serializersModule.serializer(decodeTo)
        val data = appJson.decodeFromString(deserializer = serializer, string = body) as R
        return Result.success(data)
    }
}