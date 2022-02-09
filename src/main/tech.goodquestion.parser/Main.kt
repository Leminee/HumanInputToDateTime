import LocalDateTimeParser.Parser.toGermanFormat
import java.time.LocalDateTime

fun main(){

    val localDateTime: LocalDateTime? = LocalDateTimeParser.parse( "5 months 6   years 4 d 4 hours 2 minutes")


    println(localDateTime?.let { LocalDateTimeFormatter.toUSFormat(it)})
    println(localDateTime?.let { LocalDateTimeDurationCalculator.getPeriodUntil(it) })
    println(localDateTime?.toGermanFormat())


}