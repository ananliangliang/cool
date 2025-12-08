package io.github.ananliangliang.cool.util

import cool.composeapp.generated.resources.Res
import cool.composeapp.generated.resources.date_fmt
import cool.composeapp.generated.resources.this_year_date_fmt
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format
import kotlinx.datetime.format.FormatStringsInDatetimeFormats
import kotlinx.datetime.format.byUnicodePattern
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.compose.resources.getString
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@OptIn(FormatStringsInDatetimeFormats::class, ExperimentalTime::class)
suspend fun Instant.toHumanReadableDate(): String {

    val timezone = TimeZone.currentSystemDefault()
    val localDateTime = this.toLocalDateTime(timezone)
    val thisYear = Clock.System.now().toLocalDateTime(timezone).year

    val fmt = if (localDateTime.year == thisYear) getString(Res.string.this_year_date_fmt)
    else getString(Res.string.date_fmt)

    return localDateTime.format(LocalDateTime.Format { byUnicodePattern(fmt) })
}

