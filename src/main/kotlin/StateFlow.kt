import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val mutableStateFlow = MutableStateFlow<Int>(0)

        launch {
            // 受信する
            mutableStateFlow.collect {
                println("$it")
            }
        }

        delay(1000)

        // 送信する
        println("emit:1")
        mutableStateFlow.emit(1)
        delay(1000)
        println("emit:2")
        mutableStateFlow.update {
            2
        }
    }
}