package com.cassiobruzasco.design_system.components.button

import androidx.annotation.DrawableRes
import androidx.compose.foundation.shape.CircleShape

data class AlertDefaultButton(
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
    DsButtonColor.AlertButtonColor,
)

data class AlertRoundDefaultButton(
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
    DsButtonColor.AlertButtonColor,
    shape = CircleShape,
)

data class AlertCompactButton(
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
    DsButtonColor.AlertButtonColor,
)

data class AlertRoundCompactButton(
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
    DsButtonColor.AlertButtonColor,
    shape = CircleShape,
)

data class IconAlertDefaultButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconLg,
    DsButtonColor.AlertButtonColor,
)

data class IconAlertRoundDefaultButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconLg,
    DsButtonColor.AlertButtonColor,
    shape = CircleShape,
)

data class IconAlertMediumButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconMd,
    DsButtonColor.AlertButtonColor,
)

data class IconAlertRoundMediumButton(
    @DrawableRes override val iconRes: Int,
    override val isDisabled: Boolean = false,
    override val isLoading: Boolean = false,
) : DsButtonStyle(
    iconRes,
    null,
    isDisabled,
    isLoading,
    DsButtonSize.IconMd,
    DsButtonColor.AlertButtonColor,
    shape = CircleShape,
)