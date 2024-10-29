package com.cassiobruzasco.design_system.components.toast

import androidx.compose.ui.graphics.Color
import com.cassiobruzasco.design_system.theme.ColorToken

/**
 * Represents the state of a toast message.
 *
 * @param title The title of the toast message.
 * @param body The body text of the toast message (optional).
 * @param toastType The type of toast, which determines its appearance and icon (e.g., `ToastType.SUCCESS`, `ToastType.ERROR`).
 * @param isVisible Whether the toast is currently visible.
 * @param duration The duration of the toast message (`ToastDuration.Short` or `ToastDuration.Long`).
 * @param onClick The callback function to be executed when the toast is clicked.
 */
data class ToastState(
    val title: String,
    val body: String?,
    val toastType: ToastType,
    val isVisible: Boolean,
    val duration: ToastDuration = ToastDuration.Short,
    val onClick: () -> Unit,
)

/**
 * Defines the duration of a toast message.
 *
 * **Available Durations**
 *
 * * **Short:** 5000 milliseconds (5 seconds).
 * * **Long:** 7000 milliseconds (7 seconds).
 */
enum class ToastDuration(val time: kotlin.Long) {
    Short(5000),
    Long(7000),
}

/**
 * Represents the type of a toast message, which determines its appearance (color and icon).
 *
 * **Available Types**
 *
 * * **NEUTRAL:** Neutral toast with a gray background.
 * * **INFO:** Informational toast with a blue background.
 * * **INFO_ACCENT_LEFT:** Informational toast with a blue accent on the left side.
 * * **INFO_ACCENT_TOP:** Informational toast with a blue accent on the top.
 * * **INFO_FILLED:** Informational toast with a filled blue background.
 * * **SUCCESS:** Success toast with a green background.
 * * **SUCCESS_ACCENT_LEFT:** Success toast with a green accent on the left side.
 * * **SUCCESS_ACCENT_TOP:** Success toast with a green accent on the top.
 * * **SUCCESS_FILLED:** Success toast with a filled green background.
 * * **WARNING:** Warning toast with an orange background.
 * * **WARNING_ACCENT_LEFT:** Warning toast with an orange accent on the left side.
 * * **WARNING_ACCENT_TOP:** Warning toast with an orange accent on the top.
 * * **WARNING_FILLED:** Warning toast with a filled orange background.
 * * **ERROR:** Error toast with a red background.
 * * **ERROR_ACCENT_LEFT:** Error toast with a red accent on the left side.
 * * **ERROR_ACCENT_TOP:** Error toast with a red accent on the top.
 * * **ERROR_FILLED:** Error toast with a filled red background.
 */
enum class ToastType(
    internal val bgColor: Color,
    internal val accentColor: Color,
    internal val textColor: Color,
    internal val iconColor: Color,
    internal val closeIconColor: Color = ColorToken.content_secondary,
) {
    NEUTRAL(ColorToken.background_inverted, ColorToken.content_inverted, ColorToken.content_inverted, ColorToken.content_white, ColorToken.content_white),
    INFO(ColorToken.background_alert_info_lightest, ColorToken.content_alert_info, ColorToken.content_primary, ColorToken.content_alert_info),
    INFO_ACCENT_LEFT(INFO.bgColor, INFO.accentColor, INFO.textColor, INFO.iconColor, INFO.closeIconColor),
    INFO_ACCENT_TOP(INFO.bgColor, INFO.accentColor, INFO.textColor, INFO.iconColor, INFO.closeIconColor),
    INFO_FILLED(ColorToken.background_alert_info, INFO.accentColor, ColorToken.content_inverted, ColorToken.content_inverted, ColorToken.content_inverted),
    SUCCESS(ColorToken.background_alert_success_lightest, ColorToken.content_alert_success, ColorToken.content_primary, ColorToken.content_alert_success),
    SUCCESS_ACCENT_LEFT(SUCCESS.bgColor, SUCCESS.accentColor, SUCCESS.textColor, SUCCESS.iconColor, SUCCESS.closeIconColor),
    SUCCESS_ACCENT_TOP(SUCCESS.bgColor, SUCCESS.accentColor, SUCCESS.textColor, SUCCESS.iconColor, SUCCESS.closeIconColor),
    SUCCESS_FILLED(ColorToken.background_alert_success, SUCCESS.accentColor, ColorToken.content_inverted, ColorToken.content_inverted, ColorToken.content_inverted),
    WARNING(ColorToken.background_alert_warning_lightest, ColorToken.content_alert_warning, ColorToken.content_primary, ColorToken.content_alert_warning),
    WARNING_ACCENT_LEFT(WARNING.bgColor, WARNING.accentColor, WARNING.textColor, WARNING.iconColor, WARNING.closeIconColor),
    WARNING_ACCENT_TOP(WARNING.bgColor, WARNING.accentColor, WARNING.textColor, WARNING.iconColor, WARNING.closeIconColor),
    WARNING_FILLED(ColorToken.background_alert_warning, WARNING.accentColor, ColorToken.content_inverted, ColorToken.content_inverted, ColorToken.content_inverted),
    ERROR(ColorToken.background_alert_error_lightest, ColorToken.content_alert_error, ColorToken.content_primary, ColorToken.content_alert_error),
    ERROR_ACCENT_LEFT(ERROR.bgColor, ERROR.accentColor, ERROR.textColor, ERROR.iconColor, ERROR.closeIconColor),
    ERROR_ACCENT_TOP(ERROR.bgColor, ERROR.accentColor, ERROR.textColor, ERROR.iconColor, ERROR.closeIconColor),
    ERROR_FILLED(ColorToken.background_alert_error, ERROR.accentColor, ColorToken.content_inverted, ColorToken.content_inverted, ColorToken.content_inverted),
}