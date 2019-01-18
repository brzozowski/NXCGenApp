package io.brzozowski.nxcgenapp.model

interface RobotUseCases {

    fun onLeftClicked()
    fun onFwdClicked()
    fun onRevClicked()
    fun onRightClicked()
    fun onFwdReleased()
    fun onRevReleased()
    fun onRightReleased()
    fun onLeftReleased()
}