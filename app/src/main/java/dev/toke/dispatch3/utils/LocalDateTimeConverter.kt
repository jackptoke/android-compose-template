package dev.toke.dispatch3.utils

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.format
import kotlinx.datetime.format.char

@ProvidedTypeConverter
class LocalDateTimeConverter {
    val customFormat = LocalDateTime.Format {
        date(LocalDate.Formats.ISO)
        char(' ')
        hour(); char(':'); minute(); char(':'); second()
        char(','); secondFraction(fixedLength = 3)
    }

    @TypeConverter
    fun StringToLocalDateTime(datetimeStr: String): LocalDateTime = LocalDateTime.parse(datetimeStr, customFormat)

    @TypeConverter
    fun LocalDateTimeToString(datetime: LocalDateTime) = datetime.format(customFormat)
}