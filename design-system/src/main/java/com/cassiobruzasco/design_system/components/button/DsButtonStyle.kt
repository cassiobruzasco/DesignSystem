package com.cassiobruzasco.design_system.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.design_system.theme.ColorToken
import com.cassiobruzasco.design_system.theme.FontToken

/**
 * Represents the style of a button, including its color, shape, size, icon, and state.
 *
 * @param iconRes The resource ID of the icon drawable (optional).
 * @param iconPosition The position of the icon (mandatory if [iconRes] is present).
 * @param isDisabled Whether the button is disabled.
 * @param isLoading Whether the button is in a loading state.
 * @param size The size of the button (`DsButtonSize`).
 * @param color The color scheme of the button (`DsButtonColor`).
 * @param textStyle The text style applied to the button text.
 * @param shape The shape of the button.
 *
 * **Available Styles**
 *
 * This class provides several pre-defined button styles:
 *
 * * **Primary:** Brand-themed color.
 * * **Secondary:** Alternative color.
 * * **Ghost:** Transparent background.
 * * **Alert:** Color used for alerts or warnings.
 */
sealed class DsButtonStyle(
    @DrawableRes open val iconRes: Int? = null,
    open val iconPosition: DsButtonIconPosition? = null,
    open val isDisabled: Boolean = false,
    open val isLoading: Boolean = false,
    internal val size: DsButtonSize,
    internal val color: DsButtonColor,
    internal val textStyle: TextStyle =
        when (size) {
            DsButtonSize.Default -> FontToken.body_lg_medium
            DsButtonSize.Compact -> FontToken.body_md_medium
            else -> FontToken.body_md_medium
        },
    internal val shape: RoundedCornerShape = RoundedCornerShape(4.dp),
)

/**
 * Defines the size of a button.
 *
 * **Sizes**
 *
 * * **Default:** The largest button size (48dp minHeight, 168dp minWidth).
 * * **Compact:** A smaller button size (38dp minHeight, 154dp minWidth).
 * * **IconLg:**  A large icon button size (48dp minHeight x minWidth).
 * * **IconMd:** A medium icon button size (36dp minHeight x minWidth).
 */
sealed class DsButtonSize(
    internal val height: Dp,
    internal val width: Dp,
    internal val iconSize: Dp,
) {
    data object Default : DsButtonSize(48.dp, 168.dp, 16.dp)

    data object Compact : DsButtonSize(40.dp, 135.dp, 14.dp)

    data object IconLg : DsButtonSize(48.dp, 48.dp, 24.dp)

    data object IconMd : DsButtonSize(36.dp, 36.dp, 20.dp)
}

/**
 * Specifies the position of an icon relative to the button text.
 *
 * **Available Positions**
 *
 * * **LeadingIcon:** Icon appears before the text.
 * * **TrailingIcon:** Icon appears after the text.
 */
sealed interface DsButtonIconPosition {
    data object LeadingIcon : DsButtonIconPosition
    data object TrailingIcon : DsButtonIconPosition
}

/**
 * Represents the color scheme of a button.
 *
 * @param bgColor The background color of the button.
 * @param loadingColor The background color of the button when in a loading state.
 * @param disabledColor The background color of the button when disabled.
 * @param contentColor The text color of the button.
 * @param disabledContentColor The text color of the button when disabled.
 * @param pressedColor The background color of the button when pressed.
 *
 * **Available Color Schemes**
 *
 * * **PrimaryButtonColor:** Brand-themed color scheme.
 * * **SecondaryButtonColor:** Alternative color scheme.
 * * **GhostButtonColor:** Transparent background color scheme.
 * * **AlertButtonColor:** Color scheme used for alerts or warnings.
 */
internal sealed class DsButtonColor(
    val bgColor: Color,
    val loadingColor: Color,
    val disabledColor: Color,
    val contentColor: Color,
    val disabledContentColor: Color,
    val pressedColor: Color,
) {
    data object PrimaryButtonColor : DsButtonColor(
        bgColor = ColorToken.button_primary_background_default,
        loadingColor = ColorToken.button_primary_background_loading,
        disabledColor = ColorToken.button_primary_background_disabled,
        contentColor = ColorToken.button_primary_text_default,
        disabledContentColor = ColorToken.button_primary_text_disabled,
        pressedColor = ColorToken.button_primary_background_pressed,
    )

    data object SecondaryButtonColor : DsButtonColor(
        bgColor = ColorToken.background_primary,
        loadingColor = ColorToken.background_primary,
        disabledColor = ColorToken.button_secondary_background_disabled,
        contentColor = ColorToken.button_secondary_text_default,
        disabledContentColor = ColorToken.button_secondary_text_disabled,
        pressedColor = ColorToken.button_secondary_background_pressed,
    )

    data object GhostButtonColor : DsButtonColor(
        bgColor = Color.Transparent,
        loadingColor = Color.Transparent,
        disabledColor = ColorToken.button_ghost_background_disabled,
        contentColor = ColorToken.button_ghost_text_default,
        disabledContentColor = ColorToken.button_ghost_text_disabled,
        pressedColor = ColorToken.button_ghost_background_pressed,
    )

    data object AlertButtonColor : DsButtonColor(
        bgColor = ColorToken.button_critical_primary_background_default,
        loadingColor = ColorToken.button_critical_primary_background_loading,
        disabledColor = ColorToken.button_critical_primary_background_disabled,
        contentColor = ColorToken.button_critical_primary_text_default,
        disabledContentColor = ColorToken.button_critical_primary_text_disabled,
        pressedColor = ColorToken.button_critical_primary_background_pressed,
    )
}