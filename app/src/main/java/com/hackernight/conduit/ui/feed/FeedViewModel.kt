package com.hackernight.conduit.ui.feed

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackernight.api.model.entities.Article
import com.hackernight.api.model.entities.User
import com.hackernight.conduit.data.ArticleRepo
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {

    private val _feed = MutableLiveData<List<Article>>()

    val feed : LiveData<List<Article>> = _feed

    fun fetchGlobalFeed(){
        viewModelScope.launch {
            ArticleRepo.getGlobalFeed().body()?.let {
                _feed.postValue(it.articles)
            }
        }
    }

}