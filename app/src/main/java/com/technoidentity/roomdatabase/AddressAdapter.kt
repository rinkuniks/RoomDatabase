package com.technoidentity.roomdatabase

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.technoidentity.roomdatabase.customers.CustomerModel
import kotlinx.android.synthetic.main.recyclerview_addressactivity.view.*

class AddressAdapter (val context : Context,private var arrayList : List<CustomerModel>)
    : RecyclerView.Adapter<AddressAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val view = LayoutInflater.from(p0.context)
            .inflate(R.layout.recyclerview_addressactivity, p0, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(p0: MyViewHolder, p1: Int) {
        val addressModel = arrayList[p1]
        p0.name.text = addressModel.name
        p0.streetNum.text = addressModel.address
        p0.streetLoc.text = addressModel.city
        if (p1 % 2 == 1) {
            p0.colorBar.setBackgroundColor(Color.parseColor("#68B231"))
        } else {
            p0.colorBar.setBackgroundColor(Color.parseColor("#FAA632"))
        }
    }

    fun filterList(filteredList: ArrayList<CustomerModel>) {
        arrayList = filteredList
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name: TextView = itemView.textView_name_customer
        val streetNum: TextView = itemView.textView_streetNum_customer
        val streetLoc: TextView = itemView.textView_streetname_customer
        val colorBar: ImageView = itemView.colorbar_addressActivity
        private val detailedList: ImageView = itemView.detailed_customerList
        private val location: ImageView = itemView.navigation_customerLocation
        private val layoutAddress: LinearLayout = itemView.layout_address_info

    }
}