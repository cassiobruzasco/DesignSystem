package com.cassiobruzasco.design_system.components.toast

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.design_system.R
import com.cassiobruzasco.design_system.theme.DesignSystemTheme
import com.cassiobruzasco.design_system.theme.FontToken

/**
 * DsToast composable for displaying toast messages.
 *
 * This composable displays a toast message with a title, optional body text, and an icon based on the provided `ToastState`.
 * It supports different toast types with varying colors and icons, as well as animations for showing and hiding the toast.
 *
 * @param toast The `ToastState` object that defines the content and appearance of the toast message.
 *
 * **Example:**
 *
 *      DsToast(
 *          ToastState(
 *             title = "Success!",
 *             body = "Your transfer was successful. Tap to view details.",
 *             toastType = ToastType.SUCCESS,
 *             isVisible = true,
 *             onClick = navController::goToDetails
 *         )
 *      )
 */
@Composable
fun DsToast(toast: ToastState) {
    val interactionSource = remember { MutableInteractionSource() }
    val borderModifier = when (toast.toastType) {
        ToastType.INFO_ACCENT_TOP, ToastType.SUCCESS_ACCENT_TOP, ToastType.WARNING_ACCENT_TOP,
        ToastType.ERROR_ACCENT_TOP,
        -> Modifier.drawBehind {
            drawLine(
                color = toast.toastType.accentColor,
                start = Offset(0f, 0f),
                end = Offset(size.width, 0f),
                strokeWidth = 8.dp.toPx(),
            )
        }

        ToastType.INFO_ACCENT_LEFT, ToastType.SUCCESS_ACCENT_LEFT, ToastType.WARNING_ACCENT_LEFT,
        ToastType.ERROR_ACCENT_LEFT,
        -> Modifier.drawBehind {
            drawLine(
                color = toast.toastType.accentColor,
                start = Offset(0f, 0f),
                end = Offset(0f, size.height),
                strokeWidth = 8.dp.toPx(),
            )
        }

        else -> Modifier
    }
    AnimatedVisibility(
        visible = toast.isVisible,
        enter =
        slideInVertically(
            initialOffsetY = { -it },
        ),
        exit =
        slideOutVertically(
            targetOffsetY = { -it },
        ),
        label = "Dismiss Toast Animation",
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(4.dp))
                .background(toast.toastType.bgColor)
                .clickable(
                    indication = null,
                    interactionSource = interactionSource,
                    onClick = toast.onClick,
                ),
        ) {
            Box(modifier = borderModifier) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.Top,
                ) {
                    Icon(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(
                            id = when (toast.toastType) {
                                ToastType.INFO, ToastType.WARNING, ToastType.ERROR -> R.drawable.ic_info
                                ToastType.SUCCESS -> R.drawable.ic_check
                                ToastType.SUCCESS_FILLED, ToastType.SUCCESS_ACCENT_TOP, ToastType.SUCCESS_ACCENT_LEFT -> R.drawable.ic_info_filled
                                else -> R.drawable.ic_info_filled
                            },
                        ),
                        contentDescription = null,
                        tint = toast.toastType.iconColor,
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column(
                        modifier = Modifier.weight(1f),
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            style = FontToken.body_md_bold,
                            text = toast.title,
                            textAlign = TextAlign.Start,
                            color = toast.toastType.textColor,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            style = FontToken.body_md_regular,
                            text = toast.body.orEmpty(),
                            textAlign = TextAlign.Start,
                            color = toast.toastType.textColor,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                    Icon(
                        modifier = Modifier.size(14.dp),
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = null,
                        tint = toast.toastType.closeIconColor,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun DsToastPreview() {
    DesignSystemTheme {
        Column(
            modifier = Modifier
                .background(Color.Transparent)
                .padding(20.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            val toast = ToastState(
                title = "Title",
                body = "Your details have been updated!",
                toastType = ToastType.NEUTRAL,
                isVisible = true,
                onClick = {},
            )

            repeat(17) {
                var isVisible by remember { mutableStateOf(true) }
                DsToast(
                    toast.copy(
                        toastType = when (it) {
                            0 -> ToastType.NEUTRAL
                            1 -> ToastType.INFO
                            2 -> ToastType.INFO_ACCENT_LEFT
                            3 -> ToastType.INFO_ACCENT_TOP
                            4 -> ToastType.INFO_FILLED
                            5 -> ToastType.SUCCESS
                            6 -> ToastType.SUCCESS_ACCENT_LEFT
                            7 -> ToastType.SUCCESS_ACCENT_TOP
                            8 -> ToastType.SUCCESS_FILLED
                            9 -> ToastType.WARNING
                            10 -> ToastType.WARNING_ACCENT_LEFT
                            11 -> ToastType.WARNING_ACCENT_TOP
                            12 -> ToastType.WARNING_FILLED
                            13 -> ToastType.ERROR
                            14 -> ToastType.ERROR_ACCENT_LEFT
                            15 -> ToastType.ERROR_ACCENT_TOP
                            else -> ToastType.ERROR_FILLED
                        },
                        isVisible = isVisible,
                        onClick = {
                            isVisible = !isVisible
                        },
                    ),
                )
            }
        }
    }
}

@Preview
@Composable
private fun DsToastAnimationPreview() {
    DesignSystemTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Transparent)
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            var isVisible by remember { mutableStateOf(false) }
            val toast = ToastState(
                title = "Title",
                body = "Your details have been updated!",
                toastType = ToastType.INFO_ACCENT_TOP,
                isVisible = isVisible,
                onClick = {},
            )

            DsToast(
                toast.copy(isVisible = isVisible),
            )

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.BottomCenter,
            ) {
                Text(
                    modifier = Modifier.clickable { isVisible = !isVisible },
                    text = "show / hide toast",
                    style = FontToken.heading_xs_bold,
                )
            }
        }
    }
}