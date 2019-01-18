package io.brzozowski.nxcgenapp.model

import io.brzozowski.nxcgenapp.utils.Constants.CANVAS_HEIGHT
import io.brzozowski.nxcgenapp.utils.Constants.CANVAS_WIDTH
import io.brzozowski.nxcgenapp.utils.Movements
import javafx.animation.AnimationTimer
import javafx.beans.property.SimpleStringProperty
import javafx.beans.property.StringProperty
import javafx.beans.value.ObservableValue
import javafx.collections.FXCollections
import javafx.collections.FXCollections.emptyObservableList
import javafx.collections.FXCollections.observableArrayList
import javafx.collections.ObservableArray
import javafx.collections.ObservableList
import javafx.scene.Parent
import tornadofx.*
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import javafx.beans.property.SimpleIntegerProperty



data class Robot (
        var x: Double = CANVAS_WIDTH / 3,
        var y: Double = CANVAS_HEIGHT / 3,
        var width: Int = 10,
        var height: Int = 80,
        var image: BufferedImage = ImageIO.read(File("images/robot.png")),
        var color: Color = Color.RED
) : Parent(), RobotUseCases {

    var moveHistory: ObservableList<Movements> = observableArrayList()
    var currentMove: SimpleStringProperty = SimpleStringProperty(this, "currentMove")
        get() = currentMoveProperty()

    private var goNorth: Boolean = false
    private var goSouth: Boolean = false
    private var goEast: Boolean = false
    private var goWest: Boolean = false

    fun currentMoveProperty(): SimpleStringProperty {
        return currentMove
    }

    init {
        currentMove = SimpleStringProperty("asdads")
        moveHeroTo(x, y)
    }

    private fun checkMoveDirection() {
        var dx = 0
        var dy = 0

        if (goNorth) dy -= 2
        if (goSouth) dy += 2
        if (goEast) dx += 2
        if (goWest) dx -= 2

        moveHeroBy(dx, dy)
    }

    private fun addMoveToHistory(movement: Movements) {
        moveHistory.add(movement)
        currentMove = SimpleStringProperty(movement.name)
    }

    override fun onLeftClicked() {
        goWest = true
        checkMoveDirection()
        addMoveToHistory(Movements.LEFT)
    }

    override fun onFwdClicked() {
        goNorth = true
        checkMoveDirection()
        addMoveToHistory(Movements.FWD)
    }

    override fun onRevClicked() {
        goSouth = true
        checkMoveDirection()
        addMoveToHistory(Movements.REV)
    }

    override fun onRightClicked() {
        checkMoveDirection()
        goEast = true
        addMoveToHistory(Movements.RIGHT)
    }

    override fun onFwdReleased() {
        goNorth = false
    }

    override fun onRevReleased() {
        goSouth = false
    }

    override fun onRightReleased() {
        goEast = false
    }

    override fun onLeftReleased() {
        goWest = false
    }

    fun moveHeroBy(dx: Int, dy: Int) {
        if (dx == 0 && dy == 0) return

        val cx = this.boundsInLocal.width / 2
        val cy = this.boundsInLocal.height / 2

        val x = cx + this.layoutX + dx
        val y = cy + this.layoutY + dy

        moveHeroTo(x, y)
    }

    fun moveHeroTo(x: Double, y: Double) {
        val cx = this.boundsInLocal.width / 2
        val cy = this.boundsInLocal.height / 2

        if (x - cx >= 0 &&
                x + cx <= CANVAS_WIDTH &&
                y - cy >= 0 &&
                y + cy <= CANVAS_HEIGHT) {
            this.relocate(x - cx, y - cy)
        }
    }
}