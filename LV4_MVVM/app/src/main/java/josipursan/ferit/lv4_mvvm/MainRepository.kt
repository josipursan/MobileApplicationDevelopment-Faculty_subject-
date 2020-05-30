package josipursan.ferit.lv4_mvvm

import io.reactivex.Single

class MainRepository (private val apiHelper: ApiHelper)
{
    fun getUsers(): Single<List<User>>
    {
        return apiHelper.getUsers()
    }
}