package com.cassiobruzasco.design_system.components.shimmer

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.design_system.theme.ColorToken

@Composable
fun DsShimmer(
    modifier: Modifier = Modifier,
) {
    val transition = rememberInfiniteTransition(label = "")

    val translateAnimation = transition.animateFloat(
        initialValue = 0f,
        targetValue = (durationMillis + widthOfShadowBrush).toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = durationMillis,
                easing = LinearEasing,
            ),
            repeatMode = RepeatMode.Restart,
        ),
        label = "Shimmer loading animation",
    )

    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(x = translateAnimation.value - widthOfShadowBrush, y = 0.0f),
        end = Offset(x = translateAnimation.value, y = angleOfAxisY),
    )

    Box(modifier = modifier) {
        Spacer(
            modifier = Modifier
                .matchParentSize()
                .background(brush, shape = RoundedCornerShape(4.dp)),
        )
    }
}

private const val durationMillis: Int = 1000
private const val widthOfShadowBrush: Int = 700
private const val angleOfAxisY: Float = 270f

private val shimmerColors = listOf(
    ColorToken.content_white,
    ColorToken.background_neutral_lighter,
    ColorToken.background_neutral_light,
    ColorToken.background_neutral_lighter,
    ColorToken.content_white,
)

@Preview(showBackground = true)
@Composable
private fun ShimmerPreview() {
    DsShimmer(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
    )
}