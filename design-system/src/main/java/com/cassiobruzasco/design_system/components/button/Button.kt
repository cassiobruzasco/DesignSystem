package com.cassiobruzasco.design_system.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.design_system.HorizontalSpacer
import com.cassiobruzasco.design_system.R
import com.cassiobruzasco.design_system.bounceClick
import com.cassiobruzasco.design_system.clickInteraction
import com.cassiobruzasco.design_system.theme.ColorToken
import com.cassiobruzasco.design_system.theme.FontToken

/**
 * DsButton composable for displaying buttons with various styles and functionalities.
 *
 * This button supports different sizes, styles, icons, and loading/disabled states.
 * It provides flexibility in customizing the button's appearance and behavior.
 *
 * @param modifier Optional modifier for customizing the button's appearance and behavior.
 * @param text The text to be displayed on the button (optional).
 * @param style The style of the button, which defines its appearance and behavior.
 * @param onClick The callback function to be executed when the button is clicked.
 *
 * **Button Styles**
 *
 * This Design System offers a variety of button styles to cater to different needs:
 *
 * **Color Variants:**
 * * Primary: Brand-themed color.
 * * Secondary: Secondary color usually for the second option on Cancel, Confirm pattern.
 * * Ghost: Transparent background.
 * * Alert:  Color used for alerts or warnings.
 *
 * **Size Variants:**
 * * Default: The largest button size and default size to be used.
 * * Small: A smaller button size.
 *
 * **Shape Variants:**
 * * Default: Rectangular with rounded corners.
 * * Round: Circular shape.
 *
 * **Constructing Style Names***
 * Style names are constructed to represent the combination of color, shape, and size.
 * For example:
 * * `PrimaryDefaultButton`: Primary color, default size, rounded corners.
 * * `PrimaryRoundDefaultButton`: Primary color, default size, circular shape.
 *
 * **Icons**
 *
 * You can add icons to buttons using the following properties within the style:
 * * `iconRes`: The resource ID of the icon drawable.
 * * `iconPosition`: The position of the icon relative to the text (`DsButtonIconPosition.LeadingIcon` or `DsButtonIconPosition.TrailingIcon`).
 *
 * **Icon Placement:**
 * * Leading: Icon appears before the text.
 * * Trailing: Icon appears after the text.
 *
 * **isLoading and isDisabled:**
 * * isLoading: Button will be on loading state, disabled and with a circular progress indicator.
 * * isDisable: Button will not accept click events and will be disabled.
 *
 * **Example:**
 *
 *            DsButton(
 *                 text = "Primary Button",
 *                 style = PrimaryDefaultButton(
 *                      iconRes = R.drawable.ic_info,
 *                      iconPosition = DsButtonIconPosition.TrailingIcon,
 *                      isLoading = true,
 *                      isDisable = true
 *                 ),
 *                 onClick = viewModel::login
 *            )
 *
 */
