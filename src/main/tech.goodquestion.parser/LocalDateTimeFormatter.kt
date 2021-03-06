import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class LocalDateTimeFormatter private constructor() {

    companion object Formatter {

        private val dateFormatter:DateTimeFormatter =  DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")

        @JvmStatic
        fun toGermanFormat(localDateTime: LocalDateTime): String {

            val germanFormat: DateTimeFormatter = dateFormatter.withLocale(Locale.GERMAN)

            return localDateTime.format(germanFormat)
        }


        @JvmStatic
        fun toUSFormat(localDateTime: LocalDateTime): String {

            val uSFormat: DateTimeFormatter = dateFormatter.withLocale(Locale.US)

            return localDateTime.format(uSFormat)
        }

    }
}