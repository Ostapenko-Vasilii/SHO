package ml.pvstudio.sno.fireBase

import android.app.Application
import com.google.firebase.FirebaseApp

class FbApp : Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this@FbApp)

    }
}