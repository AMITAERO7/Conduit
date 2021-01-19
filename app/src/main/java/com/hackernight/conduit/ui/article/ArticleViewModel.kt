package com.hackernight.conduit.ui.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackernight.api.model.entities.Article
import com.hackernight.api.model.responses.ArticleResponse
import com.hackernight.conduit.data.ArticleRepo
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {

    private val _article = MutableLiveData<Article>()
    val article : LiveData<Article> = _article

    fun getArticle(slug:String){
        viewModelScope.launch {
            ArticleRepo.getArticles(slug).body()?.let {
                _article.postValue(it.article)
            }
        }
    }
}