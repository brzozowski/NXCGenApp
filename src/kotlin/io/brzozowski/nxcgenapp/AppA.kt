package io.brzozowski.nxcgenapp

import io.brzozowski.nxcgenapp.model.Robot
import io.brzozowski.nxcgenapp.utils.Constants.CANVAS_BG_COLOR
import io.brzozowski.nxcgenapp.utils.Constants.CANVAS_HEIGHT
import io.brzozowski.nxcgenapp.utils.Constants.CANVAS_WIDTH
import io.brzozowski.nxcgenapp.utils.Movements
import java.awt.*
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.*


fun main(args: Array<String>) {
    SwingUtilities.invokeLater {
        App()
    }
}

@Suppress("DEPRECATION")
class App : JFrame() {

//    private val robotCanvas: RobotCanvas
//    private val historyCanvas: HistoryCanvas
//    private val robot: Robot = Robot()
//
//    private var moveHistory = mutableListOf<Movements>()
//
//    init {
//
//        val movePanel = JPanel(FlowLayout())
//        val startStopPanel = JPanel(FlowLayout())
//
//        val btnLeft = JButton("LEFT")
//        btnLeft.background = Color.GREEN
//        btnLeft.isOpaque = true
//        btnLeft.mnemonic = KeyEvent.VK_A
//
//        movePanel.add(btnLeft)
//        btnLeft.addActionListener {
//            moveLeft()
//            requestFocus()
//        }
//
//        val btnRight = JButton("RIGHT")
//        btnRight.background = Color.GREEN
//        btnRight.isOpaque = true
//        btnRight.mnemonic = KeyEvent.VK_D
//
//        movePanel.add(btnRight)
//        btnRight.addActionListener {
//            moveRight()
//            requestFocus()
//        }
//
//        val btnFwd = JButton("FWD")
//        btnFwd.background = Color.GREEN
//        btnFwd.isOpaque = true
//        btnFwd.mnemonic = KeyEvent.VK_W
//
//        movePanel.add(btnFwd)
//        btnFwd.addActionListener {
//            moveFwd()
//            requestFocus()
//        }
//
//        val btnRev = JButton("REV")
//        btnRev.background = Color.GREEN
//        btnRev.isOpaque = true
//        btnRev.mnemonic = KeyEvent.VK_S
//
//        movePanel.add(btnRev)
//        btnRev.addActionListener {
//            moveRev()
//            requestFocus()
//        }
//
//        val btnStartStop = JButton("START/STOP")
//        btnStartStop.background = Color.BLUE
//        btnStartStop.isOpaque = true
//
//        startStopPanel.add(btnStartStop)
//        btnStartStop.addActionListener {
//            requestFocus()
//        }
//
//        val btnGenerate = JButton("GENERATE")
//        btnGenerate.background = Color.BLUE
//        btnGenerate.isOpaque = true
//
//        startStopPanel.add(btnGenerate)
//        btnGenerate.addActionListener {
//            requestFocus()
//        }
//
//        robotCanvas = RobotCanvas()
//        robotCanvas.preferredSize = Dimension(CANVAS_WIDTH, CANVAS_HEIGHT)
//
//        historyCanvas = HistoryCanvas()
//
//        centreWindow(this)
//
//        val insets = this.insets()
//
//        var size = robotCanvas.preferredSize
//
//        robotCanvas.setBounds(50 + insets.left, 30 + insets.top,
//            size.width, size.height)
//
//        robotCanvas.border = BorderFactory.createEmptyBorder(0,10,10,10)
//
//        size = historyCanvas.preferredSize
//
//        historyCanvas.setBounds(50 + insets.left, 140 + insets.top + robotCanvas.size.height,
//            size.width, size.height)
//
//        size = movePanel.preferredSize
//
//        movePanel.setBounds(50 + insets.left, 40 + insets.top + robotCanvas.size.height,
//            size.width, size.height)
//
//        size = startStopPanel.preferredSize
//
//        startStopPanel.setBounds(50 + insets.left, 50 + insets.top + robotCanvas.size.height + movePanel.size.height,
//            size.width, size.height)
//
//        this.setSize(300 + insets.left + insets.right,
//            125 + insets.top + insets.bottom)
//
//        addKeyListener(object : KeyAdapter() {
//            override fun keyPressed(evt: KeyEvent?) {
//                when (evt!!.keyCode) {
//                    KeyEvent.VK_A -> moveLeft()
//                    KeyEvent.VK_D -> moveRight()
//                    KeyEvent.VK_W -> moveFwd()
//                    KeyEvent.VK_S -> moveRev()
//                }
//            }
//        })
//
//        val cp = contentPane
//        cp.layout = null
//        cp.add(robotCanvas)
//        cp.add(movePanel)
//        cp.add(startStopPanel)
//        cp.add(historyCanvas)
//
//        preferredSize = Dimension(700, 1000)
//        centreWindow(this)
//        minimumSize = null
//        state = Frame.ICONIFIED
//        state = Frame.NORMAL
//
//        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
//        title = "NXCGenApp"
//        pack()
//        isVisible = true
//        requestFocus()
//    }
//
//    private fun moveLeft() {
//        val savedX = robot.x
//        robot.x -= 10
//        moveHistory.add(Movements.LEFT)
//        addTextTry("LEFT")
//        robotCanvas.repaint(savedX, robot.y, robot.width, robot.height)
//        robotCanvas.repaint(robot.x, robot.y, robot.width, robot.height)
//    }
//
//    private fun moveFwd() {
//        val savedY = robot.y
//        robot.y -= 10
//        moveHistory.add(Movements.FWD)
//        addTextTry("FWD")
//        robotCanvas.repaint(robot.x, savedY, robot.width, robot.height)
//        robotCanvas.repaint(robot.x, robot.y, robot.width, robot.height)
//    }
//
//    private fun moveRev() {
//        val savedY = robot.y
//        robot.y += 10
//        moveHistory.add(Movements.REV)
//        addTextTry("REV")
//        robotCanvas.repaint(robot.x, savedY, robot.width, robot.height)
//        robotCanvas.repaint(robot.x, robot.y, robot.width, robot.height)
//    }
//
//    private fun moveRight() {
//        val savedX = robot.x
//        robot.x += 10
//        moveHistory.add(Movements.RIGHT)
//        addTextTry("RIGHT")
//        robotCanvas.repaint(savedX, robot.y, robot.width, robot.height)
//        robotCanvas.repaint(robot.x, robot.y, robot.width, robot.height)
//    }
//
//    internal inner class RobotCanvas : JPanel() {
//        public override fun paintComponent(g: Graphics) {
//            super.paintComponent(g)
//            background = CANVAS_BG_COLOR
//            robot.paintComponent(g)
//            repaint()
//        }
//    }
//
//    internal inner class HistoryCanvas : JPanel() {
//
//        init {
//            this.layout = FlowLayout()
//            this.preferredSize = Dimension(250, 200)
//            this.background = Color.WHITE
//            val scrollPane = JScrollPane()
//            scrollPane.horizontalScrollBarPolicy = JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
//            scrollPane.verticalScrollBarPolicy = JScrollPane.VERTICAL_SCROLLBAR_NEVER
//            scrollPane.setBounds(50, 30, 300, 50)
//            this.add(scrollPane)
//        }
//
//        public override fun paintComponent(g: Graphics) {
//            super.paintComponent(g)
//        }
//    }
}