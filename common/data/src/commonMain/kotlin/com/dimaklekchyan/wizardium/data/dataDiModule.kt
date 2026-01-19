package com.dimaklekchyan.wizardium.data

import com.dimaklekchyan.wizardium.data.db.AppDB
import com.dimaklekchyan.wizardium.data.db.AppDBName
import com.dimaklekchyan.wizardium.data.db.getDatabaseBuilder
import com.dimaklekchyan.wizardium.data.network.HttpClientProvider
import com.dimaklekchyan.wizardium.data.network.HttpEngineFactory
import com.dimaklekchyan.wizardium.data.network.api.CharactersApi
import com.dimaklekchyan.wizardium.data.network.api.CharactersApiImpl
import com.dimaklekchyan.wizardium.data.network.api.SpellsApi
import com.dimaklekchyan.wizardium.data.network.api.SpellsApiImpl
import com.dimaklekchyan.wizardium.data.repositories.CharactersRepositoryImpl
import com.dimaklekchyan.wizardium.data.repositories.SpellsRepositoryImpl
import com.dimaklekchyan.wizardium.domain.repositories.CharactersRepository
import com.dimaklekchyan.wizardium.domain.repositories.SpellsRepository
import io.ktor.client.HttpClient
import org.koin.dsl.module
import ru.travelata.core.coroutines.DispatcherProvider

val dataDiModule = module {

    //network
    single<HttpClient> {
        val engine = HttpEngineFactory().createEngine()
        HttpClientProvider.provideClient(engine)
    }

    single<CharactersApi> { CharactersApiImpl(get()) }
    single<SpellsApi> { SpellsApiImpl(get()) }

    //db
    single<AppDB> {
        getDatabaseBuilder<AppDB>(
            context = get(),
            dbName = AppDBName
        ).fallbackToDestructiveMigrationOnDowngrade(true)
            .setQueryCoroutineContext(get<DispatcherProvider>().io)
            .build()
    }

    single { get<AppDB>().characterDao() }
    single { get<AppDB>().spellDao() }

    //repositories
    single<CharactersRepository> { CharactersRepositoryImpl(get(), get()) }
    single<SpellsRepository> { SpellsRepositoryImpl(get(), get()) }
}
