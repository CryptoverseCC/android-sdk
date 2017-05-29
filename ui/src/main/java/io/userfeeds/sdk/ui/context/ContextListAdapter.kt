package io.userfeeds.sdk.ui.context

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import io.userfeeds.sdk.core.context.ShareContext
import io.userfeeds.sdk.ui.R

class ContextListAdapter(private val contexts: List<ShareContext>, private val onContextSelect: (ShareContext) -> Unit) : RecyclerView.Adapter<ContextListAdapter.Holder>() {

    override fun getItemCount() = contexts.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.userfeeds_context_item, parent, false)
        return Holder(itemView)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val context = contexts[position]
        val contextImageView = holder.itemView.findViewById(R.id.userfeeds_context_image) as ImageView
        Glide.with(holder.itemView.context)
                .load(context.imageUrl)
                .into(contextImageView)
        val contextTextView = holder.itemView.findViewById(R.id.userfeeds_context_name) as TextView
        contextTextView.text = context.hashtag
        holder.itemView.setOnClickListener {
            onContextSelect(context)
        }
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)
}
