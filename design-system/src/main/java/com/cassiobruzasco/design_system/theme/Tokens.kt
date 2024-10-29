package com.cassiobruzasco.design_system.theme

data object BrandToken {
    val brand_light_50 = MainBrandToken.main_050
    val brand_light_100 = MainBrandToken.main_100
    val brand_light_200 = MainBrandToken.main_200
    val brand_light_300 = MainBrandToken.main_300
    val brand_light_400 = MainBrandToken.main_400
    val brand_light_500 = MainBrandToken.main_500
    val brand_light_600 = MainBrandToken.main_600
    val brand_light_700 = MainBrandToken.main_700
    val brand_light_800 = MainBrandToken.main_800
    val brand_light_900 = MainBrandToken.main_900
}

data object ColorToken {
    /**
     * Content Tokens
     */
    val content_brand_minimal = BrandToken.brand_light_50
    val content_brand_lightest = BrandToken.brand_light_100
    val content_brand_lighter = BrandToken.brand_light_200
    val content_brand_light = BrandToken.brand_light_300
    val content_brand_soft = BrandToken.brand_light_400
    val content_brand_medium = BrandToken.brand_light_500
    val content_brand_heavy = BrandToken.brand_light_600
    val content_brand_dark = BrandToken.brand_light_700
    val content_brand_darker = BrandToken.brand_light_800
    val content_brand_darkest = BrandToken.brand_light_900
    val content_primary = SystemNeutral.neutral_800
    val content_secondary = SystemNeutral.neutral_700
    val content_tertiary = SystemNeutral.neutral_500
    val content_inverted = SystemNeutral.neutral_50
    val content_disabled = SystemNeutral.neutral_400
    val content_white = SystemNeutral.white
    val content_black = SystemNeutral.black
    val content_brand_text_default = content_primary
    val content_neutral_minimal = SystemNeutral.neutral_50
    val content_neutral_lightest = SystemNeutral.neutral_100
    val content_neutral_lighter = SystemNeutral.neutral_200
    val content_neutral_light = SystemNeutral.neutral_300
    val content_neutral_soft = SystemNeutral.neutral_400
    val content_neutral_medium = SystemNeutral.neutral_500
    val content_neutral_heavy = SystemNeutral.neutral_600
    val content_neutral_dark = SystemNeutral.neutral_700
    val content_neutral_darker = SystemNeutral.neutral_800
    val content_neutral_maximal = SystemNeutral.neutral_900
    val content_transparent = SystemNeutral.transparent

    /**
     * Alert Tokens
     */
    val content_alert_info = SystemBlue.blue_500
    val content_alert_success = SystemGreen.green_500
    val content_alert_warning = SystemYellow.yellow_500
    val content_alert_error = SystemRed.red_500

    /**
     * Accent Tokens
     */
    val content_accent_pink = SystemPink.pink_500
    val content_accent_pink_lightest = SystemPink.pink_100
    val content_accent_pink_medium = SystemPink.pink_500
    val content_accent_pink_heavy = SystemPink.pink_600
    val content_accent_pink_darker = SystemPink.pink_800
    val content_accent_blue = SystemBlue.blue_500
    val content_accent_blue_lightest = SystemBlue.blue_100
    val content_accent_blue_lighter = SystemBlue.blue_200
    val content_accent_blue_medium = SystemBlue.blue_500
    val content_accent_blue_darker = SystemBlue.blue_800
    val content_accent_green = SystemGreen.green_500
    val content_accent_green_lightest = SystemGreen.green_100
    val content_accent_green_lighter = SystemGreen.green_200
    val content_accent_green_medium = SystemGreen.green_600
    val content_accent_green_darker = SystemGreen.green_800
    val content_accent_yellow = SystemYellow.yellow_500
    val content_accent_yellow_lightest = SystemYellow.yellow_100
    val content_accent_yellow_lighter = SystemYellow.yellow_200
    val content_accent_yellow_medium = SystemYellow.yellow_500
    val content_accent_yellow_heavy = SystemYellow.yellow_600
    val content_accent_red = SystemRed.red_500
    val content_accent_red_lightest = SystemRed.red_100
    val content_accent_red_medium = SystemRed.red_500
    val content_accent_red_darker = SystemRed.red_800
    val content_accent_teal = SystemTeal.teal_500
    val content_accent_teal_lightest = SystemTeal.teal_100
    val content_accent_teal_lighter = SystemTeal.teal_200
    val content_accent_teal_medium = SystemTeal.teal_500
    val content_accent_teal_heavy = SystemTeal.teal_600
    val content_accent_teal_darker = SystemTeal.teal_800
    val content_accent_cyan_lightest = SystemCyan.cyan_100
    val content_accent_cyan_lighter = SystemCyan.cyan_200
    val content_accent_cyan_medium = SystemCyan.cyan_500
    val content_accent_cyan_darker = SystemCyan.cyan_800
    val content_accent_cyan = SystemCyan.cyan_500
    val content_accent_purple = SystemPurple.purple_500
    val content_accent_purple_lightest = SystemPurple.purple_100
    val content_accent_purple_lighter = SystemPurple.purple_200
    val content_accent_purple_medium = SystemPurple.purple_500
    val content_accent_purple_heavy = SystemPurple.purple_600
    val content_accent_purple_dark = SystemPurple.purple_700
    val content_accent_purple_darker = SystemPurple.purple_800
    val content_accent_orange_lightest = SystemOrange.orange_100

