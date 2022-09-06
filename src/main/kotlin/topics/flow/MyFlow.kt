package topics.flow

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import kotlin.coroutines.CoroutineContext

class MyFlow : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private lateinit var job: Job

    private fun asyncSum(a: Int, b: Int): Flow<Int> {
        return flow {
            this.emit(a + b)
        }.flowOn(Dispatchers.IO)
    }

    @FlowPreview
    fun asyncComplicatedSum(a: Int, b: Int, c: Int) {
        launch {
            asyncSum(a, b).flatMapConcat {
                asyncSum(a, c)
            }.catch {
                println("something wen wrong")
            }.collect {
                println("final sum : $it")
            }
        }
    }
}