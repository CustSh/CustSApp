package com.ShumanVO.ega.view.components.bottombar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBar (
    /*
    ключевое слово sealed означает, что класс запечатанный
    оно ограничивает и контролирует возможные подклассы
    т.е. Все подклассы sealed класса должны быть объявлены
    в пределах файла с sealed классом
     */
    val route : String, //путь к кнопке
    val title : String, //навзание под кнопкой
    val icon : ImageVector // иконка кнопки
)
{
    /*
    что такое object Home?
    ключевое слове object объявляет класс
    и создаёт его экзмепляр
    "удобен для паттерна "Одиночка"" (из статьи)
    здесь нам нужен отдельный класс Home и
    нам хватит и одного его экземпляра
     */
    object Home : BottomBar(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Profile : BottomBar(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )

    object Settings : BottomBar(
        route = "settings",
        title = "Settings",
        icon = Icons.Default.Settings
    )

    object BasketFavorites : BottomBar(
        route = "basketfavorites",
        title = "Basket And Favorites",
        icon = Icons.Default.Favorite
    )
}