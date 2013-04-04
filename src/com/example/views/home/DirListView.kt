package com.example.views.home

import kara.views.*
import java.io.File
import com.example.routes.Home
import java.util.*
import com.example.styles.Styles.*

class DirListView(val dir: String, val showHidden: Boolean) : HtmlView() {
    override fun render(context: ActionContext) {
        val dir = File(dir).getAbsoluteFile()
        if (!dir.exists()) {
            h2("Directory '$dir' does not exist")
            return
        }

        h2("Directory $dir")

        renderToggleHiddenFiles()

        table(fileTable) {
            tr {
                td { b("Name") }
                td { b("Size") }
            }

            val parent = dir.getParent()
            if (parent != null) {
                tr {
                    td {
                        a(href = Home.FileList(parent, showHidden)) {
                            +".."
                        }
                    }
                    td {
                        +"Parent directory"
                    }
                }
            }

            val files = dir.listFiles()?.toList() ?: listOf<File>()
            for (file in files.sort(fileOrder)) {
                if (!showHidden && file.isHidden()) {
                    continue
                }
                tr {
                    td {
                        if (file.isDirectory()) {
                            a(href = Home.FileList(file.getPath(), showHidden)) {
                                +file.getName()
                            }
                        }
                        else {
                            +file.getName()
                        }
                    }
                    td {
                        if (file.isFile()) {
                            +file.sizeString()
                        }
                    }
                }
            }
        }
    }

    fun BodyTag.renderToggleHiddenFiles() {
        val prefix = if (showHidden) "Show" else "Don't show"
        a(href = Home.FileList(dir, !showHidden)) {
            +"$prefix hidden files"
        }
    }

}

val fileOrder: Comparator<File> = Comparator {
                x, y ->
                if (x.isDirectory() && y.isFile()) -1
                else if (y.isDirectory() && x.isFile()) 1
                else x.getName().compareTo(y.getName())
            }

fun File.sizeString(): String {
    val kb = 1024
    val mb = 1024 * kb

    val size = length()
    return when {
        size < kb -> "$size"
        size < mb -> "${size / kb}K"
        else -> "${size / mb}M"
    }
}
