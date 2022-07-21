package com.example.testtask

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun booksList() = FragmentScreen { BooksListFragment() }
    fun bookInfo(bundle: Bundle) = FragmentScreen { BookInfoFragment(bundle) }
}