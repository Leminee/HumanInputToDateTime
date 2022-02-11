import LocalDateTimeParser.Parser.getPeriodUntil
import java.time.LocalDateTime
import java.util.regex.Matcher
import java.util.regex.Pattern

fun main(){

    val localDateTime: LocalDateTime? = LocalDateTimeParser.parse( " 2 mo")


    println(localDateTime?.let { LocalDateTimeFormatter.toUSFormat(it)})
    println(localDateTime?.let { LocalDateTimeDurationCalculator.getPeriodUntil(it) })
    println(localDateTime?.getPeriodUntil())




}

