package org.itstep.liannoi.notifications.application.common.notifications

import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat
import org.itstep.liannoi.notifications.R
import org.itstep.liannoi.notifications.application.ApplicationDefaults
import org.itstep.liannoi.notifications.infrastructure.notifications.AbstractNotificationFactory

open class DefaultNotificationFactory(
    context: Context,
    private val details: Details
) : AbstractNotificationFactory(context) {

    class Details(
        val title: String,
        val text: String
    )

    override fun create(): Notification = prepare().build()

    protected fun prepare(): NotificationCompat.Builder =
        NotificationCompat.Builder(context, ApplicationDefaults.CHANNEL_DEFAULT_ID)
            .setSmallIcon(R.drawable.ic_baseline_adjust_24)
            .setContentTitle(details.title)
            .setContentText(details.text)
}
