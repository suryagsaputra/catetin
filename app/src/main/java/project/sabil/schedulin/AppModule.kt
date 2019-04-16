package project.sabil.schedulin

import com.google.firebase.firestore.FirebaseFirestore
import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val appModule: Module = module {
    single { FirebaseFirestore.getInstance() }
}

