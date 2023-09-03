package com.curso.android.app.practica.comparison.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _text1 = MutableLiveData<String>()
    private val _text2 = MutableLiveData<String>()
    private val _result = MutableLiveData<String>()

    val text1: LiveData<String> = _text1
    val text2: LiveData<String> = _text2
    val result: LiveData<String> = _result

    fun compareTexts() {
        val isEqual = _text1.value == _text2.value
        _result.value = if (isEqual) "Las cadenas son iguales" else "Las cadenas son diferentes"
    }

    fun setText1(text: String) {
        _text1.value = text
    }

    fun setText2(text: String) {
        _text2.value = text
    }
}
