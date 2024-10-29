package com.cassiobruzasco.design_system.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.CircleShape

data class GhostDefaultButton(
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
    DsButtonColor.GhostButtonColor,
)

data class GhostRoundDefaultButton(
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
    DsButtonColor.GhostButtonColor,
    shape = CircleShape,
)

data class GhostCompactButton(
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
    DsButtonColor.GhostButtonColor,
)

data class GhostRoundCompactButton(
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
    DsButtonColor.GhostButtonColor,
    shape = CircleShape,
)

data class IconGhostDefaultButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconLg,
    DsButtonColor.GhostButtonColor,
)

data class IconGhostRoundDefaultButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconLg,
    DsButtonColor.GhostButtonColor,
    shape = CircleShape,
)

data class IconGhostMediumButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconMd,
    DsButtonColor.GhostButtonColor,
)

data class IconGhostRoundMediumButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconMd,
    DsButtonColor.GhostButtonColor,
    shape = CircleShape,
)