package small_builder

import java.util.ArrayList

abstract class Element {
    val children = ArrayList<Element>()
}

open class Body: Element() {
    fun text(s: String) {
        children.add(Text(s))
    }

    fun ul(init: UL.() -> Unit) {
        val ul = UL()
        children.add(ul)
        ul.init()
    }
}

class Text(val text: String): Element()

class UL: Element() {
    fun li(init: LI.() -> Unit) {
        val li = LI()
        children.add(li)
        li.init()
    }
}

class LI: Body()

fun body(init: Body.() -> Unit): Body {
    val body = Body()
    body.init()
    return body
}

fun main(args: Array<String>) {
    body {
        ul {
            li { text("A") }
            li {
                ul {
                    li { text("1") }
                    li { text("2") }
                }
            }
        }
    }
}