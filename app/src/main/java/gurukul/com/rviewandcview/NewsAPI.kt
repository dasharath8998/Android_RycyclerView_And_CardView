package gurukul.com.rviewandcview

import gurukul.com.rviewandcview.Beans.Articles
import retrofit2.Call
import retrofit2.http.GET

interface NewsAPI {
    @GET("top-headlines?sources=google-news&apiKey=54f168a44f6d40909953636bef85136a")
    fun getNews(): Call<Articles>
}