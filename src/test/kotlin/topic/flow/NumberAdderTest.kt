package topic.flow

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import topics.flow.NumberAdder
import kotlin.test.Test
import kotlin.test.assertEquals

class NumberAdderTest {

    @OptIn(ExperimentalCoroutinesApi::class)
    val dispatcherTestRule = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun testAdd() = runTest{
        val adder = NumberAdder(dispatcherTestRule, 0)
        val result = adder.add(1,4).first()
        assertEquals(5,result)
    }
}