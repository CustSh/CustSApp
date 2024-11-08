package com.ShumanVO.ega.ui.activities.main

import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ShumanVO.ega.ui.theme.EgaTheme
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            //функция, что описанна в соответсвующем import
            //сейчас исп для управления темой(светлая, темная, кастом ...)
            EgaTheme {
                //это свойство, нам "дали добро" для использования F.M.
                val fragmentManager = supportFragmentManager
                //генерация ключа для контейнера фрагментов
                val fragmentContainerId = View.generateViewId()
                MainScreenView(
                    fragmentManager = fragmentManager
                )
            }
        }
    }
}
