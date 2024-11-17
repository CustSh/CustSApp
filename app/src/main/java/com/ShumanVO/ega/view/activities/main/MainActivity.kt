package com.ShumanVO.ega.view.activities.main

import android.os.Bundle
import android.view.View
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.ShumanVO.ega.view.theme.EgaTheme
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            //функция, что описанна в соответсвующем import
            //сейчас исп для управления темой(светлая, темная, кастом ...)
            EgaTheme {
                MainScreenView()
            }
        }
    }
}
