package com.example.mvvm.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvm.R
import com.example.mvvm.databinding.ViewBinding
import com.example.mvvm.model.Mainlist


internal class MyAdapter(private var empList : ArrayList<Mainlist>
): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    internal inner class MyViewHolder(val binding:ViewBinding) : RecyclerView.ViewHolder(binding.root)


    fun updatelist(newemplist:ArrayList<Mainlist>){
        empList.clear()
        empList.addAll(newemplist)
        notifyDataSetChanged()

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        return MyViewHolder(ViewBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val emp = empList[position]
        holder.binding.name.text = emp.name
        holder.binding.id.text =emp.id



        Glide.with(holder.itemView.context).load(emp.url).into(holder.binding.img)


    }

    override fun getItemCount(): Int {
        return empList.size

    }

}