@Composable
fun DsButton(
    modifier: Modifier = Modifier,
    text: String? = null,
    style: DsButtonStyle,
    onClick: () -> Unit,
) {
    val stateModifier = when {
        style.isLoading -> if (style is SecondaryDefaultButton) {
            Modifier
                .background(
                    color = style.color.loadingColor,
                    shape = style.shape,
                )
                .border(
                    1.dp,
                    ColorToken.button_secondary_border_default,
                    style.shape,
                )
        } else {
            Modifier
                .background(
                    color = style.color.loadingColor,
                    shape = style.shape,
                )
        }


        style.isDisabled -> Modifier
            .background(
                color = style.color.disabledColor,
                shape = style.shape,
            )


        style is SecondaryDefaultButton -> Modifier
            .border(1.dp, ColorToken.button_secondary_border_default, style.shape)
            .clickInteraction(
                bgColor = style.color.bgColor,
                bgColorPressed = style.color.pressedColor,
                shape = style.shape,
                onClick = onClick,
            )

        else -> Modifier
            .bounceClick()
            .clickInteraction(
                bgColor = style.color.bgColor,
                bgColorPressed = style.color.pressedColor,
                shape = style.shape,
                onClick = onClick,
            )
    }
    Column(
        modifier = modifier.heightIn(min = style.size.height),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Box(
            modifier = modifier
                .then(stateModifier.clip(shape = style.shape))
                .then(
                    Modifier
                        .sizeIn(
                            minWidth = style.size.width,
                            minHeight = style.size.height,
                        )
                        .padding(8.dp),
                ),
            contentAlignment = Alignment.Center,
        ) {
            when {
                style.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.size(style.size.iconSize),
                        color = style.color.contentColor,
                        strokeWidth = 2.dp,
                    )
                }

                else -> {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        if (style.iconPosition is DsButtonIconPosition.LeadingIcon) {
                            InternalButtonIcon(style, text)
                        }
                        Text(
                            modifier = Modifier.offset(
                                x = when (style.iconPosition) {
                                    is DsButtonIconPosition.LeadingIcon -> (-5).dp
                                    is DsButtonIconPosition.TrailingIcon -> 5.dp
                                    else -> 0.dp
                                },
                            ),
                            text = text.orEmpty(),
                            color = if (style.isDisabled) style.color.disabledContentColor else style.color.contentColor,
                            textAlign = TextAlign.Center,
                            style = style.textStyle,
                            maxLines = 1,
                        )
                        if (style.iconPosition is DsButtonIconPosition.TrailingIcon) {
                            InternalButtonIcon(style, text)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun InternalButtonIcon(style: DsButtonStyle, text: String?) {
    style.iconRes?.let { res ->
        if (style.iconPosition is DsButtonIconPosition.TrailingIcon && text != null) {
            HorizontalSpacer(15.dp)
        }
        Icon(
            modifier = Modifier
                .size(style.size.iconSize),
            painter = painterResource(id = res),
            contentDescription = null,
            tint = if (style.isDisabled) style.color.disabledContentColor else style.color.contentColor,
        )
        if (style.iconPosition is DsButtonIconPosition.LeadingIcon && text != null) {
            HorizontalSpacer(15.dp)
        }
    }
}

@Preview
@Composable
private fun PrimaryButtonPreview() {
    Column(
        modifier = Modifier.padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = "Primary Buttons",
            style = FontToken.heading_xs_bold,
            color = ColorToken.content_white,
            textAlign = TextAlign.Center,
        )
        repeat(6) { index ->
            DsButton(
                text = "Primary Button",
                style = when (index) {
                    0 -> PrimaryDefaultButton()
                    1 -> PrimaryDefaultButton(isCompact = true)
                    2 -> PrimaryDefaultButton(isLoading = true)
                    3 -> PrimaryDefaultButton(isDisabled = true)
                    4 -> PrimaryDefaultButton(
                        iconRes = R.drawable.ic_info,
                        iconPosition = DsButtonIconPosition.TrailingIcon
                    )

                    5 -> PrimaryDefaultButton(
                        iconRes = R.drawable.ic_info,
                        iconPosition = DsButtonIconPosition.LeadingIcon
                    )

                    else -> PrimaryDefaultButton()
                },
                onClick = {},
            )
        }
    }
}

@Preview
@Composable
private fun SecondaryButtonPreview() {
    Column(
        modifier = Modifier.padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = "Secondary Buttons",
            style = FontToken.heading_xs_bold,
            color = ColorToken.content_white,
            textAlign = TextAlign.Center,
        )
        repeat(6) { index ->
            DsButton(
                text = "Secondary Button",
                style = when (index) {
                    0 -> SecondaryDefaultButton()
                    1 -> SecondaryDefaultButton(isCompact = true)
                    2 -> SecondaryDefaultButton(isLoading = true)
                    3 -> SecondaryDefaultButton(isDisabled = true)
                    4 -> SecondaryDefaultButton(
                        iconRes = R.drawable.ic_info,
                        iconPosition = DsButtonIconPosition.TrailingIcon
                    )

                    5 -> SecondaryDefaultButton(
                        iconRes = R.drawable.ic_info,
                        iconPosition = DsButtonIconPosition.LeadingIcon
                    )

                    else -> SecondaryDefaultButton()
                },
                onClick = {},
            )
        }
    }
}

@Preview
@Composable
private fun GhostButtonPreview() {
    Column(
        modifier = Modifier.padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = "Ghost Buttons",
            style = FontToken.heading_xs_bold,
            color = ColorToken.content_white,
            textAlign = TextAlign.Center,
        )
        repeat(6) { index ->
            DsButton(
                text = "Ghost Button",
                style = when (index) {
                    0 -> GhostDefaultButton()
                    1 -> GhostDefaultButton(isCompact = true)
                    2 -> GhostDefaultButton(isLoading = true)
                    3 -> GhostDefaultButton(isDisabled = true)
                    4 -> GhostDefaultButton(
                        iconRes = R.drawable.ic_info,
                        iconPosition = DsButtonIconPosition.TrailingIcon
                    )

                    5 -> GhostDefaultButton(
                        iconRes = R.drawable.ic_info,
                        iconPosition = DsButtonIconPosition.LeadingIcon
                    )

                    else -> GhostDefaultButton()
                },
                onClick = {},
            )
        }
    }
}

@Preview
@Composable
private fun AlertButtonPreview() {
    Column(
        modifier = Modifier.padding(vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            text = "Alert Buttons",
            style = FontToken.heading_xs_bold,
            color = ColorToken.content_white,
            textAlign = TextAlign.Center,
        )
        repeat(6) { index ->
            DsButton(
                text = "Alert Button",
                style = when (index) {
                    0 -> AlertDefaultButton()
                    1 -> AlertDefaultButton(isCompact = true)
                    2 -> AlertDefaultButton(isLoading = true)
                    3 -> AlertDefaultButton(isDisabled = true)
                    4 -> AlertDefaultButton(
                        iconRes = R.drawable.ic_lock,
                        iconPosition = DsButtonIconPosition.TrailingIcon
                    )

                    5 -> AlertDefaultButton(
                        iconRes = R.drawable.ic_info,
                        iconPosition = DsButtonIconPosition.LeadingIcon
                    )

                    else -> AlertDefaultButton()
                },
                onClick = {},
            )
        }
    }
}