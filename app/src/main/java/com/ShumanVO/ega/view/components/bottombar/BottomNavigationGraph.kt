package com.ShumanVO.ega.view.components.bottombar

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ShumanVO.ega.view.pages.BasketFavoritesView
import com.ShumanVO.ega.view.pages.HomeView
import com.ShumanVO.ega.view.pages.ProfileView
import com.ShumanVO.ega.view.pages.SettingsView

@Composable
fun BottomNavigationGraph(
    navController : NavHostController,

    /*
    есть и просто NavController, что делает тоже самое
    но в интернете отмечано, что NavHostController исп-уют
    именно для NavHost

    нужен сам для хранения дерева переходов между элементами
    (возможность вернуться на предыдущий элемент и тд тп)
     */
)
{
    // контейнер графа навигации
    //связь route(пути) и destination(место назначения)
    NavHost(
        navController = navController,
        startDestination = BottomBar.Home.route //установка начального экрана навигации
    ){
        composable(route = BottomBar.Home.route) {
            HomeView.View()
        }
        composable(route = BottomBar.BasketFavorites.route) {
            BasketFavoritesView.View()
        }
        composable(route = BottomBar.Settings.route) {
            SettingsView.View(isChecked = false) {}
        }
        composable(route = BottomBar.Profile.route) {
            ProfileView.View()
        }
    }
}