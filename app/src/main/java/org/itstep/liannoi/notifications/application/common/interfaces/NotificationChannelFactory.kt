package org.itstep.liannoi.notifications.application.common.interfaces

import android.app.NotificationChannel

interface NotificationChannelFactory {
    fun create(): NotificationChannel
}
