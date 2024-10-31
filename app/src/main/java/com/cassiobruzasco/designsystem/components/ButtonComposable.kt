package com.cassiobruzasco.designsystem.components

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.designsystem.ComponentModel
import com.cassiobruzasco.design_system.components.button.DsButton
import com.cassiobruzasco.design_system.components.button.DsButtonIconPosition
import com.cassiobruzasco.design_system.components.dropdown.DropdownItem
import com.cassiobruzasco.design_system.components.dropdown.DsDropDown

@Composable
internal fun ButtonComposable(
    item: ComponentModel.Button,
    setLoading: (Boolean) -> Unit,
    setDisabled: (Boolean) -> Unit,
    setIconPosition: (DsButtonIconPosition?) -> Unit,
    setCompact: (Boolean) -> Unit,
) {
    var selectStyle by remember { mutableIntStateOf(0) }
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DsButton(
            modifier = Modifier
                .padding(20.dp),
            text = "Demo Button",
            style = item.listOfStyles[selectStyle]
        ) {
            Toast.makeText(context, "Button Clicked", Toast.LENGTH_SHORT).show()
        }

        DsDropDown(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp),
            items = item.listOfStyles.map { DropdownItem(it.javaClass.simpleName) },
            hintText = item.listOfStyles[selectStyle].javaClass.simpleName
        ) {
            selectStyle = it
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
                0 -> setIconPosition(DsButtonIconPosition.LeadingIcon)
                1 -> setIconPosition(DsButtonIconPosition.TrailingIcon)
                2 -> setIconPosition(null)
                else -> Unit
            }
        }

        DsDropDown(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp),
            items = listOf(
                DropdownItem("true"),
                DropdownItem("false"),
            ),
            hintText = "isLoading"
        ) {
            setLoading(it == 0)
        }

        DsDropDown(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp),
            items = listOf(
                DropdownItem("true"),
                DropdownItem("false"),
            ),
            hintText = "isDisabled"
        ) {
            setDisabled(it == 0)
        }

        DsDropDown(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 30.dp),
            items = listOf(
                DropdownItem("true"),
                DropdownItem("false"),
            ),
            hintText = "isCompact"
        ) {
            setCompact(it == 0)
        }
    }
}