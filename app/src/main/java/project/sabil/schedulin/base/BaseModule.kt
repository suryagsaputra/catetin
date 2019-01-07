package project.sabil.schedulin.base

import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val baseModule:Module = module {
    viewModel { BaseViewModel() }
}