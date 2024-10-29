package com.cassiobruzasco.design_system.components.input

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.cassiobruzasco.design_system.HorizontalSpacer
import com.cassiobruzasco.design_system.R
import com.cassiobruzasco.design_system.components.IconTapToShowText
import com.cassiobruzasco.design_system.theme.ColorToken
import com.cassiobruzasco.design_system.theme.FontToken
import com.cassiobruzasco.design_system.theme.DesignSystemTheme

/**
 * DsInput composable for displaying and inserting texts with a custom label.
 *
 * **DsInput Styles**
 * It has two different varieties to encompass different situations.
 *  - Default, the default dimensions for TextInput field.
 *  - Compact, smaller version of the TextInput field. It has smaller paddings, and font size.
 *
 * DsInput:
 * @param label Text to be displayed above the text input field.
 * @param hint Text to be displayed when the user hasn't typed anything yet.
 * @param text Text to be set.
 * @param isCompact Boolean to determine the style, if is Compact/Default size.
 * @param isError Boolean to determine if the value inserted is invalid or not.
 * @param isEnabled Boolean to determine if the textInput is enabled/disabled.
 * @param visualTransformation [VisualTransformation] to modify the visual representation of the input text.
 * @param inputType [InputType] to specify the type of keyboard input expected.
 * @param iconRes Resource drawable of the icon to be shown.
 * @param iconPosition [IconPosition] to be set, either trailing or leading icon's position.
 * @param keyboardOptions Customized keyboard options.
 * @param onValueChange Listener to take actions when the value has changed.
 *
 * **Example:**
 *
 *
 *             DsInput(
 *               label = "Label",
 *               hint = "Value to be input",
 *               text: "Value inserted",
 *               isCompact = false,
 *               isError = false,
 *               isEnabled = true,
 *               iconRes = R.drawable.ic_lock,
 *               iconPosition = IconPosition.Leading,
 *               keyboardOptions = KeyboardOptions.Default.copy(
 *                 keyboardType = KeyboardType.Number,
 *                 imeAction = ImeAction.Done
 *               ),
 *               inputType = InputType.Password,
 *               onValueChange = { value -> setValue(value) },
 *             )
 * **/
