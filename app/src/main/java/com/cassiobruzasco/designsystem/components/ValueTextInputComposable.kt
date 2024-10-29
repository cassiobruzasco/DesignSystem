package com.cassiobruzasco.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.designsystem.ComponentModel
import com.cassiobruzasco.design_system.components.dropdown.DropdownItem
import com.cassiobruzasco.design_system.components.dropdown.DsDropDown
import com.cassiobruzasco.design_system.components.input.Currency
import com.cassiobruzasco.design_system.components.input.DsValueInput

@Composable
internal fun ValueTextInputComposable(
    item: ComponentModel.ValueInput,
    setError: (Boolean) -> Unit,
    setIsEnabled: (Boolean) -> Unit,
    setCurrency: (Currency) -> Unit,
) {
    var selectedCurrency by remember { mutableIntStateOf(0) }
    var value by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DsValueInput(
            modifier = Modifier.padding(horizontal = 20.dp),
            label = "Demo Value Input",
            value = value,
            isError = item.isError,
            isEnabled = item.isEnabled,
            currency = item.currency
        ) {
            value = it
        }

        Spacer(Modifier.height(30.dp))

        DsDropDown(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp),
            items = item.currencyList.map { DropdownItem(it.javaClass.simpleName) },
            hintText = item.currencyList[selectedCurrency].javaClass.simpleName
        ) {
            selectedCurrency = it
            setCurrency(item.currencyList[it])
        }

        DsDropDown(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp),
            items = listOf(
                DropdownItem("true"),
                DropdownItem("false"),
            ),
            hintText = "isError"
        ) {
            setError(it == 0)
        }

        DsDropDown(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp),
            items = listOf(
                DropdownItem("true"),
                DropdownItem("false"),
            ),
            hintText = "isEnabled"
        ) {
            setIsEnabled(it == 0)
        }
    }
}