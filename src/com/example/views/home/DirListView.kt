package com.example.views.home

import kara.views.*
import java.io.File
import com.example.routes.Home
import java.util.*
import com.example.styles.Styles.*
import com.example.styles.Styles

class DirListView(val dir: String) : HtmlView() {
    override fun render(context: ActionContext) {
        val dir = File(dir).getAbsoluteFile()
        if (!dir.exists()) {
            h2("Directory '$dir' does not exist")
            return
        }

        h2("Directory $dir")

        table(fileTable) {
            tr {
                td { b("Name") }
                td { b("Size") }
            }

            val parentDir = dir.getParent()
            if (parentDir != null) {
                tr {
                    td {
                        a(href = Home.FileList(parentDir)) {
                            +".."
                        }
                    }
                    td(parent) {
                        +"<parent>"
                    }
                }
            }

            val files = dir.listFiles()?.toList() ?: listOf<File>()
            var isAlt = false
            for (file in files.sort(fileOrder)) {
                isAlt = !isAlt
                val rowClass = if (isAlt) alt else normal

                tr(rowClass) {
                    td {
                        if (file.isDirectory()) {
                            a(href = Home.FileList(file.getPath())) {
                                +file.getName()
                            }
                        }
                        else {
                            +file.getName()
                        }
                    }
                    td(permissions) {
                        renderPermissions(file)
                    }
                }
            }
        }
    }

    fun BodyTag.renderPermissions(file: File) {
        fun TR.ptd(b: Boolean, init: TD.() -> Unit) {
            td(
                    c = if (b) permitted else not_permitted,
                    init = init
            )
        }

        table(permissions) {
            tr {
                ptd(file.canRead()) { +"r" }
                ptd(file.canWrite()) { +"w" }
                ptd(file.canExecute()) { +"x" }
            }
        }
    }

}

val fileOrder: Comparator<File> = Comparator {
                x, y ->
                if (x.isDirectory() && y.isFile()) -1
                else if (y.isDirectory() && x.isFile()) 1
                else x.getName().compareTo(y.getName())
            }