@Composable
fun DsInput(
    modifier: Modifier = Modifier,
    label: String? = null,
    hint: String,
    text: String,
    isCompact: Boolean,
    isError: Boolean,
    isEnabled: Boolean,
    errorLabel: String? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    inputType: InputType? = null,
    @DrawableRes iconRes: Int? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    iconPosition: IconPosition? = null,
    onValueChange: (String) -> Unit,
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }
    val iconColor = if (isEnabled) {
        ColorToken.text_input_icon_color_enabled
    } else {
        ColorToken.text_input_icon_color_disabled
    }
    var focus by remember { mutableStateOf(false) }

    Column {
        label?.let {
            Text(
                modifier = modifier,
                text = it,
                style = if (isCompact) {
                    FontToken.body_xs_medium
                } else {
                    FontToken.body_sm_medium
                },
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Start,
                color = ColorToken.content_primary,
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
        TextField(
            modifier = modifier
                .sizeIn(maxHeight = if (isCompact) 44.dp else 56.dp)
                .clip(RoundedCornerShape(8.dp))
                .border(
                    border = BorderStroke(
                        1.dp,
                        color = when {
                            isError -> ColorToken.border_invalid

                            focus -> {
                                ColorToken.text_input_focused_border_color
                            }

                            else -> {
                                ColorToken.text_input_indicator_color
                            }
                        },
                    ),
                    shape = RoundedCornerShape(8.dp),
                )
                .onFocusChanged { focus = it.isFocused },
            leadingIcon = if (iconPosition == IconPosition.Leading) {
                {
                    iconRes?.let {
                        InputIcon(
                            iconRes,
                            iconColor,
                            iconPadding = if (isCompact) {
                                (8.dp)
                            } else {
                                12.dp
                            },
                        )
                    }
                }
            } else {
                null
            },
            trailingIcon = when {
                inputType is InputType.Password -> {
                    {
                        inputType.PasswordTrailingIcon(
                            isVisible = passwordVisible,
                            isError = isError,
                        ) {
                            passwordVisible = !passwordVisible
                        }
                    }
                }

                isError -> {
                    {
                        InputType.Error.ErrorTrailingIcon(isVisible = true, errorLabel = errorLabel)
                    }
                }

                inputType is InputType.Clear -> if (text.isNotEmpty()) {
                    {
                        inputType.ClearTrailingIcon(inputType.iconRes, isError) {
                            onValueChange(
                                "",
                            )
                        }
                    }
                } else {
                    null
                }

                iconPosition == IconPosition.Trailing -> {
                    {
                        iconRes?.let {
                            InputIcon(
                                iconRes,
                                iconColor,
                                iconPadding = if (isCompact) {
                                    (8.dp)
                                } else {
                                    12.dp
                                },
                            )
                        }
                    }
                }

                else -> null
            },
            onValueChange = onValueChange,
            value = text.ifEmpty { hint },
            textStyle = if (isCompact) {
                FontToken.body_xs_regular
            } else {
                FontToken.body_sm_regular
            },
            colors = inputColors(text.isEmpty()),
            enabled = isEnabled,
            singleLine = true,
            visualTransformation = when (inputType) {
                is InputType.Password -> {
                    if (passwordVisible || text.isEmpty()) visualTransformation else PasswordVisualTransformation()
                }

                else -> visualTransformation
            },
            keyboardOptions = keyboardOptions,
        )
    }
}

/**
 *
 * DsValueInput composable for displaying and inserting currency values for the user.
 * For DsValueInput:
 * @param label text to be displayed as a label above the input.
 * @param value text to be displayed as the current value.
 * @param isError Boolean to determine if the value input is correct/incorrect.
 * @param isEnabled Boolean to determine if the value input is enabled/disabled.
 * @param onValueChange listener to take actions when the value has changed.

 * **Example:**
 *
 *             ValueInput(
 *               label = "Insert Value",
 *               isError = false,
 *               onValueChange = { value -> setValue(value) },
 *             )
 */
@Composable
fun DsValueInput(
    modifier: Modifier = Modifier,
    label: String = "",
    value: String = "",
    isError: Boolean = false,
    isEnabled: Boolean = true,
    currency: Currency = Currency.BRL(),
    onValueChange: (String) -> Unit,
) {
    var focus by remember { mutableStateOf(false) }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = label,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = FontToken.body_lg_medium,
            color = ColorToken.content_secondary,
            textAlign = TextAlign.Start,
        )

        Spacer(modifier = Modifier.height(16.dp))
        BasicTextField(
            modifier = Modifier
                .drawBehind {
                    val verticalOffset = size.height
                    if (isEnabled) {
                        drawLine(
                            color = if (isError) {
                                ColorToken.border_invalid
                            } else {
                                if (focus) {
                                    ColorToken.content_brand_medium
                                } else {
                                    ColorToken.border_default
                                }
                            },
                            strokeWidth = 1.dp.toPx(),
                            start = Offset(0f, verticalOffset),
                            end = Offset(size.width, verticalOffset),
                        )
                    }
                }
                .onFocusChanged {
                    focus = it.isFocused
                },
            singleLine = true,
            value = value,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            onValueChange = { newValue ->
                if (newValue.isDigitsOnly()) {
                    if (newValue.length == 1 && newValue == "0") {
                        onValueChange("")
                    } else {
                        onValueChange(newValue)
                    }
                }
            },
            visualTransformation = CurrencyRightToLeftVisualTransformation(currency),
            textStyle = when {
                isEnabled && focus -> {
                    FontToken.heading_md_medium.copy(color = ColorToken.content_primary)
                }

                isEnabled -> {
                    FontToken.heading_md_medium.copy(ColorToken.content_secondary)
                }

                else -> {
                    FontToken.heading_md_medium.copy(ColorToken.content_disabled)
                }
            },
            enabled = isEnabled,
        )
    }
}

/**
 * Defines the IconPosition for DsInput.
 *
 * **Available Icons**
 *
 * * **Trailing:** Icon shown at the end of the Input.
 * * **Leading:** Icon shown at the beginning of the Input.
 */
