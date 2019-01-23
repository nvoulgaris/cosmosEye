package com.nvoulgaris.cosmoseye.gallery.presentation.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.nvoulgaris.cosmoseye.gallery.presentation.SearchSuggestion

class GallerySuggestionsRecyclerController : TypedEpoxyController<List<SearchSuggestion>>() {

    override fun buildModels(suggestions: List<SearchSuggestion>?) {
        if (suggestions == null || suggestions.isEmpty()) {
            return
        }

        suggestions.forEach {
            addGallerySuggestionModelWith(it)
        }
    }

    private fun addGallerySuggestionModelWith(suggestion: SearchSuggestion) =
            GallerySuggestionModel_()
                .id(suggestion.id)
                .suggestion(suggestion)
                .addTo(this)
}
