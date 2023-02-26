package com.example.mytour.fragments

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytour.Imagemodel
import com.example.mytour.R
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import java.util.*

class SearchViewAdapter(
    private var itemList: MutableList<Imagemodel>,
) : RecyclerView.Adapter<SearchViewAdapter.Holder>(), Filterable {

    private var itemListFiltered= mutableListOf<Imagemodel>()


    @SuppressLint("NotifyDataSetChanged")
    fun replaceData(list: MutableList<Imagemodel>) {
        Log.e("DATA", Gson().toJson(list))
        this.itemList = list
        this.itemListFiltered = list
        notifyDataSetChanged()
    }


    class Holder private constructor(view: View) :
        RecyclerView.ViewHolder(view) {
        private var image: ImageView = view.findViewById(R.id.imageURL)
        private var name: TextView = view.findViewById(R.id.name)
        private var description: TextView = view.findViewById(R.id.description)


        fun setData(data: Imagemodel) {
            description.text = data.description
            name.text = data.name
            Picasso.get().load(data.imageURL).into(image)
        }


        companion object {
            fun create(parent: ViewGroup): Holder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_image, parent, false)
                return Holder(view)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Holder = Holder.create(parent)

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.setData(itemListFiltered[position])
    }

    override fun getItemCount(): Int {
        return itemListFiltered.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                itemListFiltered = if (charString.isEmpty()) {
                    itemList
                } else {
                    val filteredList: MutableList<Imagemodel> = ArrayList()
                    for (row in itemList) {


                        if (row.name!!.lowercase(Locale.getDefault())
                                .contains(charString.lowercase(Locale.getDefault()))
                        ) {
                            filteredList.add(row)
                        }
                    }
                    filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = itemListFiltered
                return filterResults
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun publishResults(
                charSequence: CharSequence,
                filterResults: FilterResults
            ) {
                itemListFiltered = filterResults.values as MutableList<Imagemodel>
                notifyDataSetChanged()
            }
        }
    }

}