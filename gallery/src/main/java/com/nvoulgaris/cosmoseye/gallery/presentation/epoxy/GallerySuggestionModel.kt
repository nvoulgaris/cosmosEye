package com.nvoulgaris.cosmoseye.gallery.presentation.epoxy

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.nvoulgaris.cosmoseye.base.gallery.R
import com.nvoulgaris.cosmoseye.gallery.presentation.SearchSuggestion

@EpoxyModelClass
abstract class GallerySuggestionModel : EpoxyModelWithHolder<GallerySuggestionModel.GallerySuggestionHolder>() {

    override fun getDefaultLayout(): Int = R.layout.gallery_search_suggestion_view

    @EpoxyAttribute
    lateinit var suggestion: SearchSuggestion

    @EpoxyAttribute
    lateinit var submitSearchListener: View.OnClickListener

    override fun bind(holder: GallerySuggestionHolder) {
        super.bind(holder)

        holder.apply {
            displayName()
            addListener()
        }
    }

    private fun GallerySuggestionHolder.displayName() {
        name.text = suggestion.name
    }

    private fun GallerySuggestionHolder.addListener() =
        submitImage.setOnClickListener(submitSearchListener)

    class GallerySuggestionHolder : EpoxyHolder() {
        override fun bindView(itemView: View) {
            name = itemView.findViewById(R.id.gallery_search_suggestion_name)
            submitImage = itemView.findViewById(R.id.gallery_search_suggestion_go)
        }

        lateinit var name: TextView
        lateinit var submitImage: ImageView
    }
}
