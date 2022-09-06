package topics

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

fun main() = runBlocking {
    val channel = Channel<Item>()
    CoroutineScope(Dispatchers.Default).launch {
        channel.send(Item(1))
        channel.send(Item(2))
        println("do something")
    }

    for (c in channel) {
        println(c)
    }
    println(channel.receive())
//    println(channel.receive())

    println("Done!")
}

data class Item(val id: Int)

fun consumeItems(item: List<Item>) {
    repeat(item.size) { println("do something") }
}

suspend fun getItems(): List<Item> {
    val items = mutableListOf<Item>()
    items.add(makeItem())
    items.add(makeItem())
    items.add(makeItem())
    return items
}

suspend fun makeItem(): Item {
    delay(10)
    return Item(0)
}




















