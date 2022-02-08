import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*


class LocalDateTimeParser private constructor() {


    companion object Parser {

        private val specialDays = mapOf(

            "silvester" to LocalDateTime.of(LocalDateTime.now().year, 12, 31, 0, 0, 0),
            "christmas" to LocalDateTime.of(LocalDateTime.now().year, 12, 25, 0, 0, 0),
            "halloween" to LocalDateTime.of(LocalDateTime.now().year, 10, 31, 0, 0, 0),
            "now" to LocalDateTime.now(),
            "tomorrow" to LocalDateTime.now().plusDays(1),
            "today" to LocalDateTime.now(),
            "yesterday" to LocalDateTime.now().minusDays(1),
            "valentine" to LocalDateTime.of(LocalDateTime.now().year, 2, 14, 0, 0, 0),


            )


        fun parse(humanInput: String): LocalDateTime? {


            val cleanedHumanInput = removeSpecialCharacters(humanInput).lowercase()

            for (specialDay: String in specialDays.keys) {

                if (cleanedHumanInput.contains(specialDay)) {
                    return specialDays[specialDay]
                }
            }


            var years = 0
            var months = 0
            var weeks = 0
            var days = 0
            var hours = 0
            var minutes = 0
            var seconds = 0


            val args: MutableList<String> = cleanedHumanInput.trim().split(" ") as MutableList<String>

            if ((args.size > 1).not()) throw UnsupportedOperationException("Invalid Input")


            args.removeAll(listOf(""))


            for (arg: String in args) {

                try {

                    if (arg.startsWith("y")) years = args[args.indexOf(arg) - 1].toInt()
                    if (arg.startsWith("mo")) months = args[args.indexOf(arg) - 1].toInt()
                    if (arg.startsWith("w")) weeks = args[args.indexOf(arg) - 1].toInt()
                    if (arg.startsWith("d")) days = args[args.indexOf(arg) - 1].toInt()
                    if (arg.startsWith("h")) hours = args[args.indexOf(arg) - 1].toInt()
                    if (arg.startsWith("mi")) minutes = args[args.indexOf(arg) - 1].toInt()
                    if (arg.startsWith("s")) seconds = args[args.indexOf(arg) - 1].toInt()

                } catch (numberFormatException: NumberFormatException) {

                    throw NumberFormatException("Invalid Input")

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

        fun toGermanDateTimeFormat(localDateTime: LocalDateTime): String {

            val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").withLocale(Locale.GERMAN)

            return localDateTime.format(dateFormatter)
        }


        private fun removeSpecialCharacters(string: String): String {

            return string.replace("[-+^]*".toRegex(), "")
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

        fun getSpecialDays(): Set<String> {

            return specialDays.keys
        }
    }

}