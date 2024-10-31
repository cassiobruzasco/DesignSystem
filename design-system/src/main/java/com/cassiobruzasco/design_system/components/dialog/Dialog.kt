package com.cassiobruzasco.design_system.components.dialog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.cassiobruzasco.design_system.R
import com.cassiobruzasco.design_system.clickInteraction
import com.cassiobruzasco.design_system.components.button.DsButton
import com.cassiobruzasco.design_system.components.button.DsButtonStyle
import com.cassiobruzasco.design_system.components.button.PrimaryDefaultButton
import com.cassiobruzasco.design_system.components.button.SecondaryDefaultButton
import com.cassiobruzasco.design_system.components.input.DsValueInput
import com.cassiobruzasco.design_system.theme.ColorToken
import com.cassiobruzasco.design_system.theme.ColorToken.background_primary
import com.cassiobruzasco.design_system.theme.ColorToken.content_primary
import com.cassiobruzasco.design_system.theme.ColorToken.content_secondary
import com.cassiobruzasco.design_system.theme.FontToken

/**
 * A composable function that displays a dialog with customizable content and actions.
 *
 * This dialog can display a title, body text (as String or AnnotatedString), an icon,
 * custom composable, and buttons with various styles. It provides flexibility for
 * creating different types of dialogs within your application.
 *
 * @param title The title of the dialog (optional).
 * @param body The body text of the dialog, can be a String or AnnotatedString (optional).
 * @param icon The drawable resource ID of the icon to display (optional).
 * @param customIcon A composable function that provides a custom icon (optional).
 * @param customComponent A composable function that provides a custom component to display (optional).
 * @param shouldButtonFillRow Whether the buttons should fill the entire width of the dialog (default: false).
 * @param firstButtonStyle The style of the first button (default: PrimaryCompactButton).
 * @param firstButtonText The text of the first button (optional).
 * @param onFirstButtonClick The callback to invoke when the first button is clicked.
 * @param secondButtonStyle The style of the second button (optional).
 * @param secondButtonText The text of the second button (optional).
 * @param onSecondButtonClick The callback to invoke when the second button is clicked.
 * @param onDismiss The callback to invoke when the dialog is dismissed.
 */
