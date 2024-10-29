package com.cassiobruzasco.design_system.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.cassiobruzasco.design_system.R

val roboto = FontFamily(
    Font(R.font.roboto_bold, FontWeight.W700),
    Font(R.font.roboto_medium, FontWeight.W500),
    Font(R.font.roboto_regular, FontWeight.W400),
)

private val roboto_style = TextStyle(fontFamily = roboto)
private val roboto_regular = roboto_style.copy(fontWeight = FontWeight.W400)
private val roboto_medium = roboto_style.copy(fontWeight = FontWeight.W500)
private val roboto_bold = roboto_style.copy(fontWeight = FontWeight.W700)

data object FontToken {
    /** Heading XXL */
    val heading_xxl_regular = roboto_regular.copy(fontSize = 60.sp, lineHeight = 72.sp, letterSpacing = 0.sp)
    val heading_xxl_medium = roboto_medium.copy(fontSize = 60.sp, lineHeight = 72.sp, letterSpacing = 0.sp)
    val heading_xxl_bold = roboto_bold.copy(fontSize = 60.sp, lineHeight = 72.sp, letterSpacing = 0.sp)

    /** Heading XL */
    val heading_xl_regular = roboto_regular.copy(fontSize = 48.sp, lineHeight = 54.sp, letterSpacing = 0.sp)
    val heading_xl_medium = roboto_medium.copy(fontSize = 48.sp, lineHeight = 54.sp, letterSpacing = 0.sp)
    val heading_xl_bold = roboto_bold.copy(fontSize = 48.sp, lineHeight = 54.sp, letterSpacing = 0.sp)

    /** Heading LG */
    val heading_lg_regular = roboto_regular.copy(fontSize = 36.sp, lineHeight = 40.sp, letterSpacing = 0.sp)
    val heading_lg_medium = roboto_medium.copy(fontSize = 36.sp, lineHeight = 40.sp, letterSpacing = 0.sp)
    val heading_lg_bold = roboto_bold.copy(fontSize = 36.sp, lineHeight = 40.sp, letterSpacing = 0.sp)

    /** Heading MD */
    val heading_md_regular = roboto_regular.copy(fontSize = 28.sp, lineHeight = 36.sp, letterSpacing = 0.sp)
    val heading_md_medium = roboto_medium.copy(fontSize = 28.sp, lineHeight = 36.sp, letterSpacing = 0.sp)
    val heading_md_bold = roboto_bold.copy(fontSize = 28.sp, lineHeight = 36.sp, letterSpacing = 0.sp)

    /** Heading SM */
    val heading_sm_regular = roboto_regular.copy(fontSize = 24.sp, lineHeight = 32.sp, letterSpacing = 0.sp)
    val heading_sm_medium = roboto_medium.copy(fontSize = 24.sp, lineHeight = 32.sp, letterSpacing = 0.sp)
    val heading_sm_bold = roboto_bold.copy(fontSize = 24.sp, lineHeight = 32.sp, letterSpacing = 0.sp)

    /** Heading XS */
    val heading_xs_regular = roboto_regular.copy(fontSize = 20.sp, lineHeight = 28.sp, letterSpacing = 0.sp)
    val heading_xs_medium = roboto_medium.copy(fontSize = 20.sp, lineHeight = 28.sp, letterSpacing = 0.sp)
    val heading_xs_bold = roboto_bold.copy(fontSize = 20.sp, lineHeight = 28.sp, letterSpacing = 0.sp)

    /** Body LG */
    val body_lg_regular = roboto_regular.copy(fontSize = 18.sp, lineHeight = 24.sp, letterSpacing = 0.3.sp)
    val body_lg_medium = roboto_medium.copy(fontSize = 18.sp, lineHeight = 24.sp, letterSpacing = 0.3.sp)
    val body_lg_bold = roboto_bold.copy(fontSize = 18.sp, lineHeight = 24.sp, letterSpacing = 0.3.sp)

