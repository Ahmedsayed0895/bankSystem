package org.example.presentation.util

object ConsoleStyle  {
    const val RESET = "\u001B[0m"
    const val RED = "\u001B[31m"
    const val GREEN = "\u001B[32m"
    const val YELLOW = "\u001B[33m"
    const val BLUE = "\u001B[34m"
    const val CYAN = "\u001B[36m"
    const val BOLD = "\u001B[1m"

    fun title(msg: String) = "$BOLD$CYAN$msg$RESET"
    fun success(msg: String) = "$GREEN$msg$RESET"
    fun errorMsg(msg: String) = "$RED$msg$RESET"
    fun label(msg: String) = "$YELLOW$msg$RESET"
    fun info(msg: String) = "$BLUE$msg$RESET"
}