package com.hackernight.conduit.ui.feed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hackernight.conduit.R
import com.hackernight.conduit.databinding.FragmentFeedBinding

class MyFeedFragment : Fragment() {

    private var _binding : FragmentFeedBinding? = null
    private lateinit var feedViewModel: FeedViewModel
    private lateinit var feedAdapter: ArticleFeedAdapter

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        feedViewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        feedAdapter = ArticleFeedAdapter { openArticle(it) }

        _binding = FragmentFeedBinding.inflate(inflater,container,false)
        _binding?.feedRecyclerView?.layoutManager = LinearLayoutManager(context)
        _binding?.feedRecyclerView?.adapter = feedAdapter
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        feedViewModel.fetchMyFeed()
        feedViewModel.feed.observe(viewLifecycleOwner, Observer {
            feedAdapter.submitList(it)
        })
    }

    fun openArticle(articleId:String){
        /*findNavController().navigate(
                R.id.action_navfeed_articlefragment,
                bundleOf(
                        resources.getString(R.string.article_id) to articleId
                )
        )*/
        val action = GlobalFeedFragmentDirections.actionNavfeedArticlefragment(articleId)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}