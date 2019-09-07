package com.technoidentity.roomdatabase.customers

import com.google.gson.annotations.SerializedName
import com.technoidentity.roomdatabase.customers.CustomerModel

class CustomersResponse {
    @SerializedName("count")
    var count: Int? = null
    @SerializedName("rows")
    lateinit var customerList: List<CustomerModel>

}