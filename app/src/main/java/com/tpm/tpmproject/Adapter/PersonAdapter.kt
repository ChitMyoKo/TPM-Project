package com.tpm.tpmproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tpm.tpmproject.Activity.StudentProfileActivity
import com.tpm.tpmproject.DataClass.Person
import com.tpm.tpmproject.ViewHolders.PersonViewHolder

class PersonAdapter(var context: Context, var layout: Int ,var list: List<Person>): RecyclerView.Adapter<PersonViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(layout,parent,false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.profession.text = list[position].profession
        holder.profile.setImageResource(list[position].profile)
        holder.itemView.setOnClickListener {
            context.startActivity(StudentProfileActivity.newIntent(context))
        }
    }

}