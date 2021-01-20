package com.hackernight.conduit.ui.article

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hackernight.conduit.databinding.FragmentArticleBinding
import com.hackernight.conduit.extension.loadImage

class ArticleFragment : Fragment() {
    private var _binding : FragmentArticleBinding? = null
    private lateinit var  articleViewModel : ArticleViewModel
    private var articleId : String? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentArticleBinding.inflate(inflater,container,false)

        articleViewModel = ViewModelProvider(this).get(ArticleViewModel::class.java)

        arguments?.let {
             articleId = ArticleFragmentArgs.fromBundle(it).articleId
        }

        articleId?.let {
            articleViewModel.getArticle(it)
        }

        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        articleViewModel.article.observe(viewLifecycleOwner, Observer {
            _binding?.apply {
                authorTextView.text = it.author.username
                bodyTextView.text = it.body
                titleTextView.text = it.title
                dateTextView.text = it.createdAt
                avatarImageView.loadImage(it.author.image,true)
            }
        })


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}