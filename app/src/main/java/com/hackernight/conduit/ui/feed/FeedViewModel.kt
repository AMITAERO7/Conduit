package com.hackernight.conduit.ui.feed

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackernight.api.model.entities.Article
import com.hackernight.conduit.data.ArticleRepo
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {

    val _feed = MutableLiveData<List<Article>>()

    fun fetchGlobalFeed(){
        viewModelScope.launch {
            ArticleRepo.getGlobalFeed().body()?.let {
                _feed.postValue(it.articles)
                Log.d("FEED",it.articlesCount.toString())
            }
        }
    }

}