package com.cassiobruzasco.designsystem

import PagerComposable
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.designsystem.components.ButtonComposable
import com.cassiobruzasco.design_system.components.bottomsheet.DsBottomSheet
import com.cassiobruzasco.design_system.components.button.DsButton
import com.cassiobruzasco.design_system.components.button.PrimaryDefaultButton
import com.cassiobruzasco.design_system.components.toast.DsToast
import com.cassiobruzasco.design_system.components.toast.ToastDuration
import com.cassiobruzasco.design_system.components.toast.ToastState
import com.cassiobruzasco.design_system.components.toast.ToastType
import com.cassiobruzasco.design_system.theme.ColorToken
import com.cassiobruzasco.design_system.theme.FontToken
import com.cassiobruzasco.designsystem.components.ShimmerComposable
import com.cassiobruzasco.designsystem.components.TextInputComposable
import com.cassiobruzasco.designsystem.components.ValueTextInputComposable
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var toast by remember {
                mutableStateOf<ToastState?>(null)
            }
            val toastState = ToastState(
                title = "Toast demo!",
                body = "This is an example of how toasts look and how they animate from the top of the screen.",
                toastType = ToastType.NEUTRAL,
                duration = ToastDuration.Short,
                isVisible = false,
                onClick = {
                    toast = toast?.copy(isVisible = false)
                }
            )

            LaunchedEffect(Unit) {
                toast = toastState
            }

            var toastStyleCount by remember { mutableIntStateOf(0) }

            LaunchedEffect(toast, toastStyleCount) {
                toast?.let {
                    when (toastStyleCount) {
                        1 -> toast = it.copy(toastType = ToastType.NEUTRAL)
                        2 -> toast = it.copy(toastType = ToastType.INFO)
                        3 -> toast = it.copy(toastType = ToastType.INFO_ACCENT_LEFT)
                        4 -> toast = it.copy(toastType = ToastType.INFO_ACCENT_TOP)
                        5 -> toast = it.copy(toastType = ToastType.INFO_FILLED)
                        6 -> toast = it.copy(toastType = ToastType.SUCCESS)
                        7 -> toast = it.copy(toastType = ToastType.SUCCESS_ACCENT_LEFT)
                        8 -> toast = it.copy(toastType = ToastType.SUCCESS_ACCENT_TOP)
                        9 -> toast = it.copy(toastType = ToastType.SUCCESS_FILLED)
                        10 -> toast = it.copy(toastType = ToastType.WARNING)
                        11 -> toast = it.copy(toastType = ToastType.WARNING_ACCENT_LEFT)
                        12 -> toast = it.copy(toastType = ToastType.WARNING_ACCENT_TOP)
                        13 -> toast = it.copy(toastType = ToastType.WARNING_FILLED)
                        14 -> toast = it.copy(toastType = ToastType.ERROR)
                        15 -> toast = it.copy(toastType = ToastType.ERROR_ACCENT_LEFT)
                        16 -> toast = it.copy(toastType = ToastType.ERROR_ACCENT_TOP)
                        17 -> toast = it.copy(toastType = ToastType.ERROR_FILLED)
                        else -> toast = it.copy(toastType = ToastType.NEUTRAL)
                    }
                    if (it.isVisible) {
                        delay(it.duration.time)
                        toast = it.copy(isVisible = false)
                    }
                }
            }
            DemoActivityContent {
                toast = toast?.copy(isVisible = true)
                toastStyleCount++
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 40.dp)
            ) {
                toast?.let {
                    DsToast(toast = it)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DemoActivityContent(
    showToast: () -> Unit = {}
) {
    var currentItemSelected by remember { mutableStateOf<ComponentModel?>(null) }
    val icon = com.cassiobruzasco.design_system.R.drawable.ic_lock

    val listOfComponent by remember {
        mutableStateOf(
            listOf(
                ComponentModel.Button(icon = icon),
                ComponentModel.Pager,
                ComponentModel.Shimmer,
                ComponentModel.TextInput(icon = icon),
                ComponentModel.ValueInput()
            )
        )
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            DsButton(
                modifier = Modifier.sizeIn(maxWidth = 90.dp),
                text = "Toast",
                style = PrimaryDefaultButton(isCompact = true)
            ) {
                showToast()
            }
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    text = "Design System Demo App",
                    style = FontToken.heading_lg_bold,
                    color = ColorToken.content_brand_medium,
                    textAlign = TextAlign.Center
                )
            }
            item {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    text = "Pick one Component to test",
                    style = FontToken.heading_xs_bold,
                    color = ColorToken.content_primary,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(20.dp))
            }
            items(listOfComponent) { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 10.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier
                            .drawBehind {
                                val strokeWidth = 2.dp.toPx()
                                val verticalOffset = size.height - strokeWidth
                                drawLine(
                                    color = ColorToken.content_brand_medium,
                                    strokeWidth = strokeWidth,
                                    start = Offset(0f, verticalOffset),
                                    end = Offset(size.width, verticalOffset)
                                )
                            }
                            .clickable {
                                currentItemSelected = item
                            },
                        text = item.javaClass.simpleName,
                        style = FontToken.heading_xs_bold,
                        color = ColorToken.content_primary,
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }

    DsBottomSheet(
        title = currentItemSelected?.javaClass?.simpleName.orEmpty(),
        hasCloseIcon = true,
        openBottomSheet = currentItemSelected != null,
        onDismiss = { currentItemSelected = null }
    ) {

        when (val item = currentItemSelected) {
            is ComponentModel.Button -> {
                ButtonComposable(
                    item = item,
                    setLoading = { currentItemSelected = item.copy(isLoading = it) },
                    setDisabled = { currentItemSelected = item.copy(isDisabled = it) },
                    setIconPosition = { currentItemSelected = item.copy(iconPosition = it) },
                    setCompact = { currentItemSelected = item.copy(isCompact = it) },
                )
            }

            is ComponentModel.TextInput -> {
                TextInputComposable(
                    item = item,
                    setError = { currentItemSelected = item.copy(isError = it) },
                    setIsEnabled = { currentItemSelected = item.copy(isEnabled = it) },
                    setIsCompact = { currentItemSelected = item.copy(isCompact = it) },
                    setInputType = { currentItemSelected = item.copy(inputType = it) },
                    setIconPosition = { currentItemSelected = item.copy(iconPosition = it) }
                )
            }

            is ComponentModel.ValueInput -> {
                ValueTextInputComposable(
                    item = item,
                    setError = { currentItemSelected = item.copy(isError = it) },
                    setIsEnabled = { currentItemSelected = item.copy(isEnabled = it) },
                    setCurrency = { currentItemSelected = item.copy(currency = it) }
                )
            }

            is ComponentModel.Pager -> PagerComposable { currentItemSelected = null }

            is ComponentModel.Shimmer -> ShimmerComposable()

            else -> Unit
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoActivityPreview() {
    DemoActivityContent()
}