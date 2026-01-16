package com.dimaklekchyan.wizardium.core.utils

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.format.char

object DateFormats {
    const val DASHED_DAY_MONTH_YEAR = "dd-MM-yyyy"
    const val DASHED_YEAR_MONTH_DAY = "yyyy-MM-dd"
}

@OptIn(FormatStringsInDatetimeFormats::class)
fun String.toLocalDate(unicodePattern: String? = null): LocalDate? {
    return try {
        val format = if (!unicodePattern.isNullOrEmpty()) {
            LocalDate.Format { byUnicodePattern(unicodePattern) }
        } else {
            LocalDate.Formats.ISO
        }

        LocalDate.parse(this, format = format)
    } catch (ex: IllegalArgumentException) {
        null
    }
}

@OptIn(FormatStringsInDatetimeFormats::class)
fun String.toLocalDateTime(unicodePattern: String? = null): LocalDateTime? {
    return try {
        val format = when {
            !unicodePattern.isNullOrEmpty() -> {
                LocalDateTime.Format { byUnicodePattern(unicodePattern) }
            }
            this.contains(' ') -> {
                LocalDateTime.Format {
                    date(LocalDate.Formats.ISO)
                    char(' ')
                    time(LocalTime.Formats.ISO)
                }
            }
            else -> LocalDateTime.Formats.ISO
        }

        LocalDateTime.parse(this, format)
    } catch (ex: IllegalArgumentException) {
        null
    }
}