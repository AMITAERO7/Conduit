package com.hackernight.conduit.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackernight.conduit.R

class GlobalFeedFragment : Fragment() {

    private lateinit var feedViewModel: FeedViewModel
    private lateinit var feedAdapter: ArticleFeedAdapter
    private lateinit var feedRecyclerView : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        val root  = inflater.inflate(R.layout.fragment_feed,container,false)

        feedRecyclerView = root.findViewById(R.id.feedRecyclerView)
        feedAdapter = ArticleFeedAdapter()
        feedRecyclerView.layoutManager = LinearLayoutManager(context)
        feedRecyclerView.adapter = feedAdapter

        feedViewModel.fetchGlobalFeed()
        feedViewModel.feed.observe(viewLifecycleOwner, Observer {
            feedAdapter.submitList(it)
        })

        return root
    }

}