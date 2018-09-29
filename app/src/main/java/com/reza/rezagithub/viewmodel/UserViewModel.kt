package com.reza.rezagithub.viewmodel

import android.arch.lifecycle.MutableLiveData
import com.reza.rezagithub.User
import com.reza.rezagithub.UserRepository
import com.reza.rezagithub.di.OBSERVER_ON
import com.reza.rezagithub.di.SUBCRIBER_ON
import io.reactivex.Scheduler
import javax.inject.Inject
import javax.inject.Named


private const val USER_TO_FETCH = "rezakhmf"

class UserViewModel @Inject constructor(private  val userRepository: UserRepository,
                                        @param:Named(SUBCRIBER_ON) private  val subscribeOn: Scheduler,
                                        @param:Named(OBSERVER_ON) private val observeOn: Scheduler): BaseViewModel() {
    val user: MutableLiveData<User?> = MutableLiveData()
    val isLoading: MutableLiveData<Boolean?> = MutableLiveData()
    val errorMessage: MutableLiveData<String?> = MutableLiveData()

    init {
        isLoading.value = false
    }

    fun getUser(){
        this.disposable.addAll(this.userRepository.getUser(USER_TO_FETCH)
                .subscribeOn(subscribeOn)
                .observeOn(observeOn)
                .doOnSubscribe {this.isLoading.value = true}
                .doOnComplete {this.isLoading.value = false}
                .doOnError { this.isLoading.value = false }
                .subscribe({ this.user.value = it }, {this.errorMessage.value = it.message }))
    }
}