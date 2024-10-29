package com.cassiobruzasco.designsystem

import com.cassiobruzasco.design_system.components.button.AlertCompactButton
import com.cassiobruzasco.design_system.components.button.AlertDefaultButton
import com.cassiobruzasco.design_system.components.button.AlertRoundCompactButton
import com.cassiobruzasco.design_system.components.button.AlertRoundDefaultButton
import com.cassiobruzasco.design_system.components.button.DsButtonIconPosition
import com.cassiobruzasco.design_system.components.button.DsButtonStyle
import com.cassiobruzasco.design_system.components.button.GhostCompactButton
import com.cassiobruzasco.design_system.components.button.GhostDefaultButton
import com.cassiobruzasco.design_system.components.button.GhostRoundCompactButton
import com.cassiobruzasco.design_system.components.button.GhostRoundDefaultButton
import com.cassiobruzasco.design_system.components.button.IconAlertDefaultButton
import com.cassiobruzasco.design_system.components.button.IconAlertMediumButton
import com.cassiobruzasco.design_system.components.button.IconAlertRoundDefaultButton
import com.cassiobruzasco.design_system.components.button.IconAlertRoundMediumButton
import com.cassiobruzasco.design_system.components.button.IconGhostDefaultButton
import com.cassiobruzasco.design_system.components.button.IconGhostMediumButton
import com.cassiobruzasco.design_system.components.button.IconGhostRoundDefaultButton
import com.cassiobruzasco.design_system.components.button.IconGhostRoundMediumButton
import com.cassiobruzasco.design_system.components.button.IconPrimaryDefaultButton
import com.cassiobruzasco.design_system.components.button.IconPrimaryMediumButton
import com.cassiobruzasco.design_system.components.button.IconPrimaryRoundDefaultButton
import com.cassiobruzasco.design_system.components.button.IconPrimaryRoundMediumButton
import com.cassiobruzasco.design_system.components.button.IconSecondaryDefaultButton
import com.cassiobruzasco.design_system.components.button.IconSecondaryMediumButton
import com.cassiobruzasco.design_system.components.button.IconSecondaryRoundDefaultButton
import com.cassiobruzasco.design_system.components.button.IconSecondaryRoundMediumButton
import com.cassiobruzasco.design_system.components.button.PrimaryCompactButton
import com.cassiobruzasco.design_system.components.button.PrimaryDefaultButton
import com.cassiobruzasco.design_system.components.button.PrimaryRoundCompactButton
import com.cassiobruzasco.design_system.components.button.PrimaryRoundDefaultButton
import com.cassiobruzasco.design_system.components.button.SecondaryCompactButton
import com.cassiobruzasco.design_system.components.button.SecondaryDefaultButton
import com.cassiobruzasco.design_system.components.button.SecondaryRoundCompactButton
import com.cassiobruzasco.design_system.components.button.SecondaryRoundDefaultButton
import com.cassiobruzasco.design_system.components.input.Currency
import com.cassiobruzasco.design_system.components.input.IconPosition
import com.cassiobruzasco.design_system.components.input.InputType

sealed class ComponentModel {

    data class Button(
        val icon: Int,
        val iconPosition: DsButtonIconPosition? = null,
        val isDisabled: Boolean = false,
        val isLoading: Boolean = false
    ) : ComponentModel() {
        val listOfStyles : List<DsButtonStyle> = listOf(
            PrimaryDefaultButton(icon, iconPosition, isDisabled, isLoading),
            PrimaryRoundDefaultButton(icon, iconPosition, isDisabled, isLoading),
            PrimaryCompactButton(icon, iconPosition, isDisabled, isLoading),
            PrimaryRoundCompactButton(icon, iconPosition, isDisabled, isLoading),
            IconPrimaryDefaultButton(icon, isDisabled, isLoading),
            IconPrimaryRoundDefaultButton(icon, isDisabled, isLoading),
            IconPrimaryMediumButton(icon, isDisabled, isLoading),
            IconPrimaryRoundMediumButton(icon, isDisabled, isLoading),
            SecondaryDefaultButton(icon, iconPosition, isDisabled, isLoading),
            SecondaryRoundDefaultButton(icon, iconPosition, isDisabled, isLoading),
            SecondaryCompactButton(icon, iconPosition, isDisabled, isLoading),
            SecondaryRoundCompactButton(icon, iconPosition, isDisabled, isLoading),
            IconSecondaryDefaultButton(icon, isDisabled, isLoading),
            IconSecondaryRoundDefaultButton(icon, isDisabled, isLoading),
            IconSecondaryMediumButton(icon, isDisabled, isLoading),
            IconSecondaryRoundMediumButton(icon, isDisabled, isLoading),
            GhostDefaultButton(icon, iconPosition, isDisabled, isLoading),
            GhostRoundDefaultButton(icon, iconPosition, isDisabled, isLoading),
            GhostCompactButton(icon, iconPosition, isDisabled, isLoading),
            GhostRoundCompactButton(icon, iconPosition, isDisabled, isLoading),
            IconGhostDefaultButton(icon, isDisabled, isLoading),
            IconGhostRoundDefaultButton(icon, isDisabled, isLoading),
            IconGhostMediumButton(icon, isDisabled, isLoading),
            IconGhostRoundMediumButton(icon, isDisabled, isLoading),
            AlertDefaultButton(icon, iconPosition, isDisabled, isLoading),
            AlertRoundDefaultButton(icon, iconPosition, isDisabled, isLoading),
            AlertCompactButton(icon, iconPosition, isDisabled, isLoading),
            AlertRoundCompactButton(icon, iconPosition, isDisabled, isLoading),
            IconAlertDefaultButton(icon, isDisabled, isLoading),
            IconAlertRoundDefaultButton(icon, isDisabled, isLoading),
            IconAlertMediumButton(icon, isDisabled, isLoading),
            IconAlertRoundMediumButton(icon, isDisabled, isLoading),
        )
    }

    data class TextInput(
        val inputType: InputType? = null,
        val isCompact: Boolean = false,
        val isEnabled: Boolean = true,
        val isError: Boolean = false,
        val icon: Int,
        var iconPosition: IconPosition = IconPosition.None,
    ) : ComponentModel() {
        val inputTypes : List<InputType?> = listOf(
            null,
            InputType.Password,
            InputType.Clear(),
        )
    }

    data class ValueInput(
        val isError: Boolean = false,
        val isEnabled: Boolean = true,
        val currency: Currency = Currency.BRL(),
    ) : ComponentModel() {
        val currencyList = listOf(
            Currency.BRL(),
            Currency.USD(),
            Currency.EUR(),
        )
    }

    data object Pager : ComponentModel()

    data object Shimmer : ComponentModel()
}