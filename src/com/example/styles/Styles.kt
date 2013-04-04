
package com.example.styles

import kara.styles.*
import kara.styles.TextAlign.*
import com.example.styles.Styles.*

enum class Styles : StyleClass {
    fileTable
    permissions
    permitted
    not_permitted
    parent
    alt
    normal
    footnote
}

val main = "main"

class DefaultStyles() : Stylesheet() {
    override fun render() {
        body {
            backgroundColor = c("#f0f0f0")
            fontFamily = """"Lucida Sans Unicode", "Lucida Grande", sans-serif"""
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
            tr(alt) {
                backgroundColor = c("#EAF2D3")
            }
            td {
                border = "1px solid #ccc"
            }
            td(parent) {
                textAlign = center
            }
            td(permissions) {
                margin = box(0.px)
                padding = box(0.px)
            }
            border = "1px solid #ccc"
            attributes["border-collapse"] = "collapse"
        }
        table(permissions) {
            td {
                border = "none"
                width = 25.px
                textAlign = center
            }
            td(permitted) {
                color = c("#070")
            }
            td(not_permitted) {
                color = Color.fromRgb(0xBB, 0xBB, 0xBB)
            }
        }
        div(footnote) {
            fontSize = 50.percent
        }
    }
}