enum class IconPosition {
    Trailing,
    Leading,
    None,
}

@Composable
private fun InputIcon(iconRes: Int, iconColor: Color, iconPadding: Dp) {
    HorizontalSpacer(iconPadding)
    Icon(
        modifier = Modifier.size(16.dp),
        painter = painterResource(id = iconRes),
        contentDescription = null,
        tint = iconColor,
    )
    HorizontalSpacer(iconPadding)
}

@Composable
private fun inputColors(isTextEmpty: Boolean) = TextFieldDefaults.colors(
    focusedTextColor = ColorToken.content_primary,
    unfocusedTextColor = if (isTextEmpty) ColorToken.content_tertiary else ColorToken.content_primary,
    disabledTextColor = ColorToken.text_input_disabled_content,
    errorTextColor = ColorToken.content_primary,
    focusedContainerColor = ColorToken.input_background_color,
    unfocusedContainerColor = ColorToken.input_background_color,
    disabledContainerColor = ColorToken.background_disabled,
    errorContainerColor = ColorToken.input_background_color,
    cursorColor = ColorToken.content_primary,
    errorCursorColor = ColorToken.content_primary,
    focusedIndicatorColor = ColorToken.text_input_transparent_indicator,
    unfocusedIndicatorColor = ColorToken.text_input_transparent_indicator,
    disabledIndicatorColor = ColorToken.text_input_transparent_indicator,
    errorIndicatorColor = ColorToken.content_primary,
    focusedLeadingIconColor = ColorToken.content_primary,
    unfocusedLeadingIconColor = ColorToken.content_primary,
    disabledLeadingIconColor = ColorToken.text_input_disabled_icon_color,
    errorLeadingIconColor = ColorToken.content_primary,
    focusedTrailingIconColor = ColorToken.content_primary,
    unfocusedTrailingIconColor = ColorToken.content_primary,
    disabledTrailingIconColor = ColorToken.text_input_disabled_icon_color,
    errorTrailingIconColor = ColorToken.content_primary,
    focusedLabelColor = ColorToken.content_primary,
    unfocusedLabelColor = ColorToken.content_primary,
    disabledLabelColor = ColorToken.content_primary,
    errorLabelColor = ColorToken.content_primary,
    focusedPlaceholderColor = ColorToken.content_primary,
    unfocusedPlaceholderColor = ColorToken.content_primary,
    disabledPlaceholderColor = ColorToken.text_input_disabled_content,
    errorPlaceholderColor = ColorToken.content_primary,
    focusedSupportingTextColor = ColorToken.content_primary,
    unfocusedSupportingTextColor = ColorToken.content_primary,
    disabledSupportingTextColor = ColorToken.content_primary,
    errorSupportingTextColor = ColorToken.content_primary,
    focusedPrefixColor = ColorToken.content_primary,
    unfocusedPrefixColor = ColorToken.content_primary,
    disabledPrefixColor = ColorToken.content_primary,
    errorPrefixColor = ColorToken.content_primary,
    focusedSuffixColor = ColorToken.content_primary,
    unfocusedSuffixColor = ColorToken.content_primary,
    disabledSuffixColor = ColorToken.content_primary,
    errorSuffixColor = ColorToken.content_primary,
)

sealed class InputType {
    data object Password : InputType() {
        @Composable
        fun PasswordTrailingIcon(isVisible: Boolean, isError: Boolean, onClick: () -> Unit) {
            IconButton(onClick = onClick) {
                Icon(
                    modifier = Modifier.size(22.dp),
                    painter = painterResource(
                        id = if (isVisible) {
                            R.drawable.ic_show_pass
                        } else {
                            R.drawable.ic_hide_pass
                        },
                    ),
                    tint = if (isError) ColorToken.content_alert_error else ColorToken.text_input_icon_color_enabled,
                    contentDescription = null,
                )
            }
        }
    }

