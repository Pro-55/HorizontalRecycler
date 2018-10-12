package com.example.admin.horizontalrecycler

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.OrientationHelper
import android.support.v7.widget.RecyclerView
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_image_list.*

class ImageListActivity : AppCompatActivity(), OnClickEvent {
    private lateinit var recyclerView: RecyclerView

    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_list)

        val img_id: IntArray = intArrayOf(R.drawable.x0, R.drawable.x1, R.drawable.x2, R.drawable.x3, R.drawable.x4, R.drawable.x5)


        viewManager = LinearLayoutManager(this, OrientationHelper.HORIZONTAL, false)
        viewAdapter = imageListAdapter(img_id, this, this)

        recyclerView = findViewById<RecyclerView>(R.id.idRvImageList).apply {

            //setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

    }

    override fun itemOnClick(id: Int) {
        val imgAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.fade_in)
        idIvFullImageView.startAnimation(imgAnim)
        idIvFullImageView.setImageResource(id)
    }
}
