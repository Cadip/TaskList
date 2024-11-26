package week13.paba.tasklist

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapterRecView(private val listTask: ArrayList<task>) : RecyclerView.Adapter<adapterRecView.ListViewHolder>() {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _nama = itemView.findViewById<TextView>(R.id.namaTask)
        var _deskripsi = itemView.findViewById<TextView>(R.id.deskripsiTask)
        var _deadline = itemView.findViewById<TextView>(R.id.deadlineTask)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recycler, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listTask.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        var task = listTask[position]

        holder._nama.setText(task.nama)
        holder._deskripsi.setText(task.deskripsi)
        holder._deadline.setText(task.deadline)
    }

}