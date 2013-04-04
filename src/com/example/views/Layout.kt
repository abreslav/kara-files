
package com.example.views

import kara.views.*
import com.example.styles.*

class Layout() : HtmlLayout() {
    override fun render(context: ActionContext, mainView: HtmlView) {
        val title = "Files (a Kara Appplication)"
        head {
            title(title)
            stylesheet(DefaultStyles())
        }
        body {
            h1(title)
            div(id=main) {
                renderView(context, mainView)
            }
        }
    }
}

