import java.lang.UnsupportedOperationException
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*


class LocalDateTimeParser private constructor() {

    companion object Parser {


        private fun convertHumanInput(humanInput: String):String {

            return humanInput

        }

        fun parseLocalDateTime(humanInput: String): LocalDateTime {


            val convertedHumanInput = convertHumanInput(humanInput)

            var years = 0
            var months = 0
            var weeks = 0
            var days = 0
            var hours = 0
            var minutes = 0
            var seconds = 0


            val args: MutableList<String> = convertedHumanInput.trim().split(" ") as MutableList<String>


            if ((args.size > 1).not()) throw UnsupportedOperationException("Error")


            args.removeAll(listOf(""))


            for (arg: String in args) {

                try {

                    if (arg.contains("years")) years = args[args.indexOf("years") - 1].toInt()
                    if (arg.contains("months")) months = args[args.indexOf("months") - 1].toInt()
                    if (arg.contains("weeks")) weeks = args[args.indexOf("weeks") - 1].toInt()
                    if (arg.contains("days")) days = args[args.indexOf("days") - 1].toInt()
                    if (arg.contains("hours")) hours = args[args.indexOf("hours") - 1].toInt()
                    if (arg.contains("minutes")) minutes = args[args.indexOf("minutes") - 1].toInt()
                    if (arg.contains("seconds")) seconds = args[args.indexOf("seconds") - 1].toInt()

                } catch (numberFormatException: NumberFormatException) {

                    throw NumberFormatException("Error")

                }
            }

            return LocalDateTime.now()
                .plusYears(years.toLong())
                .plusMonths(months.toLong())
                .plusWeeks(weeks.toLong())
                .plusDays(days.toLong())
                .plusHours(hours.toLong())
                .plusMinutes(minutes.toLong())
                .plusSeconds(seconds.toLong())
        }

        fun formatDateTime(localDateTime: LocalDateTime): String {

            val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").withLocale(Locale.GERMAN)

            return localDateTime.format(dateFormatter)
        }


        fun getDurationUntilPassedDateTimeInSeconds(localDateTime: LocalDateTime): Long {

            return ChronoUnit.SECONDS.between(LocalDateTime.now(), localDateTime)
        }

        fun getDurationUntilPassedDateTimeInMinutes(localDateTime: LocalDateTime): Long {

            return ChronoUnit.MINUTES.between(LocalDateTime.now(), localDateTime)
        }

        fun getDurationUntilPassedDateTimeInHours(localDateTime: LocalDateTime): Long {

            return ChronoUnit.HOURS.between(LocalDateTime.now(), localDateTime)
        }

        fun getDurationUntilPassedDateTimeInDays(localDateTime: LocalDateTime): Long {

            return ChronoUnit.DAYS.between(LocalDateTime.now(), localDateTime)
        }

        fun getDurationUntilPassedDateTimeInMonths(localDateTime: LocalDateTime): Long {

            return ChronoUnit.MONTHS.between(LocalDateTime.now(), localDateTime)
        }

        fun getDurationUntilPassedDateTimeInYears(localDateTime: LocalDateTime): Long {

            return ChronoUnit.YEARS.between(LocalDateTime.now(), localDateTime)
        }

        fun getDurationUntilPassedDateTime(localDateTime: LocalDateTime): String {

            TODO()
        }
    }

}