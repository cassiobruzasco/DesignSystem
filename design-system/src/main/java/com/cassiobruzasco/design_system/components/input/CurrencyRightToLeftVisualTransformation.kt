package com.cassiobruzasco.design_system.components.input

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.lang.Integer.max
import java.text.DecimalFormat
/**
 * VisualTransformation for formatting currency values with the currency symbol on the right.
 *
 * This class formats currency input by adding thousands separators, a decimal separator, and the currency symbol to the right of the value.
 * It also handles cursor positioning correctly during input.
 *
 * @param currency The type of currency to format (e.g., `Currency.USD`, `Currency.EUR`, `Currency.BRL`).
 */
class CurrencyRightToLeftVisualTransformation(
    val currency: Currency,
) : VisualTransformation {

    private val symbols = DecimalFormat().decimalFormatSymbols
    private val numberOfDecimals = 2

    override fun filter(text: AnnotatedString): TransformedText {
        val inputText = text.text
        val thousandsSeparator = if (currency !is Currency.EUR) symbols.groupingSeparator else symbols.decimalSeparator
        val decimalSeparator = if (currency !is Currency.EUR) symbols.decimalSeparator else symbols.groupingSeparator
        val zero = symbols.zeroDigit

        val intPart = inputText
            .dropLast(numberOfDecimals)
            .reversed()
            .chunked(3)
            .joinToString(thousandsSeparator.toString())
            .reversed()
            .ifEmpty {
                zero.toString()
            }

        val fractionPart = inputText.takeLast(numberOfDecimals).let {
            if (it.length != numberOfDecimals) {
                List(numberOfDecimals - it.length) {
                    zero
                }.joinToString("") + it
            } else {
                it
            }
        }

        val formattedNumber = when (currency) {
            is Currency.USD -> currency.symbol + intPart + decimalSeparator + fractionPart
            is Currency.BRL -> currency.symbol + intPart + decimalSeparator + fractionPart
            is Currency.EUR -> intPart + decimalSeparator + fractionPart + currency.symbol
        }

        val newText = AnnotatedString(
            text = formattedNumber,
            spanStyles = text.spanStyles,
            paragraphStyles = text.paragraphStyles,
        )

        val offsetMapping = MovableCursorOffsetMapping(
            unmaskedText = text.toString(),
            maskedText = newText.toString(),
            decimalDigits = numberOfDecimals,
        )

        return TransformedText(
            newText,
            offsetMapping,
        )
    }

    private class MovableCursorOffsetMapping(
        private val unmaskedText: String,
        private val maskedText: String,
        private val decimalDigits: Int,
    ) : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int =
            when {
                unmaskedText.length <= decimalDigits -> {
                    maskedText.length - (unmaskedText.length - offset)
                }

                else -> {
                    offset + offsetMaskCount(offset, maskedText)
                }
            }

        override fun transformedToOriginal(offset: Int): Int =
            when {
                unmaskedText.length <= decimalDigits -> {
                    max(unmaskedText.length - (maskedText.length - offset), 0)
                }

                else -> {
                    offset - maskedText.take(offset).count { !it.isDigit() }
                }
            }

        private fun offsetMaskCount(offset: Int, maskedText: String): Int {
            var maskOffsetCount = 0
            var dataCount = 0
            for (maskChar in maskedText) {
                if (!maskChar.isDigit()) {
                    maskOffsetCount++
                } else if (++dataCount > offset) {
                    break
                }
            }
            return maskOffsetCount
        }
    }
}

/**
 * Represents a currency type.
 *
 * **Available Currencies**
 *
 * * `USD`: United States Dollar.
 * * `EUR`: Euro.
 * * `BRL`: Brazilian Real.
 */
sealed interface Currency {
    data class USD(val symbol: String = "$", val name: String = "USD") : Currency
    data class EUR(val symbol: String = "€", val name: String = "EUR") : Currency
    data class BRL(val symbol: String = "R$", val name: String = "BRL") : Currency
}