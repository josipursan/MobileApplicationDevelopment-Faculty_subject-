package josipursan.ferit.lv4_mvvm

class ApiHelper (private val apiService: ApiService)
{
    fun getUsers() = apiService.getUsers()
}