    open class Clear(open val iconRes: Int = R.drawable.ic_close) : InputType() {
        @Composable
        fun ClearTrailingIcon(iconRes: Int, isError: Boolean, onClick: () -> Unit) {
            IconButton(onClick = onClick) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(id = iconRes),
                    tint = if (isError) ColorToken.content_alert_error else ColorToken.text_input_icon_color_enabled,
                    contentDescription = null,
                )
            }
        }
    }

    data object Error : InputType() {
        @Composable
        fun ErrorTrailingIcon(isVisible: Boolean, errorLabel: String?) {
            if (isVisible) {
                IconTapToShowText(
                    modifier = Modifier.size(18.dp),
                    painter = painterResource(id = R.drawable.ic_info),
                    text = errorLabel ?: "Error",
                    tint = ColorToken.content_alert_error,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TextInputWithLabelPreview() {
    DesignSystemTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(ColorToken.content_white),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var textInsert by remember { mutableStateOf("") }
            repeat(9) { index ->
                when (index) {
                    0 -> DsInput(
                        label = "Compact Not Filled",
                        hint = "PlaceHolder",
                        text = textInsert,
                        isCompact = true,
                        isError = false,
                        isEnabled = true,
                        iconRes = R.drawable.ic_lock,
                        iconPosition = IconPosition.Leading,
                        onValueChange = { textInsert = it },
                    )

                    1 -> DsInput(
                        label = "Compact Filled",
                        hint = "PlaceHolder",
                        text = "Text inserted",
                        isCompact = true,
                        isError = false,
                        isEnabled = true,
                        onValueChange = { textInsert = it },
                    )

                    2 -> DsInput(
                        label = "Compact Disabled",
                        hint = "Hint text",
                        text = "",
                        isCompact = true,
                        isError = false,
                        isEnabled = false,
                        iconRes = R.drawable.ic_info,
                        iconPosition = IconPosition.Trailing,
                        onValueChange = {},
                    )

                    3 -> DsInput(
                        label = "Compact Disabled",
                        hint = "",
                        text = "Text filled",
                        isCompact = true,
                        isError = false,
                        isEnabled = false,
                        onValueChange = {},
                    )

                    4 -> DsInput(
                        label = "Compact Invalid Input",
                        hint = "",
                        text = textInsert,
                        isCompact = true,
                        isError = true,
                        isEnabled = true,
                        onValueChange = { textInsert = it },
                    )

                    5 -> DsInput(
                        label = "Default Not Filled",
                        hint = "PlaceHolder",
                        text = textInsert,
                        isCompact = false,
                        isError = false,
                        isEnabled = true,
                        onValueChange = { textInsert = it },
                    )

                    6 -> DsInput(
                        label = "Default Filled",
                        hint = "PlaceHolder",
                        text = textInsert,
                        isCompact = false,
                        isError = false,
                        isEnabled = true,
                        onValueChange = { textInsert = it },
                    )

                    7 -> DsInput(
                        hint = "password",
                        text = "",
                        isCompact = true,
                        isError = false,
                        isEnabled = true,
                        inputType = InputType.Password,
                        onValueChange = {},
                    )

                    else -> DsInput(
                        hint = "password",
                        text = "232232322",
                        isCompact = false,
                        isError = false,
                        isEnabled = true,
                        inputType = InputType.Password,
                        onValueChange = {},
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DsTextInputWithPlaceHolderTest() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
            .background(ColorToken.content_white),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var textToBeInserted by remember { mutableStateOf("") }

        repeat(1) { index ->
            when (index) {
                0 -> DsInput(
                    label = "Insert the text to display",
                    hint = "No Text Inserted Yet",
                    text = textToBeInserted,
                    isCompact = true,
                    isError = false,
                    isEnabled = true,
                    iconRes = R.drawable.ic_lock,
                    iconPosition = IconPosition.Leading,
                    onValueChange = {
                        textToBeInserted = it
                    },
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DsValueInputTest() {
    Column(
        modifier = Modifier
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
            .background(ColorToken.content_white),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        var value by remember { mutableStateOf("") }

        repeat(1) { index ->
            when (index) {
                0 -> DsValueInput(
                    label = "Amount",
                    value = value,
                    isError = false,
                    isEnabled = true,
                    onValueChange = {
                        value = it
                    },
                )
            }
        }
    }
}