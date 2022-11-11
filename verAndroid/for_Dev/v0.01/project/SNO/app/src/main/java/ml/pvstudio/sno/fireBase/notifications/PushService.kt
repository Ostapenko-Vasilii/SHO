package ml.pvstudio.sno.fireBase.notifications

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.google.firebase.heartbeatinfo.HeartBeatController
import com.google.firebase.inject.Provider
import com.google.firebase.installations.remote.FirebaseInstallationServiceClient
import com.google.firebase.messaging.FirebaseMessagingService

class PushService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)


    }
}