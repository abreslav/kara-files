import java.util.ArrayList

fun main(args: Array<String>) {


    // Higher-order functions

    fun <T> let(t: T, body: (T) -> Unit) {
        body(t)
    }

    let(2 + 3, { x -> println(x * x) })

    let(2 + 3) {
        x ->
        println(x * x)
    }



    // Extensions functions

    fun String.lastChar(): Char {
        return this.charAt(this.size - 1)
    }

    println(

       "abc".lastChar()

    )



    // Extension functions as values

    fun <T> with(t: T, body: T.() -> Unit) {
        t.body()
    }

    val stringBuilder = StringBuilder()
    with(stringBuilder, { this.append("1") })

    with (stringBuilder) {
        append("Numbers: ")
        for (i in 1..10) {
            append(i)
        }
    }
}


// Basic mechanics of builders
fun demo1() {

    class LI

    class UL {
        fun li() {}
    }

    with(UL()) {
        li()
    }

}



// How builders actually work
fun demo2() {

    class LI

    class UL {
        val items = ArrayList<LI>()

        fun li(init: LI.() -> Unit) {
            val li = LI()
            li.init()
            items.add(li)
        }
    }

    with(UL()) {
        li {
            // ...
        }
        li {
            // ...
        }
    }






    fun ul(init: UL.() -> Unit) {
        val ul = UL()
        ul.init()
    }

    ul {
        li {

        }
        li {

        }
    }


}



























fun <T> with(t: T, body: T.() -> Unit) {
    t.body()
}
