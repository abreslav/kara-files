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
}

