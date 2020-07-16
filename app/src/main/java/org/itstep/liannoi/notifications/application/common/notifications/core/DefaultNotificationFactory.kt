package org.itstep.liannoi.notifications.application.common.notifications.core

import android.app.Notification
import android.content.Context
import androidx.core.app.NotificationCompat
import org.itstep.liannoi.notifications.R
import org.itstep.liannoi.notifications.application.common.notifications.channels.DefaultNotificationChannelFactory
import org.itstep.liannoi.notifications.infrastructure.notifications.AbstractNotificationFactory

open class DefaultNotificationFactory(
    context: Context,
    private val details: Details
) : AbstractNotificationFactory(context) {

    object Defaults {
        const val FIRST_ID: Int = 1
        const val SECOND_ID: Int = 2

        const val THIRD_ID: Int = 3
        const val THIRD_REPLY_EXTRA: String = "ACTION_REPLY_EXTRA"
        const val THIRD_REPLY_KEYCODE: String = "ACTION_REPLY"
        const val THIRD_REPLY_CODE: Int = 200
        const val THIRD_REPLY: String = "Reply"
    }

    class Details(
        val title: String,
        val text: String
    )

    override fun create(): Notification = prepare().build()

    protected fun prepare(): NotificationCompat.Builder =
        NotificationCompat.Builder(context, DefaultNotificationChannelFactory.Defaults.ID)
            .setSmallIcon(R.drawable.ic_baseline_adjust_24)
            .setContentTitle(details.title)
            .setContentText(details.text)
}
