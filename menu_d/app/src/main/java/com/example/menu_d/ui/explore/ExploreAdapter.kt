package com.example.menu_d.explore

import android.content.Context
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.menu_d.R

class ExploreAdapter(private val context: Context, private val imageList: List<ExploreItem>) :
    RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_explore, parent, false)
        return ExploreViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        val item = imageList[position]
        holder.imageView.setImageResource(item.imageResId)
        holder.imageTitle.text = item.title

        // Register for Context Menu on Long Press
        holder.itemView.setOnLongClickListener {
            holder.itemView.showContextMenu()
            true
        }

        holder.itemView.setOnCreateContextMenuListener { menu, _, _ ->
            menu.setHeaderTitle("Select an option")

            menu.add(0, 1, 0, "View Image").setOnMenuItemClickListener {
                Toast.makeText(context, "Viewing ${item.title}", Toast.LENGTH_SHORT).show()
                true
            }

            menu.add(0, 2, 1, "Share Image").setOnMenuItemClickListener {
                Toast.makeText(context, "Sharing ${item.title}", Toast.LENGTH_SHORT).show()
                true
            }

            menu.add(0, 3, 2, "Delete Image").setOnMenuItemClickListener {
                Toast.makeText(context, "Deleting ${item.title}", Toast.LENGTH_SHORT).show()
                true
            }
        }
    }

    override fun getItemCount(): Int = imageList.size

    class ExploreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val imageTitle: TextView = itemView.findViewById(R.id.imageTitle)
    }
}
