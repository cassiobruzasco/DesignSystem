package com.cassiobruzasco.design_system.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.CircleShape

data class PrimaryDefaultButton(
    @DrawableRes override val iconRes: Int? = null,
    override val iconPosition: DsButtonIconPosition? = null,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
    override val isCompact: Boolean = false
) : DsButtonStyle(
    iconRes,
    iconPosition,
    isDisabled,
    isLoading,
    isCompact,
    DsButtonColor.PrimaryButtonColor,
)

data class GhostDefaultButton(
    @DrawableRes override val iconRes: Int? = null,
    override val iconPosition: DsButtonIconPosition? = null,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
    override val isCompact: Boolean = false
) : DsButtonStyle(
    iconRes,
    iconPosition,
    isDisabled,
    isLoading,
    isCompact,
    DsButtonColor.GhostButtonColor,
)


data class SecondaryDefaultButton(
    @DrawableRes override val iconRes: Int? = null,
    override val iconPosition: DsButtonIconPosition? = null,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
    override val isCompact: Boolean = false
) : DsButtonStyle(
    iconRes,
    iconPosition,
    isDisabled,
    isLoading,
    isCompact,
    DsButtonColor.SecondaryButtonColor,
)


data class AlertDefaultButton(
    @DrawableRes override val iconRes: Int? = null,
    override val iconPosition: DsButtonIconPosition? = null,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
    override val isCompact: Boolean = false
) : DsButtonStyle(
    iconRes,
    iconPosition,
    isDisabled,
    isLoading,
    isCompact,
    DsButtonColor.AlertButtonColor,
)
