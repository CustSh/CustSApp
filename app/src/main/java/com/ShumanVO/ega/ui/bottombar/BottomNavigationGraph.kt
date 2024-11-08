package com.ShumanVO.ega.ui.bottombar

import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ShumanVO.ega.R
import com.ShumanVO.ega.ui.fragments.FragmentContainer
import com.ShumanVO.ega.ui.fragments.home.HomeFragment
import com.ShumanVO.ega.ui.fragments.home.HomeView
import com.ShumanVO.ega.ui.fragments.profile.ProfileFragment
import com.ShumanVO.ega.ui.fragments.profile.ProfileView
import com.ShumanVO.ega.ui.fragments.settings.SettingsFragment
import com.ShumanVO.ega.ui.fragments.settings.SettingsView

@Composable
fun BottomNavigationGraph(
    navController : NavHostController,
    fragmentManager: FragmentManager,
    fragmentContainerId: Int
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
            switchFragment(
                fragmentManager = fragmentManager,
                HomeFragment(),
                containerId = fragmentContainerId
            )
        }
        composable(route = BottomBar.Settings.route) {
            switchFragment(
                fragmentManager = fragmentManager,
                SettingsFragment(),
                containerId = fragmentContainerId
            )
        }
        composable(route = BottomBar.Profile.route) {
            switchFragment(
                fragmentManager = fragmentManager,
                ProfileFragment(),
                containerId = fragmentContainerId
            )
        }
    }
}

private fun switchFragment(
    fragmentManager : FragmentManager,//тот, что и отвечает за замену
    fragment: Fragment,//на что меняем
    containerId : Int//откуда меняем
)
{
    fragmentManager.beginTransaction()
        .replace(containerId, fragment)
        .commit()
}