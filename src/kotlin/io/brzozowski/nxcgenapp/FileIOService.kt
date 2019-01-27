package io.brzozowski.nxcgenapp

import io.brzozowski.nxcgenapp.utils.Constants
import io.brzozowski.nxcgenapp.utils.Movements
import java.io.File

class FileIOService constructor(moveHistory: List<Movements>) {

    init {
        File("gen.txt").apply {

            val lines = arrayListOf<String>()
            val defineMoveTimeLine = "#define MOVE_TIME ${Constants.Generator.MOVE_TIME};"
            val defineTurnTimeLine = "#define TURN_TIME ${Constants.Generator.TURN_TIME};"
            val mainLine = "${Constants.Generator.task} main() ${Constants.Generator.braceUp}"

            lines.add(defineMoveTimeLine)
            lines.add(defineTurnTimeLine + "\n")
            lines.add(Constants.Generator.FORWARDS)
            lines.add(Constants.Generator.BACKWARDS)
            lines.add(Constants.Generator.TURN_LEFT)
            lines.add(Constants.Generator.TURN_RIGHT + "\n")
            lines.add(mainLine)

            for(move in moveHistory) {
                when(move) {
                    Movements.FWD -> lines.add("forwards(50, 200);")
                    Movements.REV -> lines.add("backwards(75, 200);")
                    Movements.LEFT -> lines.add("turn_left(75, 900);")
                    Movements.RIGHT -> lines.add("turn_right(75, 900);")
                }
            }

            lines.add("Off(OUT_AB);")
            lines.add(Constants.Generator.braceDown)

            writeText(lines.joinToString("\n"))
        }
    }
}