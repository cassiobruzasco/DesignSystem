package com.cassiobruzasco.design_system.components.dropdown

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.design_system.R
import com.cassiobruzasco.design_system.clickInteraction
import com.cassiobruzasco.design_system.components.button.DsButton
import com.cassiobruzasco.design_system.components.button.DsButtonIconPosition
import com.cassiobruzasco.design_system.components.button.PrimaryDefaultButton
import com.cassiobruzasco.design_system.theme.ColorToken
import com.cassiobruzasco.design_system.theme.FontToken

@Composable
fun DsDropDown(
    modifier: Modifier = Modifier,
    items: List<DropdownItem>,
    topLabel: String? = null,
    hintText: String,
    selectedIndex: Int = -1,
    enabled: Boolean = true,
    onValueChange: (Int) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    val hasIcon = items.any { it.iconRes != null }
    Column(
        modifier = modifier.alpha(if (enabled) 1f else 0.3f),
    ) {
        topLabel?.let {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                text = it,
                style = FontToken.body_sm_medium,
                color = ColorToken.content_primary,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Spacer(modifier = Modifier.height(5.dp))
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    width = 1.dp,
                    color = ColorToken.content_brand_medium,
                    shape = roundEdgeShape,
                )
                .height(44.dp),
            contentAlignment = Alignment.CenterStart,
        ) {
            DropdownRow(
                item = if (selectedIndex < 0) DropdownItem(hintText) else items[selectedIndex],
                index = selectedIndex,
                isSelected = true,
            ) {
                if (enabled) expanded = true
            }
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier
                .clip(rectShape)
                .border(1.dp, ColorToken.border_neutral_soft, rectShape)
                .background(ColorToken.background_primary, rectShape)
                .fillMaxWidth(0.9f),
        ) {
            items.forEachIndexed { index, row ->
                DropdownMenuItem(
                    modifier = Modifier.height(32.dp),
                    onClick = {
                        onValueChange(index)
                        expanded = false
                    },
                    text = {
                        DropdownRow(
                            item = row,
                            index = index,
                            hasIcon = hasIcon,
                            onValueChange = {
                                onValueChange(it)
                                expanded = false
                            },
                        )
                    },
                )
                if (index != items.lastIndex) {
                    HorizontalDivider(
                        modifier = Modifier.fillMaxWidth(),
                        color = ColorToken.border_neutral_lighter,
                    )
                }
            }
        }
    }
}

@Composable
fun DsButtonDropdown(
    items: List<DropdownItem>,
    buttonText: String,
    isCompactButton: Boolean = false,
    isDisabled: Boolean = false,
    onValueChange: (Int) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }
    DsButton(
        text = buttonText,
        style = if (isCompactButton) {
            PrimaryDefaultButton(
                isCompact = true,
                iconRes = R.drawable.ic_arrow_down,
                iconPosition = DsButtonIconPosition.TrailingIcon,
                isDisabled = isDisabled,
            )
        } else {
            PrimaryDefaultButton(
                iconRes = R.drawable.ic_arrow_down,
                iconPosition = DsButtonIconPosition.TrailingIcon,
                isDisabled = isDisabled,
            )
        },
    ) {
        expanded = true
    }

    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false },
        modifier = Modifier
            .clip(rectShape)
            .border(1.dp, ColorToken.border_neutral_soft, rectShape)
            .background(ColorToken.background_primary, rectShape)
            .fillMaxWidth(0.9f),
    ) {
        items.forEachIndexed { index, row ->
            DropdownMenuItem(
                modifier = Modifier.height(32.dp),
                onClick = {
                    onValueChange(index)
                    expanded = false
                },
                text = {
                    DropdownRow(
                        item = row,
                        index = index,
                        onValueChange = {
                            onValueChange(it)
                            expanded = false
                        },
                    )
                },
            )
            if (index != items.lastIndex) {
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    color = ColorToken.border_neutral_lighter,
                )
            }
        }
    }
}

@Composable
private fun DropdownRow(
    item: DropdownItem,
    index: Int,
    isSelected: Boolean = false,
    hasIcon: Boolean = false,
    onValueChange: (Int) -> Unit,
) {
    val modifier = if (!isSelected) {
        Modifier
    } else {
        Modifier
            .clickInteraction(
                bgColor = ColorToken.background_primary,
                bgColorPressed = Color.Transparent,
                onClick = { onValueChange(index) },
            )
    }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start,
    ) {
        if (!isSelected) {
            item.iconRes?.let {
                Icon(
                    modifier = Modifier
                        .sizeIn(maxHeight = 24.dp, maxWidth = 44.dp)
                        .padding(end = 12.dp),
                    painter = painterResource(id = it),
                    contentDescription = null,
                    tint = ColorToken.content_secondary,
                )
            }
        }
        Text(
            modifier = Modifier
                .padding(horizontal = if (item.iconRes == null && !isSelected && hasIcon) 28.dp else 0.dp)
                .weight(1f),
            text = item.itemText,
            style = FontToken.body_md_regular,
            color = ColorToken.content_secondary,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )
        if (isSelected) {
            Icon(
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(12.dp),
                painter = painterResource(id = R.drawable.ic_arrow_down),
                contentDescription = null,
            )
        }
    }
}

/**
 * Data class representing an item in the [DsDropDown] composable.
 *
 * @param itemText The main text displayed for the item.
 * @param iconRes The resource ID of an icon to display for the item (optional).
 */
data class DropdownItem(
    val itemText: String,
    @DrawableRes val iconRes: Int? = null,
)

/**
 * Constant for the rounded corner shape used in [DsDropDown].
 */
private val roundEdgeShape = RoundedCornerShape(12.dp)
private val rectShape = RoundedCornerShape(8.dp)

@Preview(showBackground = true)
@Composable
private fun DsDropDownPreview() {
    val previewItems = listOf(
        DropdownItem(
            "First item",
        ),
        DropdownItem(
            "Second item",
        ),
        DropdownItem(
            "Third item",
        ),
    )

    val previewButtonItems = listOf(
        DropdownItem(
            "First item",
            iconRes = R.drawable.ic_check_simple,
        ),
        DropdownItem(
            "Second item",
            iconRes = R.drawable.ic_check_simple,
        ),
        DropdownItem(
            "Third item",
        ),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
    ) {
        Column {
            var currentItem by remember { mutableIntStateOf(1) }
            var currentItem2 by remember { mutableIntStateOf(0) }
            DsDropDown(
                modifier = Modifier.fillMaxWidth(),
                topLabel = "Top Label",
                hintText = "Select",
                items = previewItems,
                selectedIndex = currentItem,
                enabled = true,
                onValueChange = { currentItem = it },
            )

            Spacer(modifier = Modifier.height(44.dp))
            DsButtonDropdown(
                items = previewButtonItems,
                buttonText = "Action",
                isCompactButton = false,
            ) {
                currentItem2 = it
            }
        }
    }
}