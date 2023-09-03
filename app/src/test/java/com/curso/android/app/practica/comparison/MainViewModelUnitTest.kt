package com.curso.android.app.practica.comparison

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.curso.android.app.practica.comparison.view.MainViewModel
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

class MainViewModelUnitTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var observer: Observer<String>

    private lateinit var viewModel: MainViewModel

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel()
        viewModel.result.observeForever(observer)
    }

    @Test
    fun testCompareTexts_equal() {
        viewModel.setText1("Hello")
        viewModel.setText2("Hello")
        viewModel.compareTexts()
        verify(observer).onChanged("Las cadenas son iguales")
    }

    @Test
    fun testCompareTexts_notEqual() {
        viewModel.setText1("Hello")
        viewModel.setText2("World")
        viewModel.compareTexts()
        verify(observer).onChanged("Las cadenas son diferentes")
    }
}

