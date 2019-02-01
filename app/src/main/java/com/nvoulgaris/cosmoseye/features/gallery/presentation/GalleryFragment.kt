package com.nvoulgaris.cosmoseye.features.gallery.presentation

import android.os.Bundle
import android.support.v7.widget.SearchView
import android.view.View
import com.nvoulgaris.cosmoseye.R
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingActivity
import com.nvoulgaris.cosmoseye.base.presentation.BaseInjectingFragment
import com.nvoulgaris.cosmoseye.features.gallery.presentation.epoxy.GallerySuggestionsRecyclerController
import com.nvoulgaris.cosmoseye.features.home.presentation.HomeActivity
import kotlinx.android.synthetic.main.gallery_fragment.*

class GalleryFragment : BaseInjectingFragment() {

    private val historySuggestions = listOf(
        SearchSuggestion("1", "Orion"),
        SearchSuggestion("2", "Moon"),
        SearchSuggestion("3", "Sun")
    )
    private lateinit var recyclerController: GallerySuggestionsRecyclerController

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        addRecyclerController()
        addSearchView()
    }

    private fun addRecyclerController() {
        recyclerController = GallerySuggestionsRecyclerController { suggestion -> submitSearchListener(suggestion) }
        gallery_search_suggestions.setController(recyclerController)
    }

    private fun addSearchView() {
        showKeyboard()
        gallery_search_view.requestFocus()
        gallery_search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(query: String): Boolean {
                if (query.isEmpty()) resetSuggestions() else populateSuggestionsByMatching(query)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                gallery_search_view.clearFocus()
                return true
            }

            private fun resetSuggestions() = recyclerController.setData(emptyList())

            private fun populateSuggestionsByMatching(query: String) =
                recyclerController.setData(suggestionsMatching(query))

            private fun suggestionsMatching(query: String) = historySuggestions.filter { matching(it, query) }

            private fun matching(suggestion: SearchSuggestion, query: String) =
                suggestion.name.startsWith(query, ignoreCase = true)
        })
    }

    private fun submitSearchListener(suggestion: SearchSuggestion) {
        hideKeyboard()
        val fragment = SearchResultsFragment.makeWith(suggestion.name)
        (activity as HomeActivity).flipOpen(fragment)
    }

    override fun onInject() {
        val activity = activity as BaseInjectingActivity<*>
        val componentCreator = activity.getComponent() as GalleryComponent.GalleryComponentCreator
        componentCreator.createGalleryComponent().inject(this)
    }

    override fun getLayoutId(): Int = R.layout.gallery_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        attachListeners()
    }

    private fun attachListeners() {
    }
}
