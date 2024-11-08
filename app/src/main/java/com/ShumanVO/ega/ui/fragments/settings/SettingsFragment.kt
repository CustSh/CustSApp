package com.ShumanVO.ega.ui.fragments.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class SettingsFragment : Fragment()
{
    private var isChecked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setContent {
                var checkedState by remember { mutableStateOf(isChecked) }
                SettingsView.View(
                    isChecked = checkedState,
                    onCheckedChange = {
                        newChecked -> checkedState = newChecked
                        //м.б. сохранение где-то
                    }
                )
            }
        }
    }
}