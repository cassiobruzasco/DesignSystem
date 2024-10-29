import com.cassiobruzasco.designsystem.R

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.cassiobruzasco.design_system.components.button.DsButton
import com.cassiobruzasco.design_system.components.button.PrimaryRoundDefaultButton
import com.cassiobruzasco.design_system.components.pager.DsPager
import com.cassiobruzasco.design_system.theme.ColorToken
import com.cassiobruzasco.design_system.theme.FontToken

@Composable
internal fun PagerComposable(
    pagerState: PagerState = rememberPagerState { 3 },
    dismiss: () -> Unit
) {

    DsPager(
        modifier = Modifier.fillMaxHeight(0.4f),
        pagerState = pagerState
    ) {
        Box(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column {
                when (pagerState.currentPage) {
                    0 -> FirstPage()
                    1 -> SecondPage()
                    2 -> ThirdPage(dismiss)
                    else -> Unit
                }
            }
        }
    }
}

@Composable
private fun FirstPage() {
    Icon(painter = painterResource(id = R.drawable.ic_cog), contentDescription = null)
    Text(
        modifier = Modifier,
        text = "Pager - First Page",
        style = FontToken.heading_xs_bold,
        color = ColorToken.content_primary,
        textAlign = TextAlign.Center
    )
}

@Composable
private fun SecondPage() {
        Icon(painter = painterResource(id = R.drawable.ic_cog), contentDescription = null)
        Text(
            text = "Pager - Second Page",
            style = FontToken.heading_xs_bold,
            color = ColorToken.content_primary,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier.padding(top = 10.dp),
            text = "Here you can add\nany content you want",
            style = FontToken.body_md_regular,
            color = ColorToken.content_primary,
            textAlign = TextAlign.Center
        )
}

@Composable
private fun ThirdPage(
    dismiss: () -> Unit
) {
        Icon(painter = painterResource(id = R.drawable.ic_cog), contentDescription = null)
        Text(
            text = "Pager - Third Page",
            style = FontToken.heading_xs_bold,
            color = ColorToken.content_primary,
            textAlign = TextAlign.Center
        )

        DsButton(
            modifier = Modifier.padding(top = 10.dp),
            text = "Close",
            style = PrimaryRoundDefaultButton(),
            onClick = dismiss
        )
}