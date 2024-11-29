package com.ShumanVO.ega.view.activities.main

import android.annotation.SuppressLint
import android.view.View
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.material.BottomNavigation
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ShumanVO.ega.view.components.bottombar.BottomBar
import com.ShumanVO.ega.view.components.bottombar.BottomNavigationGraph


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreenView(
)//функция для отображеня главного экрана
{
    val navController = rememberNavController()
        //создает экземпляр NavHostController
        //кот запоминался по мере выполенения программы
    Scaffold (
        /*
        я бы назвал его своего родом Layout, где уже всё разделено по
        часто используемым элементам пользовательского интерфейса
        (верх, низ, менюбар, центр и тп)
         */
        bottomBar = { BottomBarView(navController = navController) }
    )
    {
        Box(modifier = Modifier.fillMaxSize())
        {
            BottomNavigationGraph(
                navController = navController,
            )
        }
    }
}

@Composable
fun BottomBarView(navController: NavHostController)
{
    //это наш список нижней панели навигации
    val pages = listOf(
        BottomBar.Home,
        BottomBar.BasketFavorites,
        BottomBar.Settings,
        BottomBar.Profile
    )
    //создает переменную-делегата
        /*
        делегат -- объект, что указывает на метод
         */
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination


    BottomNavigation { //компонет jetpack, что и создаёт нижнюю панель из BottomNavigationItem
        pages.forEach { page->
            AddItemView(
                page = page,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
//функция в рамках(Scope?) RowScope
// можно воспользоваться в Row
fun RowScope.AddItemView(
    page : BottomBar,
    currentDestination: NavDestination?,
    navController: NavHostController
){
    BottomNavigationItem( //отдельный элемент BottomNavigation
        label = {
            Text(text = page.title)
        },
        icon = {
            Icon(
                imageVector = page.icon,
                contentDescription = "Navigation Icon"
            )
        },
        //проверяет, выбран ли данный Item, ну и описание условия, при кот считается выбранным
        selected = currentDestination?.hierarchy?.any{
            //currentDestination -- текущая конечная точка навигации
            //hierarchy -- её свойство, что возвращает иерархию всех родительских маршрутов
            //any{} -- проврка на "хотя бы один элемент обладает этим условием?"
            it.route == page.route
        } == true,
        //описание, что происходит в противном случае
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(page.route){
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}