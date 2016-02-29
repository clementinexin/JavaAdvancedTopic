package kotlin.demo.conventions

/**
 * Created by JDai on 2016/2/18.
 */
data class MyDate(val year:Int,val month:Int,val dayOfMonth:Int):Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int = when {
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }
}
