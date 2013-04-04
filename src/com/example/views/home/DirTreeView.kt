package com.example.views.home

import kara.views.*
import java.io.File
import com.example.routes.Home
import java.util.*

class DirTreeView(val dir: String, val showHidden: Boolean) : HtmlView() {

    override fun render(context: ActionContext) {
        val dir = File(dir).getAbsoluteFile()
        if (!dir.exists()) {
            h2("Directory '$dir' does not exist")
            return
        }

        h2("Directory $dir")

        val parent = dir.getParent()
        if (parent != null) {
            a(href = Home.FileTree(parent)) {
                +"Parent dir (..)"
            }
        }
        render(dir, maxDepth = 4)
    }

    fun BodyTag.render(dir: File, maxDepth: Int, currentDepth: Int = 0) {
        if (currentDepth > maxDepth) return;

        val files = dir.listFiles()?.toList() ?: listOf<File>()

        ul {
            for (file in files.sort(fileOrder)) {
                if (!showHidden && file.isHidden()) {
                    continue
                }
                li {
                    +file.getName()
                    if (file.isDirectory()) {
                        render(file, maxDepth, currentDepth + 1)
                    }
                }
            }
        }
    }

}