    /**
     * Background Tokens
     */
    val background_brand_lightest = BrandToken.brand_light_100
    val background_brand_lighter = BrandToken.brand_light_200
    val background_brand_light = BrandToken.brand_light_300
    val background_brand_medium = BrandToken.brand_light_500
    val background_brand_heavy = BrandToken.brand_light_600
    val background_brand_dark = BrandToken.brand_light_700
    val background_primary = SystemNeutral.white
    val background_secondary = SystemNeutral.neutral_100
    val background_inverted = SystemNeutral.neutral_800
    val background_disabled = SystemNeutral.neutral_300
    val background_neutral_minimal = SystemNeutral.neutral_50
    val background_neutral_lightest = SystemNeutral.neutral_100
    val background_neutral_lighter = SystemNeutral.neutral_200
    val background_neutral_light = SystemNeutral.neutral_300
    val background_neutral_soft = SystemNeutral.neutral_400
    val background_neutral_medium = SystemNeutral.neutral_500

    /**
     * Background Alert Tokens
     */
    val background_alert_info_lightest = SystemBlue.blue_100
    val background_alert_info = SystemBlue.blue_500
    val background_alert_success_lightest = SystemGreen.green_100
    val background_alert_success = SystemGreen.green_500
    val background_alert_warning_lightest = SystemYellow.yellow_100
    val background_alert_warning = SystemYellow.yellow_600
    val background_alert_error_lightest = SystemRed.red_100
    val background_alert_error_light = SystemRed.red_300
    val background_alert_error = SystemRed.red_500
    val background_alert_error_heavy = SystemRed.red_600

    /**
     * Background Accent Tokens
     */
    val background_accent_purple_lightest = SystemPurple.purple_100
    val background_accent_purple = SystemPurple.purple_500
    val background_accent_teal_lightest = SystemTeal.teal_100
    val background_accent_teal = SystemTeal.teal_500
    val background_accent_pink_lightest = SystemPink.pink_100
    val background_accent_pink = SystemPink.pink_500

    /**
     * Border Tokens
     */
    val border_brand = BrandToken.brand_light_500
    val border_primary = SystemNeutral.neutral_800
    val border_secondary = SystemNeutral.neutral_400
    val border_inverted = SystemNeutral.white
    val border_invalid = SystemRed.red_500
    val border_neutral_lighter = SystemNeutral.neutral_200
    val border_neutral_light = SystemNeutral.neutral_300
    val border_neutral_soft = SystemNeutral.neutral_400
    val border_neutral_medium = SystemNeutral.neutral_500
    val border_neutral_dark = SystemNeutral.neutral_700
    val border_default = SystemNeutral.neutral_400
    val border_active = BrandToken.brand_light_500

    /**
     * Border Alert Tokens
     */
    val border_alert_info = SystemBlue.blue_500
    val border_alert_success = SystemGreen.green_500
    val border_alert_warning = SystemYellow.yellow_600
    val border_alert_error = SystemRed.red_500

    /**
     * Border Accent Tokens
     */
    val border_accent_blue = SystemBlue.blue_500
    val border_accent_teal = SystemTeal.teal_500
    val border_accent_green = SystemGreen.green_500
    val border_accent_red = SystemRed.red_500
    val border_accent_purple = SystemPurple.purple_500
    val border_accent_purple_dark = SystemPurple.purple_700
    val border_accent_pink = SystemPink.pink_500
    val border_accent_yellow = SystemYellow.yellow_500
    val border_accent_cyan = SystemCyan.cyan_500
    /**
     * Primary Button Tokens
     */
    /** Background Tokens */
    val button_primary_background_default = background_brand_medium
    val button_primary_background_pressed = background_brand_heavy
    val button_primary_background_disabled = background_disabled
    val button_primary_background_loading = background_brand_light

    /** Text Tokens */
    val button_primary_text_default = content_inverted
    val button_primary_text_disabled = content_disabled

