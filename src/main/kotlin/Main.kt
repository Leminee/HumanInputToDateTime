import java.time.LocalDateTime


fun main(){


   val localDateTime: LocalDateTime = LocalDateTimeParser.parseLocalDateTime("3 days")

    println(LocalDateTimeParser.formatDateTime(localDateTime))





}