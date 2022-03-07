package com.example.roomdatabasemvvm.ui.viewmodels

import androidx.lifecycle.*
import com.example.roomdatabasemvvm.database.model.Word
import com.example.roomdatabasemvvm.repository.WordRepository
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class WordViewModel (private val repository: WordRepository) : ViewModel() {

    val allWords : LiveData<List<Word>> = repository.allWords.asLiveData()


//    Nenhuma inserção de dados deve ser realizada na thread principal do aplicativo
//    neste caso utilizamos a thread da própria viewModel
    fun insert(word: Word) = viewModelScope.launch {
        repository.insert(word)
    }

}

class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }

        throw IllegalArgumentException("Unknow ViewModel class")
    }

}