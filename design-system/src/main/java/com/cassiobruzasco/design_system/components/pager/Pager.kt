package com.cassiobruzasco.design_system.components.pager

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.design_system.theme.ColorToken
import com.cassiobruzasco.design_system.theme.DesignSystemTheme

/**
 * NsPager composable for displaying a horizontal pager with indicators.
 *
 * This composable provides a convenient way to display a horizontally scrollable pager
 * with page indicators. It uses the `HorizontalPager` composable from Jetpack Compose
 * and adds indicator functionality.
 *
 * @param modifier Modifier to be applied to the pager container.
 * @param pageCount Number of pages in the pager.
 * @param pagerState [PagerState] to control the pager's state.
 * @param pageContent Content for each page in the pager.
 *
 * **Example:**
 *
 *          NsPager(
 *              pageCount = 4,
 *              pagerState = rememberPagerState(),
 *              pageContent = { page ->
 *                  Text(text = "Page $page")
 *              }
 *          )
 *
 */
@Composable
fun DsPager(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pageContent: @Composable PagerScope.(page: Int) -> Unit,
) {
    Column(
        modifier = modifier
            .padding(20.dp),
    ) {
        HorizontalPager(
            modifier = Modifier.weight(1f),
            state = pagerState,
            pageNestedScrollConnection = PagerDefaults.pageNestedScrollConnection(pagerState, Orientation.Horizontal),
            pageContent = { page ->
                AnimatedVisibility(
                    visible = pagerState.currentPage == page,
                    enter = fadeIn(),
                    exit = fadeOut(),
                ) {
                    pageContent(page)
                }
            },
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom,
        ) {
            repeat(pagerState.pageCount) { index ->
                PagerIndicator(isSelected = index == pagerState.currentPage)
                Spacer(modifier = Modifier.width(5.dp))
            }
        }
    }
}

@Composable
private fun PagerIndicator(isSelected: Boolean) {
    val color by animateColorAsState(
        targetValue = if (isSelected) ColorToken.content_brand_medium else ColorToken.content_neutral_light,
        label = "",
    )

    val width by animateDpAsState(
        targetValue = if (isSelected) 20.dp else 8.dp,
        label = "",
    )
    Box(
        modifier = Modifier
            .size(width = width, height = 8.dp)
            .clip(CircleShape)
            .background(color),
    )
}

@Preview(showBackground = true)
@Composable
private fun NsPagerPreview() {
    DesignSystemTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            DsPager(
                pagerState = rememberPagerState { 4 },
            ) {
                val color = when (it) {
                    0 -> ColorToken.content_alert_error
                    1 -> ColorToken.background_alert_info
                    2 -> ColorToken.content_alert_warning
                    else -> ColorToken.content_alert_success
                }
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color),
                    text = "Page $it \n content goes here",
                    textAlign = TextAlign.Center,
                )
            }
        }
    }
}