@Composable
fun DsDialog(
    title: String? = null,
    body: Any? = null,
    @DrawableRes icon: Int? = null,
    customIcon: (@Composable () -> Unit)? = null,
    customComponent: (@Composable () -> Unit)? = null,
    shouldButtonFillRow: Boolean = false,
    firstButtonStyle: DsButtonStyle = PrimaryDefaultButton(isCompact = true),
    firstButtonText: String? = null,
    onFirstButtonClick: () -> Unit = { },
    secondButtonStyle: DsButtonStyle? = null,
    secondButtonText: String? = null,
    onSecondButtonClick: () -> Unit = { },
    onDismiss: () -> Unit = { },
) {
    Dialog(
        onDismissRequest = onDismiss,
        content = {
            Card(
                modifier = Modifier.sizeIn(minWidth = 312.dp),
                shape = RoundedCornerShape(12.dp),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(background_primary),
            ) {
                title?.let {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 16.dp, bottom = 8.dp),
                    ) {
                        Text(
                            modifier = Modifier
                                .fillMaxWidth()
                                .weight(1f),
                            text = it,
                            style = FontToken.heading_xs_bold,
                            color = content_primary,
                        )
                        Icon(
                            modifier = Modifier
                                .clickInteraction(
                                    bgColor = Color.Transparent,
                                    bgColorPressed = ColorToken.button_secondary_background_pressed,
                                    shape = CircleShape,
                                ) { onDismiss() },
                            painter = painterResource(id = R.drawable.ic_close),
                            contentDescription = null,
                            tint = content_secondary,
                        )
                    }
                }
                if (customIcon == null) {
                    icon?.let {
                        Spacer(modifier = Modifier.height(16.dp))
                        Image(
                            modifier = Modifier
                                .size(96.dp)
                                .fillMaxWidth()
                                .align(Alignment.CenterHorizontally),
                            painter = painterResource(id = icon),
                            contentDescription = null,
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                } else {
                    customIcon()
                    Spacer(modifier = Modifier.height(8.dp))
                }
                body?.let {
                    when (it) {
                        is String -> {
                            Text(
                                modifier = Modifier
                                    .padding(start = 20.dp, end = 20.dp, bottom = 16.dp)
                                    .verticalScroll(rememberScrollState()),
                                text = it,
                                style = FontToken.detail_md_regular,
                                color = content_secondary,
                            )
                        }

                        is AnnotatedString -> {
                            Text(
                                modifier = Modifier
                                    .padding(start = 20.dp, end = 20.dp, bottom = 16.dp)
                                    .verticalScroll(rememberScrollState()),
                                text = it,
                                style = FontToken.detail_md_regular,
                                color = content_secondary,
                            )
                        }
                    }
                }
                customComponent?.let { it() }
                Spacer(modifier = Modifier.height(16.dp))
                secondButtonStyle?.let {
                    if (shouldButtonFillRow) {
                        Spacer(modifier = Modifier.height(16.dp))
                        DsButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            text = firstButtonText,
                            style = firstButtonStyle,
                            onClick = {
                                onFirstButtonClick()
                                onDismiss()
                            },
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        DsButton(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp),
                            text = secondButtonText,
                            style = secondButtonStyle,
                            onClick = {
                                onSecondButtonClick()
                                onDismiss()
                            },
                        )
                    } else {
                        Row(
                            modifier = Modifier
                                .sizeIn(maxHeight = 40.dp)
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            DsButton(
                                modifier = Modifier.weight(1f),
                                text = firstButtonText,
                                style = firstButtonStyle,
                                onClick = {
                                    onFirstButtonClick()
                                    onDismiss()
                                },
                            )
                            Spacer(modifier = Modifier.width(12.dp))
                            DsButton(
                                modifier = Modifier.weight(1f),
                                text = secondButtonText,
                                style = secondButtonStyle,
                                onClick = {
                                    onSecondButtonClick()
                                    onDismiss()
                                },
                            )
                        }
                    }
                } ?: kotlin.run {
                    val fillModifier =
                        if (shouldButtonFillRow) Modifier.fillMaxWidth() else Modifier
                    DsButton(
                        modifier = fillModifier
                            .padding(horizontal = 20.dp)
                            .align(Alignment.CenterHorizontally),
                        text = firstButtonText,
                        style = firstButtonStyle,
                        onClick = {
                            onFirstButtonClick()
                            onDismiss()
                        },
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        },
    )
}

@Preview(showBackground = true)
@Composable
private fun DsDialogSingleButtonPreview() {
    DsDialog(
        title = "Title",
        body = "Lorem ipsum dolor sit amet consectetur.",
        icon = R.drawable.ic_lock,
        firstButtonStyle = PrimaryDefaultButton(isCompact = true),
        firstButtonText = "Ok",
    )
}

@Preview(showBackground = true)
@Composable
private fun DsDialogSingleButtonFillPreview() {
    DsDialog(
        title = "Title",
        body = "Lorem ipsum dolor sit amet consectetur.",
        icon = R.drawable.ic_lock,
        shouldButtonFillRow = true,
        firstButtonStyle = PrimaryDefaultButton(isCompact = true),
        firstButtonText = "Ok",
    )
}

@Preview(showBackground = true)
@Composable
private fun DsDialogTwoButtonsPreview() {
    DsDialog(
        title = "Title",
        body = "Lorem ipsum dolor sit amet consectetur.",
        icon = R.drawable.ic_lock,
        firstButtonStyle = SecondaryDefaultButton(isCompact = true),
        secondButtonStyle = PrimaryDefaultButton(isCompact = true),
        firstButtonText = "Secondary",
        secondButtonText = "Primary",
    )
}

@Preview(showBackground = true)
@Composable
private fun DsDialogTwoButtonsFillPreview() {
    DsDialog(
        title = "Title",
        body = "Lorem ipsum dolor sit amet consectetur.",
        icon = R.drawable.ic_lock,
        shouldButtonFillRow = true,
        firstButtonStyle = SecondaryDefaultButton(isCompact = true),
        secondButtonStyle = PrimaryDefaultButton(isCompact = true),
        firstButtonText = "Secondary",
        secondButtonText = "Primary",
    )
}

@Preview(showBackground = true)
@Composable
private fun DsDialogCustomPreview() {
    DsDialog(
        title = "Title",
        body = "Lorem ipsum dolor sit amet consectetur.",
        icon = R.drawable.ic_lock,
        shouldButtonFillRow = true,
        customComponent = {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                DsValueInput {  }
            }
        },
        firstButtonStyle = PrimaryDefaultButton(isCompact = true),
        firstButtonText = "Primary",
    )
}