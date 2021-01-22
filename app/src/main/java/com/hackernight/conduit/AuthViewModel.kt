package com.hackernight.conduit

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

    fun getCurrrentUser(token:String) {
        viewModelScope.launch {
            UserRepo.getCurrentUser(token)?.let {
                _user.postValue(it.user)
            }
        }
    }

    fun login(email:String,password:String){
        viewModelScope.launch {
            UserRepo.login(email,password)?.let {
                _user.postValue(it.user)
            }
        }
    }

    fun signUp(userName:String,email: String,password: String){
        viewModelScope.launch {
            UserRepo.signUp(userName,email, password)?.let {
                _user.postValue(it.user)
            }
        }
    }

    fun updateUser(bio:String,userName: String,image:String,email: String,password: String){
        viewModelScope.launch {
            UserRepo.updateCurrentUser(bio,userName,image,email,password)?.let {
                _user.postValue(it.user)
            }
        }
    }

    fun logoutUser(){
        _user.postValue(null)
    }
}