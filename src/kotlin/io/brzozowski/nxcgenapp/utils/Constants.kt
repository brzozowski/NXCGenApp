package io.brzozowski.nxcgenapp.utils

import java.awt.Color

object Constants {

    const val CANVAS_WIDTH = 582.0
    const val CANVAS_HEIGHT = 471.0

    val CANVAS_BG_COLOR = Color.WHITE!!

    object Generator {

        const val braceUp = "{"
        const val braceDown = "}"
        const val task = "task"
        const val MOVE_TIME = 500
        const val TURN_TIME = 360

        const val FORWARDS = "#define forwards(s, t) OnFwd(OUT_AB, s); Wait(t);"
        const val BACKWARDS = "#define backwards(s, t) OnRev(OUT_AB, s); Wait(t);"

        const val TURN_RIGHT = "#define turn_right(s, t) OnFwd(OUT_A, s); OnRev(OUT_B, s); Wait(t); OnFwd(OUT_AB, s); Wait(t);"
        const val TURN_LEFT = "#define turn_left(s, t) OnRev(OUT_A, s); OnFwd(OUT_B, s); Wait(t); OnFwd(OUT_AB, s); Wait(t);"
    }
}