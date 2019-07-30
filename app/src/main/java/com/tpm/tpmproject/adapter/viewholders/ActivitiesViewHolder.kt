package com.tpm.tpmproject.adapter.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tpm.tpmproject.model.Activities
import kotlinx.android.synthetic.main.activities.view.*

class ActivitiesViewHolder(var view: View,private val onClickItem: (activity: Activities)->Unit): RecyclerView.ViewHolder(view) {
    fun setData(activity : Activities)
    {
        view.tvActivitiesTitle.text = activity.title
        view.tvActivitiesSubTitle.text = activity.subTitle
        view.tvFavorite.text = activity.favorite
        view.tvComment.text = activity.comment
        view.tvSeen.text = activity.seen
        view.ivActivitiesBgImage.setImageResource(activity.bgImage)
        view.setOnClickListener {
            onClickItem(activity)
        }
    }
}