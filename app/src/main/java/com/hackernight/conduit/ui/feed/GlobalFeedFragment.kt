package com.hackernight.conduit.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.hackernight.conduit.R
import com.hackernight.conduit.ui.gallery.GalleryViewModel

class GlobalFeedFragment : Fragment() {

    private lateinit var feedViewModel: FeedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        val root  = inflater.inflate(R.layout.fragment_feed,container,false)
        return root
    }

}