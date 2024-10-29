package com.cassiobruzasco.design_system.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.CircleShape

data class PrimaryDefaultButton(
    @DrawableRes override val iconRes: Int? = null,
    override val iconPosition: DsButtonIconPosition? = null,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    iconPosition,
    isDisabled,
    isLoading,
    DsButtonSize.Default,
    DsButtonColor.PrimaryButtonColor,
)

data class PrimaryRoundDefaultButton(
    @DrawableRes override val iconRes: Int? = null,
    override val iconPosition: DsButtonIconPosition? = null,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    iconPosition,
    isDisabled,
    isLoading,
    DsButtonSize.Default,
    DsButtonColor.PrimaryButtonColor,
    shape = CircleShape,
)

data class PrimaryCompactButton(
    @DrawableRes override val iconRes: Int? = null,
    override val iconPosition: DsButtonIconPosition? = null,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    iconPosition,
    isDisabled,
    isLoading,
    DsButtonSize.Compact,
    DsButtonColor.PrimaryButtonColor,
)

data class PrimaryRoundCompactButton(
    @DrawableRes override val iconRes: Int? = null,
    override val iconPosition: DsButtonIconPosition? = null,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    iconPosition,
    isDisabled,
    isLoading,
    DsButtonSize.Compact,
    DsButtonColor.PrimaryButtonColor,
    shape = CircleShape,
)

data class IconPrimaryDefaultButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconLg,
    DsButtonColor.PrimaryButtonColor,
)

data class IconPrimaryRoundDefaultButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconLg,
    DsButtonColor.PrimaryButtonColor,
    shape = CircleShape,
)

data class IconPrimaryMediumButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconMd,
    DsButtonColor.PrimaryButtonColor,
)

data class IconPrimaryRoundMediumButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconMd,
    DsButtonColor.PrimaryButtonColor,
    shape = CircleShape,
)