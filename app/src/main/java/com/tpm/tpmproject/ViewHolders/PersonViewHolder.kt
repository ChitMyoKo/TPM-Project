package com.tpm.tpmproject.ViewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.person.view.*

class PersonViewHolder(view: View): RecyclerView.ViewHolder(view) {
    var name = view.tvPersonName
    var profession = view.tvProfession
    var profile = view.ivPerson
}