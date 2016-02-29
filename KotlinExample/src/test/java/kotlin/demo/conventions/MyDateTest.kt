package kotlin.demo.conventions

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Created by JDai on 2016/2/18.
 */
class MyDateTest {

    @Test
    fun testCompareTo() {
        Assert.assertTrue(MyDate(2016,2,18) < MyDate(2016,2,19))
    }
}