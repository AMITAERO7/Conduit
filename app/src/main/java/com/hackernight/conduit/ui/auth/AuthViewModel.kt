package com.hackernight.conduit.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hackernight.api.model.entities.User
import com.hackernight.conduit.data.UserRepo
import kotlinx.coroutines.launch

class AuthViewModel : ViewModel() {

    private val _user = MutableLiveData<User?>()

    val user :LiveData<User?> = _user

    fun login(email:String,password:String){
        viewModelScope.launch {
            UserRepo.login(email,password)?.let {
                _user.postValue(it.user)
            }
        }
    }
}