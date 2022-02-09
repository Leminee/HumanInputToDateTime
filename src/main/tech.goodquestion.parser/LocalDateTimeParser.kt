import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.math.abs

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
            "corona" to LocalDateTime.of(2019, 12, 1, 0, 0, 0),

            )


        fun parse(humanInput: String): LocalDateTime? {


            val cleanedHumanInput = removeSpecialCharacters(humanInput).lowercase()

            for (specialDay: String in specialDays.keys) {

                if (cleanedHumanInput.contains(specialDay)) {
                    return specialDays[specialDay]
                }
            }

            var years:Long = 0
            var months:Long = 0
            var weeks:Long = 0
            var days:Long = 0
            var hours:Long= 0
            var minutes:Long = 0
            var seconds:Long = 0


            val args: MutableList<String> = cleanedHumanInput.trim().split(" ") as MutableList<String>

            if (args.size == 1) throw IllegalArgumentException("Invalid Input")

            args.removeAll(listOf(""))

            for (arg: String in args) {

                try {

                    if (arg.startsWith("y"))  years = args[args.indexOf(arg) - 1].toLong()
                    if (arg.startsWith("mo")) months = args[args.indexOf(arg) - 1].toLong()
                    if (arg.startsWith("w")) weeks = args[args.indexOf(arg) - 1].toLong()
                    if (arg.startsWith("d")) days = args[args.indexOf(arg) - 1].toLong()
                    if (arg.startsWith("h")) hours = args[args.indexOf(arg) - 1].toLong()
                    if (arg.startsWith("mi")) minutes = args[args.indexOf(arg) - 1].toLong()
                    if (arg.startsWith("s")) seconds = args[args.indexOf(arg) - 1].toLong()

                } catch (numberFormatException: NumberFormatException) {

                    throw NumberFormatException("Invalid Input")

                }
            }

            return LocalDateTime.now()
                .plusYears(years)
                .plusMonths(months)
                .plusWeeks(weeks)
                .plusDays(days)
                .plusHours(hours)
                .plusMinutes(minutes)
                .plusSeconds(seconds)
        }

        fun toGermanFormat(localDateTime: LocalDateTime): String {

            val dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm").withLocale(Locale.GERMAN)

            return localDateTime.format(dateFormatter)
        }

        private fun removeSpecialCharacters(string: String): String {

            return string.replace("[-+^]*".toRegex(), "")
        }


        fun getDurationUntilInSeconds(localDateTime: LocalDateTime): Long {

            return ChronoUnit.SECONDS.between(LocalDateTime.now(), localDateTime)
        }

        fun getDurationUntilInMinutes(localDateTime: LocalDateTime): Long {

            return ChronoUnit.MINUTES.between(LocalDateTime.now(), localDateTime)
        }

        fun getDurationUntilInHours(localDateTime: LocalDateTime): Long {

            return ChronoUnit.HOURS.between(LocalDateTime.now(), localDateTime)
        }

        fun getDurationUntilInDays(localDateTime: LocalDateTime): Long {

            return ChronoUnit.DAYS.between(LocalDateTime.now(), localDateTime)
        }

        fun getDurationUntilInWeeks(localDateTime: LocalDateTime): Long {

            return ChronoUnit.WEEKS.between(LocalDateTime.now(), localDateTime)
        }

        fun getDurationUntilInMonths(localDateTime: LocalDateTime): Long {

            return ChronoUnit.MONTHS.between(LocalDateTime.now(), localDateTime)
        }
        
        fun getDurationUntilInYears(localDateTime: LocalDateTime): Long {

            return ChronoUnit.YEARS.between(LocalDateTime.now(), localDateTime)
        }

        fun getDurationUntil(localDateTime: LocalDateTime): String {

            val period = Period.between(LocalDateTime.now().toLocalDate(), localDateTime.toLocalDate())
            val years = abs(period.years)
            val months = abs(period.months)
            val days = abs(period.days)

            return "$years years $months months $days days"
        }

        fun getSpecialDays(): Set<String> {

            return specialDays.keys
        }
    }

}