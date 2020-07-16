package org.itstep.liannoi.notifications.application.common.notifications.core.replies

import android.app.Notification
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.RemoteInput
import org.itstep.liannoi.notifications.application.common.notifications.core.DefaultNotificationFactory
import org.itstep.liannoi.notifications.presentation.SecondActivity

class ActivityNotificationFactory(
    context: Context,
    details: Details,
    private val action: Action<SecondActivity>
) : DefaultNotificationFactory(context, details) {

    class Action<TActivity>(
        val activity: Class<TActivity>,
        val extra: String,
        val keyCode: String,
        val requestCode: Int,
        val action: String
    )

    override fun create(): Notification {
        val builder = prepare()

        val intent: Intent = Intent(context, action.activity).setAction(action.keyCode)

        val pendingIntent: PendingIntent =
            PendingIntent.getActivity(context, action.requestCode, intent, 0)

        val remoteInput: RemoteInput = RemoteInput.Builder(action.extra)
            .setLabel("Type message")
            .build()

        val action: NotificationCompat.Action = NotificationCompat.Action.Builder(
            android.R.drawable.ic_menu_send,
            this.action.action,
            pendingIntent
        )
            .addRemoteInput(remoteInput)
            .build()

        builder.addAction(action)

        return builder.build()
    }
}
