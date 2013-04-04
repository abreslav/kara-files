
package com.example.routes

import com.example.views.*
import com.example.views.home.*
import kara.controllers.*

object Home {
    val layout = Layout()

    Get("/")
    class Index() : Request({
        IndexView()
    })

    Get("/list")
    class FileList(val dir: String, val showHidden: Boolean) : Request({
        DirListView(dir, showHidden)
    })

    Get("/tree")
    class FileTree(val dir: String) : Request({
        DirTreeView(dir, false)
    })

}

