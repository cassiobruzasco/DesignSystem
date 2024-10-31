package com.cassiobruzasco.designsystem

import com.cassiobruzasco.design_system.components.button.AlertDefaultButton
import com.cassiobruzasco.design_system.components.button.DsButtonIconPosition
import com.cassiobruzasco.design_system.components.button.DsButtonStyle
import com.cassiobruzasco.design_system.components.button.GhostDefaultButton
import com.cassiobruzasco.design_system.components.button.PrimaryDefaultButton
import com.cassiobruzasco.design_system.components.button.SecondaryDefaultButton
import com.cassiobruzasco.design_system.components.input.Currency
import com.cassiobruzasco.design_system.components.input.IconPosition
import com.cassiobruzasco.design_system.components.input.InputType

sealed class ComponentModel {

    data class Button(
        val icon: Int,
        val iconPosition: DsButtonIconPosition? = null,
        val isDisabled: Boolean = false,
        val isLoading: Boolean = false,
        val isCompact: Boolean = false,
    ) : ComponentModel() {
        val listOfStyles : List<DsButtonStyle> = listOf(
            PrimaryDefaultButton(icon, iconPosition, isDisabled, isLoading, isCompact),
            SecondaryDefaultButton(icon, iconPosition, isDisabled, isLoading, isCompact),
            GhostDefaultButton(icon, iconPosition, isDisabled, isLoading, isCompact),
            AlertDefaultButton(icon, iconPosition, isDisabled, isLoading, isCompact),
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