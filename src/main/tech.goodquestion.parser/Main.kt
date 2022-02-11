import LocalDateTimeParser.Parser.getPeriodUntil
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.temporal.TemporalAdjusters
import java.util.*
import java.util.regex.Matcher
import java.util.regex.Pattern

fun main(){

    val localDateTime: LocalDateTime? = LocalDateTimeParser.parse( "next sunday monday")


    println(localDateTime?.let { LocalDateTimeFormatter.toUSFormat(it)})
    println(localDateTime?.let { LocalDateTimeDurationCalculator.getPeriodUntil(it) })
    println(localDateTime?.getPeriodUntil())



}

