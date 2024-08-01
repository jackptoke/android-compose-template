package dev.toke.dispatch3.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dev.toke.dispatch3.ui.screen.printer.PrinterScreen

@Composable
fun NavigationHost(
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.PrinterScreen.name
    ) {
        composable(NavigationItem.Printer.route) {
            PrinterScreen(navController)
        }
    }
}