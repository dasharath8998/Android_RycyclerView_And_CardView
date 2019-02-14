package gurukul.com.rviewandcview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import gurukul.com.rviewandcview.Beans.Article
import gurukul.com.rviewandcview.Beans.Articles
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var lManager = LinearLayoutManager(this@MainActivity,LinearLayoutManager.VERTICAL,false)
        var gManager = GridLayoutManager(this@MainActivity,3)
        rView.layoutManager = lManager //gManager

        var r = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://newsapi.org/v2/").build()
        var api = r.create(NewsAPI::class.java)
        var call = api.getNews()
        call.enqueue(object : Callback<Articles> {
            override fun onFailure(call: Call<Articles>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Get News Failed",Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<Articles>, response: Response<Articles>) {
                var art = response.body()
                var list: List<Article>? = art?.articles
                rView.adapter = MyAdapter(this@MainActivity,list)
            }
        })

        fab.setOnClickListener {
            var s = Snackbar.make(it,"Are You Sure You Want To Exit...",Snackbar.LENGTH_INDEFINITE)
            s.setAction("Yes",{
                System.exit(0)
            })
            s.show()
        }
    }
}
