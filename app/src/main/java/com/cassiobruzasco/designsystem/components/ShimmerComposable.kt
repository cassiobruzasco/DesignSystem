package com.cassiobruzasco.designsystem.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.design_system.components.button.DsButton
import com.cassiobruzasco.design_system.components.button.PrimaryDefaultButton
import com.cassiobruzasco.design_system.components.dropdown.DropdownItem
import com.cassiobruzasco.design_system.components.dropdown.DsDropDown
import com.cassiobruzasco.design_system.components.shimmer.DsShimmer
import com.cassiobruzasco.design_system.theme.ColorToken
import com.cassiobruzasco.design_system.theme.FontToken
import kotlinx.coroutines.delay

@Composable
internal fun ShimmerComposable() {
    var showShimmer by remember { mutableStateOf(true) }
    LaunchedEffect(showShimmer) {
        if (showShimmer) {
            delay(4000)
            showShimmer = false
        }
    }
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showShimmer) {
            DsShimmer(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .height(40.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            DsShimmer(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(horizontal = 20.dp)
                    .height(20.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            DsShimmer(
                modifier = Modifier
                    .fillMaxWidth(0.45f)
                    .height(50.dp)
            )
            Spacer(modifier = Modifier.height(40.dp))
        } else {
            DsDropDown(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                items = listOf(),
                hintText = "Disabled for demo",
                enabled = false
            ) {}
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                text = "Text After Shimmer",
                style = FontToken.body_lg_medium,
                color = ColorToken.content_brand_medium,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(20.dp))
            DsButton(
                text = "Reanimate",
                style = PrimaryDefaultButton()
            ) {
                showShimmer = true
            }
            Spacer(modifier = Modifier.height(40.dp))
        }
    }
}