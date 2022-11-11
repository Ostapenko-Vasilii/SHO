package ml.pvstudio.sno.fireBase.notifications

import android.app.Application
import android.widget.Toast
import com.google.firebase.messaging.FirebaseMessaging


class KApp : Application() {

    override fun onCreate() {
        super.onCreate()


            FirebaseMessaging.getInstance().token.addOnCompleteListener() { task ->
                if (task.isSuccessful){
                    return@addOnCompleteListener
                }

                val token = task.result
                Toast.makeText(applicationContext, "Down $token", Toast.LENGTH_SHORT).show()

            }
    }
}