
package com.example.styles

import kara.styles.*
import com.example.styles.Styles.*

enum class Styles : StyleClass {
    fileTable
}

val main = "main"

class DefaultStyles() : Stylesheet() {
    override fun render() {
        body {
            backgroundColor = c("#f0f0f0")
            fontFamily = "\"Lucida Sans Unicode\", \"Lucida Grande\", sans-serif"
        }
        h1 {
            marginLeft = 1.em
        }
        div.id(main) {
            width = 85.percent
            backgroundColor = c("#fff")
            margin = box(0.px, auto)
            padding = box(1.em)
            border = "1px solid #ccc"
            borderRadius = 5.px
        }
        table(fileTable) {
            border = "1px solid #ccc"
        }
    }
}

