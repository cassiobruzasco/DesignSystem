package com.cassiobruzasco.design_system.components.bottomsheet

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.design_system.R
import com.cassiobruzasco.design_system.clickInteraction
import com.cassiobruzasco.design_system.theme.ColorToken
import com.cassiobruzasco.design_system.theme.DesignSystemTheme
import com.cassiobruzasco.design_system.theme.FontToken
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DsBottomSheet(
    title: String,
    hasCloseIcon: Boolean,
    openBottomSheet: Boolean,
    onDismiss: () -> Unit,
    bottomSheetState: SheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
    ),
    customCloseAction: suspend () -> Unit = {},
    content: @Composable ColumnScope.() -> Unit,
) {
    val scope = rememberCoroutineScope()
    if (openBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            containerColor = ColorToken.background_primary,
            sheetState = bottomSheetState,
            dragHandle = null,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp, 30.dp, 30.dp, 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = title,
                    style = FontToken.heading_xs_bold,
                    color = ColorToken.content_primary,
                )
                if (hasCloseIcon) {
                    Image(
                        modifier = Modifier
                            .clickInteraction(
                                shape = CircleShape,
                            ) {
                                scope
                                    .launch {
                                        customCloseAction()
                                        bottomSheetState.hide()
                                    }
                                    .invokeOnCompletion {
                                        if (!bottomSheetState.isVisible) {
                                            onDismiss()
                                        }
                                    }
                            }
                            .padding(5.dp),
                        alignment = Alignment.CenterEnd,
                        painter = painterResource(id = R.drawable.ic_close),
                        contentDescription = null,
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            content()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
private fun DsBottomSheetPreview() {
    DesignSystemTheme {
        DsBottomSheet(
            title = "Title",
            hasCloseIcon = true,
            openBottomSheet = true,
            onDismiss = {},
            customCloseAction = {},
            content = {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    text = "Here\nGoes\nThe\nContent",
                    style = FontToken.body_sm_medium,
                    color = ColorToken.content_primary,
                    textAlign = TextAlign.Center,
                )
            },
        )
    }
}