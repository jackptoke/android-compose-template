package dev.toke.dispatch3.navigation

enum class Screen {
    PrinterScreen,
    EmployeeScreen
}

sealed class NavigationItem(val route: String) {
    object Printer : NavigationItem(Screen.PrinterScreen.name)
    object Employee : NavigationItem(Screen.EmployeeScreen.name)
}