
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val stories = listOf(
    "赤ずきんちゃんの４行ストーリ",
    "１．赤ずきんちゃん、おばあさんの家に行く",
    "２．赤ずきんちゃん、オオカミと遭遇、おばあさんオオカミに食べられる",
    "３．赤ずきんちゃん、オオカミに食べられる",
    "４．赤ずきんちゃん、猟師に助けられる"
)

fun teller() = flow<String> {

    repeat(stories.count()) {
        Thread.sleep(1000)
        emit(stories[it])
        println("${it+1}回目のemitを呼び出したよ")
    }
}


fun main() = runBlocking<Unit> {
    launch {
        for (i in 1..3) {
            println("${i}mainメソッドで回目の遅延処理")
            delay(100)
        }
    }

    val collector = teller()

    collector.collect { value ->
        println(value)
        Thread.sleep(100)
    }
    println("おわり")
}