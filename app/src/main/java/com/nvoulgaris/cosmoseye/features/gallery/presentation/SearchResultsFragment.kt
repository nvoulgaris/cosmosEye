package com.nvoulgaris.cosmoseye.features.gallery.presentation

import android.os.Bundle
import com.nvoulgaris.cosmoseye.R
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingFragment

class SearchResultsFragment : BaseInjectingFragment() {

    private lateinit var query: String

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        query = arguments!!.getString(QUERY, DEFAULT_QUERY)
    }

    override fun onInject() {
    }

    override fun getLayoutId(): Int = R.layout.search_results_fragment

    companion object {
        private const val DEFAULT_QUERY = ""
        private const val QUERY = "QUERY"

        fun makeWith(query: String): SearchResultsFragment {
            val args = Bundle()
            args.putString(QUERY, query)
            return fragmentWith(
                args
            )
        }

        private fun fragmentWith(args: Bundle): SearchResultsFragment {
            val fragment = SearchResultsFragment()
            fragment.arguments = args
            return fragment
        }
    }
}
