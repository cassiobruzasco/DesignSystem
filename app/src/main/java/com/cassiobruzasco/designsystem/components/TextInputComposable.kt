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
import com.cassiobruzasco.design_system.components.input.DsInput
import com.cassiobruzasco.design_system.components.input.IconPosition
import com.cassiobruzasco.design_system.components.input.InputType

@Composable
internal fun TextInputComposable(
    item: ComponentModel.TextInput,
    setError: (Boolean) -> Unit,
    setIsEnabled: (Boolean) -> Unit,
    setIsCompact: (Boolean) -> Unit,
    setInputType: (InputType?) -> Unit,
    setIconPosition: (IconPosition) -> Unit,
) {
    var selectInputType by remember { mutableIntStateOf(0) }
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        DsInput(
            modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
            label = "Demo Text Input",
            text = text,
            isCompact = item.isCompact,
            isError = item.isError,
            isEnabled = item.isEnabled,
            inputType = item.inputType,
            iconRes = item.icon,
            iconPosition = item.iconPosition,
            hint = ""
        ) {
            text = it
        }

        Spacer(Modifier.height(30.dp))

        DsDropDown(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp),
            items = item.inputTypes.map { DropdownItem(it?.javaClass?.simpleName ?: "No Type") },
            hintText = item.inputTypes[selectInputType]?.javaClass?.simpleName ?: "Select Input Type",
        ) {
            selectInputType = it
            setInputType(item.inputTypes[it])
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

        DsDropDown(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp),
            items = listOf(
                DropdownItem("true"),
                DropdownItem("false"),
            ),
            hintText = "isCompact"
        ) {
            setIsCompact(it == 0)
        }

        DsDropDown(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp),
            items = listOf(
                DropdownItem("Leading"),
                DropdownItem("Trailing"),
                DropdownItem("None"),
            ),
            hintText = "Icon Position"
        ) {
            when (it) {
                0 -> setIconPosition(IconPosition.Leading)
                1 -> setIconPosition(IconPosition.Trailing)
                2 -> setIconPosition(IconPosition.None)
                else -> Unit
            }
        }
    }
}