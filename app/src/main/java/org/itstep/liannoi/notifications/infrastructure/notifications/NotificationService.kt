package org.itstep.liannoi.notifications.infrastructure.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import org.itstep.liannoi.notifications.application.common.interfaces.NotificationChannelFactory
import org.itstep.liannoi.notifications.application.common.interfaces.NotificationFactory

class NotificationService(
    context: Context,
    channelFactory: NotificationChannelFactory
) {

    private var manager: NotificationManager =
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    private var channel: NotificationChannel = channelFactory.create()

    init {
        manager.createNotificationChannel(channel)
    }

    fun notify(id: Int, notificationFactory: NotificationFactory) {
        manager.notify(id, notificationFactory.create())
    }

    fun cancel(id: Int) {
        manager.cancel(id)
    }
}
