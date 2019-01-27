package io.brzozowski.nxcgenapp

import io.brzozowski.nxcgenapp.model.Robot
import io.brzozowski.nxcgenapp.model.RobotUseCases
import javafx.application.Platform
import javafx.beans.property.StringProperty
import javafx.embed.swing.SwingFXUtils
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane
import javafx.scene.layout.Pane
import mu.KLogging
import tornadofx.*
import javafx.scene.control.cell.PropertyValueFactory
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.VBox
import javafx.util.Callback


class MainView: View("NXCGenApp"), RobotUseCases {

    companion object : KLogging()

    override val root : GridPane by fxml("/MainView.fxml")

    private val canvas : Pane by fxid()
    private val labelAnchorPane : AnchorPane by fxid()
    private val labelVbox : VBox by fxid()
    private val indexColumn : TableColumn<Robot, String> by fxid()
    private val moveColumn : TableColumn<Robot, String> by fxid()

    private var robot: Robot = Robot()
    private var hero: Node = ImageView(SwingFXUtils.toFXImage(robot.image, null))

    init {
        robot.add(hero)

        canvas.children.add(robot)
    }

    fun onCloseBtnClicked() {
        Platform.exit()
    }

    fun onRunBtnClicked() {
        robot.onRunBtnClicked()
    }

    fun onGenerateBtnClicked() {
        FileIOService(robot.moveHistory)
    }

    override fun onFwdClicked() {
        robot.onFwdClicked()
        labelVbox.children.add(Label("FWD"))
    }

    override fun onRevClicked() {
        robot.onRevClicked()
        labelVbox.children.add(Label("REV"))
    }

    override fun onRightClicked() {
        robot.onRightClicked()
        labelVbox.children.add(Label("RIGHT"))
    }

    override fun onLeftClicked() {
        robot.onLeftClicked()
        labelVbox.children.add(Label("LEFT"))
    }

    override fun onFwdReleased() {
        robot.onFwdReleased()
    }

    override fun onRevReleased() {
        robot.onRevReleased()
    }

    override fun onRightReleased() {
        robot.onRightReleased()
    }

    override fun onLeftReleased() {
        robot.onLeftReleased()
    }
}
