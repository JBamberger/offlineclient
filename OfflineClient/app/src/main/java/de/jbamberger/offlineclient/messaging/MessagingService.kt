package de.jbamberger.offlineclient.messaging

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

import timber.log.Timber

class MessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {
        Timber.e("Received message with id %s", remoteMessage!!.messageId)
    }
}
