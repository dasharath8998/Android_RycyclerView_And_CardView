package gurukul.com.rviewandcview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.indview.view.*

class MyHolder(v: View) : RecyclerView.ViewHolder(v) {
    var title: TextView? = null
    var image: ImageView? = null
    var desc: TextView? = null

    init {
        title = v.tvTitle
        image = v.iView
        desc = v.tvDesc
    }
}