    /** Body MD */
    val body_md_regular = roboto_regular.copy(fontSize = 16.sp, lineHeight = 22.sp, letterSpacing = 0.3.sp)
    val body_md_medium = roboto_medium.copy(fontSize = 16.sp, lineHeight = 22.sp, letterSpacing = 0.3.sp)
    val body_md_bold = roboto_bold.copy(fontSize = 16.sp, lineHeight = 22.sp, letterSpacing = 0.3.sp)

    /** Body SM */
    val body_sm_regular = roboto_regular.copy(fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.3.sp)
    val body_sm_medium = roboto_medium.copy(fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.3.sp)
    val body_sm_bold = roboto_bold.copy(fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.3.sp)

    /** Body XS */
    val body_xs_regular = roboto_regular.copy(fontSize = 12.sp, lineHeight = 18.sp, letterSpacing = 0.3.sp)
    val body_xs_medium = roboto_medium.copy(fontSize = 12.sp, lineHeight = 18.sp, letterSpacing = 0.3.sp)
    val body_xs_bold = roboto_bold.copy(fontSize = 12.sp, lineHeight = 18.sp, letterSpacing = 0.3.sp)

    /** Detail LG */
    val detail_lg_regular = roboto_regular.copy(fontSize = 18.sp, lineHeight = 26.sp, letterSpacing = 0.3.sp)
    val detail_lg_medium = roboto_medium.copy(fontSize = 18.sp, lineHeight = 26.sp, letterSpacing = 0.3.sp)
    val detail_lg_bold = roboto_bold.copy(fontSize = 18.sp, lineHeight = 26.sp, letterSpacing = 0.3.sp)

    /** Detail MD */
    val detail_md_regular = roboto_regular.copy(fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.3.sp)
    val detail_md_medium = roboto_medium.copy(fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.3.sp)
    val detail_md_bold = roboto_bold.copy(fontSize = 16.sp, lineHeight = 24.sp, letterSpacing = 0.3.sp)

    /** Detail SM */
    val detail_sm_regular = roboto_regular.copy(fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.3.sp)
    val detail_sm_medium = roboto_medium.copy(fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.3.sp)
    val detail_sm_bold = roboto_bold.copy(fontSize = 14.sp, lineHeight = 20.sp, letterSpacing = 0.3.sp)

    /** Detail XS */
    val detail_xs_regular = roboto_regular.copy(fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.3.sp)
    val detail_xs_medium = roboto_medium.copy(fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.3.sp)
    val detail_xs_bold = roboto_bold.copy(fontSize = 12.sp, lineHeight = 16.sp, letterSpacing = 0.3.sp)
}

private val baseline = Typography()
val Typography = Typography(
    displayLarge = baseline.displayLarge.copy(fontFamily = roboto),
    displayMedium = baseline.displayMedium.copy(fontFamily = roboto),
    displaySmall = baseline.displaySmall.copy(fontFamily = roboto),
    headlineLarge = baseline.headlineLarge.copy(fontFamily = roboto),
    headlineMedium = baseline.headlineMedium.copy(fontFamily = roboto),
    headlineSmall = baseline.headlineSmall.copy(fontFamily = roboto),
    titleLarge = baseline.titleLarge.copy(fontFamily = roboto),
    titleMedium = baseline.titleMedium.copy(fontFamily = roboto),
    titleSmall = baseline.titleSmall.copy(fontFamily = roboto),
    bodyLarge = baseline.bodyLarge.copy(fontFamily = roboto),
    bodyMedium = baseline.bodyMedium.copy(fontFamily = roboto),
    bodySmall = baseline.bodySmall.copy(fontFamily = roboto),
    labelLarge = baseline.labelLarge.copy(fontFamily = roboto),
    labelMedium = baseline.labelMedium.copy(fontFamily = roboto),
    labelSmall = baseline.labelSmall.copy(fontFamily = roboto),
)