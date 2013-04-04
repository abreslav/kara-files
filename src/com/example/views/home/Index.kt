package com.example.views.home

import kara.views.*
import java.io.File
import com.example.routes.Home
import java.util.*

class IndexView() : HtmlView() {
    override fun render(context: ActionContext) {
        h2("Welcome to Files")

        ul {
            li {
                a(href = Home.FileList(".", false)) {
                    +"List"
                }
            }
            li {
                a(href = Home.FileTree(".")) {
                    +"Tree"
                }
            }
        }
    }
    fun String.size3() = this.size * 2

}

val f: (String) -> Int = { it.size + 15 }
val ef: String.() -> Int = { String.(): Int -> this.size + 15 }

fun String.size2() = this.size * 2

fun with<T>(t: T, body: T.() -> Unit) {
    t.body()
}

fun main(args: Array<String>) {
    println("abc".size2())

    val indexView = IndexView()
    with (indexView) {
        println("asd".size3())
    }
}