package josipursan.ferit.lv4_mvvm

import io.reactivex.Single

interface ApiService{
    fun getUsers(): Single<List<User>>
}



