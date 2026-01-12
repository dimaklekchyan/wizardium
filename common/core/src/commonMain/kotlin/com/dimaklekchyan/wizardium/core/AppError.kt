package com.dimaklekchyan.wizardium.core

sealed class AppError: Throwable() {
    object InvalidURL: AppError()
    object ServerFailure: AppError()
    object TimedOut: AppError()
    object InvalidJSON: AppError()
    object NetworkConnectionLost: AppError()
    object Default: AppError()
}