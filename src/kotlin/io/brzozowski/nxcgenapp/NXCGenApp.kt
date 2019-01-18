package io.brzozowski.nxcgenapp

import javafx.application.Application
import javafx.stage.Stage
import mu.KLogging
import tornadofx.App

class NXCGenApp : App(MainView::class) {

    companion object : KLogging()

    override fun start(stage: Stage) {
        super.start(stage)

        with(stage) {
            width = 902.0
            height = 700.0

            isResizable = false
            centerOnScreen()
        }
    }
}

fun main(args: Array<String>) {
    Application.launch(NXCGenApp::class.java, *args)
}