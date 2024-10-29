package com.cassiobruzasco.design_system.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.CircleShape

data class SecondaryDefaultButton(
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
    DsButtonColor.SecondaryButtonColor,
)

data class SecondaryRoundDefaultButton(
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
    DsButtonColor.SecondaryButtonColor,
    shape = CircleShape,
)

data class SecondaryCompactButton(
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
    DsButtonColor.SecondaryButtonColor,
)

data class SecondaryRoundCompactButton(
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
    DsButtonColor.SecondaryButtonColor,
    shape = CircleShape,
)

data class IconSecondaryDefaultButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconLg,
    DsButtonColor.SecondaryButtonColor,
)

data class IconSecondaryRoundDefaultButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconLg,
    DsButtonColor.SecondaryButtonColor,
    shape = CircleShape,
)

data class IconSecondaryMediumButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconMd,
    DsButtonColor.SecondaryButtonColor,
)

data class IconSecondaryRoundMediumButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconMd,
    DsButtonColor.SecondaryButtonColor,
    shape = CircleShape,
)