import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class LocalDateTimeFormatter private constructor() {

    companion object Formatter {

        private val dateFormatter:DateTimeFormatter =  DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm")

        @JvmStatic
        fun toGermanFormat(localDateTime: LocalDateTime): String {

            val germanFormat: DateTimeFormatter = dateFormatter.withLocale(Locale.GERMAN)

            return localDateTime.format(germanFormat)
        }

        @JvmStatic
        fun toFrenchFormat(localDateTime: LocalDateTime): String {

            val frenchFormat: DateTimeFormatter = dateFormatter.withLocale(Locale.FRENCH)

            return localDateTime.format(frenchFormat)
        }

        @JvmStatic
        fun toUSFormat(localDateTime: LocalDateTime): String {

            val uSFormat: DateTimeFormatter = dateFormatter.withLocale(Locale.US)

            return localDateTime.format(uSFormat)
        }

    }
}