package project.sabil.schedulin.data

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module
import project.sabil.schedulin.utils.Constants

val keyStoreModule = module {
    single(name = Constants.DI_PREFERENCE_DEFAULT) {
        SharedPreferenceApi(
                androidContext(),
                get(Constants.DI_GSON_DEFAULT)
        ) as KeyValueStore
    }
}