    /** Icon Tokens */
    val button_primary_icon_default = content_inverted
    val button_primary_icon_disabled = content_disabled
    val button_primary_icon_loading = content_inverted
    /**
     * Secondary Button Tokens
     */
    /** Background Tokens */
    val button_secondary_background_pressed = background_neutral_minimal
    val button_secondary_background_disabled = background_disabled

    /** Border Tokens */
    val button_secondary_border_default = border_primary
    val button_secondary_border_disabled = border_neutral_medium
    val button_secondary_border_loading = border_neutral_soft

    /** Text Tokens */
    val button_secondary_text_default = content_primary
    val button_secondary_text_disabled = content_disabled

    /** Icon Tokens */
    val button_secondary_icon_default = content_primary
    val button_secondary_icon_disabled = content_disabled
    val button_secondary_icon_loading = content_neutral_soft
    /**
     * Ghost Button Tokens
     */
    /** Background Tokens */
    val button_ghost_background_pressed = background_brand_lightest
    val button_ghost_background_disabled = background_disabled

    /** Text Tokens */
    val button_ghost_text_default = content_brand_medium
    val button_ghost_text_disabled = content_disabled

    /** Icon Tokens */
    val button_ghost_icon_default = content_brand_medium
    val button_ghost_icon_disabled = content_disabled
    val button_ghost_icon_loading = content_brand_soft
    /**
     * Link Button Tokens
     */
    /** Text Tokens */
    val button_link_text_default = content_brand_medium
    val button_link_text_pressed = content_brand_heavy
    val button_link_text_disabled = content_disabled

    /** Icon Tokens */
    val button_link_icon_default = content_brand_medium
    val button_link_icon_pressed = content_brand_heavy
    val button_link_icon_disabled = content_disabled
    val button_link_icon_loading = content_brand_soft
    /**
     * Critical Primary Button Tokens
     */
    /** Background Tokens */
    val button_critical_primary_background_default = background_alert_error
    val button_critical_primary_background_pressed = background_alert_error_heavy
    val button_critical_primary_background_disabled = background_disabled
    val button_critical_primary_background_loading = background_alert_error_light

    /** Text Tokens */
    val button_critical_primary_text_default = content_white
    val button_critical_primary_text_disabled = content_disabled

    /**
     * Checkbox Tokens
     *
     */
    /** ColorBox Tokens */
    val checkbox_box_color_default = content_white
    val checkbox_box_color_disabled = background_neutral_light
    val checkbox_box_color_checked = button_primary_background_default

    /** Checkmark Color Tokens */
    val checkbox_checkmark_color_enabled = content_white
    val checkbox_checkmark_color_disabled = background_neutral_soft
    val checkbox_checkmark_color_unchecked = background_disabled

    /** Checkbox Stroke Color Tokens */
    val checkbox_enabled_unchecked_stroke_color = content_brand_darkest
    val checkbox_disabled_unchecked_stroke_color = content_disabled
    val checkbox_disabled_checked_stroke_color = content_white

    /**
     * Text input Tokens
     *
     */
    /** Text Color Tokens */
    val input_background_color = content_white
    val text_input_disabled_content = content_neutral_medium
    val text_input_indicator_color = border_secondary
    val text_input_transparent_indicator = content_transparent
    val text_input_icon_color_enabled = content_neutral_heavy
    val text_input_icon_color_disabled = content_neutral_soft
    val text_input_disabled_icon_color = content_disabled
    val text_input_focused_border_color = content_brand_medium

    /**
     * Radio button Tokens
     *
     */
    /** Background Tokens */
    val radio_button_background_default = background_primary
    val radio_button_background_checked = background_brand_medium
    val radio_button_background_disabled = background_neutral_lighter
    val radio_button_background_disabled_checked = background_neutral_soft

    /** Stroke Tokens */
    val radio_button_stroke_default = content_primary
    val radio_button_stroke_checked = content_brand_medium
    val radio_button_stroke_disabled = content_neutral_light

    /** Text Tokens */
    val radio_button_text_default = content_primary

    /**
     * Switch Tokens
     *
     */
    /** Background Tokens */
    val switch_background_default = background_neutral_soft
    val switch_background_checked = background_brand_medium
    val switch_background_disabled = background_neutral_light
    val switch_background_disabled_checked = background_brand_light
    val switch_background_content = content_white
    val switch_background_content_disabled = background_neutral_minimal

    /** Text Tokens */
    val switch_text_default = content_primary
    val switch_text_disabled = content_disabled

    /**
     * Spinner Tokens
     */
    /** Background Tokens */
    val spinner_background = content_brand_medium
    val spinner_background_track = content_brand_light
}