package com.toeii.navigation.contact

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.toeii.navigation.R
import kotlinx.android.synthetic.main.view_contact_list_item.view.*

class ContactList : Fragment(){

    private lateinit var datas : MutableList<Map<String,String>>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        datas = arrayListOf()

        initData()

        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        view.findViewById<RecyclerView>(R.id.rl_contact).adapter = ContactAdapter(activity!!.applicationContext,datas)

        return view

    }

    private fun initData() {

        for(index in 1..30){
            val map:HashMap<String,String> = HashMap<String,String>()
            map["icon"] = R.mipmap.ic_launcher_round.toString()
            map["phone"] = if(index < 10) "1387777666$index" else "138888877$index"
            map["name"] = if(index % 2 == 0) "张$index" else "王$index"
            datas.add(map)
        }

    }

}


class ContactAdapter(private var context: Context,private var datas: MutableList<Map<String,String>>) : RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_contact_list_item,null)
        return ContactHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val mapData = datas[position]
        holder.itemView.iv_head_icon.setImageResource((mapData["icon"] ?: error("")).toInt())
        holder.itemView.tv_name.text = mapData["name"]
        val phone = mapData["phone"]
        holder.itemView.rl_layout.setOnClickListener {
            val builder = Bundle()
            builder.putString("phone",phone)
            Navigation.findNavController(holder.itemView).navigate(R.id.action_contactList_to_contactMessage,builder)
        }
    }

    class ContactHolder(itemView: View): RecyclerView.ViewHolder(itemView)

}