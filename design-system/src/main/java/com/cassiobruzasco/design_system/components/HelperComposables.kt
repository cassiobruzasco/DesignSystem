package com.cassiobruzasco.design_system.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import com.cassiobruzasco.design_system.clickInteraction
import com.cassiobruzasco.design_system.theme.ColorToken
import com.cassiobruzasco.design_system.theme.FontToken
import kotlinx.coroutines.delay

@Composable
fun IconTapToShowText(
    modifier: Modifier = Modifier,
    painter: Painter,
    text: String,
    contentDescription: String? = null,
    tint: Color = LocalContentColor.current,
) {
    var show by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(show) {
        if (show) delay(2000)
        show = false
    }

    Box(
        modifier = modifier.clickInteraction(
            shape = CircleShape,
        ) {
            show = !show
        },
    ) {
        Icon(
            painter = painter,
            contentDescription = contentDescription,
            tint = tint,
        )
        AnimatedVisibility(
            visible = show,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            Popup(
                offset = IntOffset(x = 20, y = -45),
            ) {
                Card(
                    shape = RoundedCornerShape(6.dp),
                    elevation = CardDefaults.elevatedCardElevation(defaultElevation = 6.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = ColorToken.background_alert_error_light,
                    ),
                ) {
                    Text(
                        modifier = Modifier.padding(3.dp),
                        text = text,
                        maxLines = 1,
                        style = FontToken.detail_xs_regular,
                        overflow = TextOverflow.Ellipsis,
                    )
                }
            }
        }
    }
}