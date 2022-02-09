import java.time.LocalDateTime

fun main(){

    val localDateTime: LocalDateTime? = LocalDateTimeParser.parse( "2 months 6   years 4 d 4 hours 2 minutes")

    println(localDateTime?.let { LocalDateTimeParser.toGermanFormat(it) })

    println(localDateTime?.let { LocalDateTimeParser.getDurationUntil(it) })




}