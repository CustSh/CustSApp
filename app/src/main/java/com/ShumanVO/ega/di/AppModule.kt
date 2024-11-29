package com.ShumanVO.ega.di

import com.ShumanVO.ega.viewmodel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {HomeViewModel()}
}