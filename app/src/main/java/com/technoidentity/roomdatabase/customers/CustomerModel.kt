package com.technoidentity.roomdatabase.customers

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customerListDb")
data class CustomerModel(
    @PrimaryKey
    var id: Int? = null,
    var name: String? = null,
    var warehouseId: String? = null,
    var warehouseName: String? = null,
    var customerType: String? = null,
    var buildingName: String? = null,
    var city: String? = null,
    var province: String? = null,
    var areaCode: String? = null,
    var phoneNumber: String? = null,
    var primaryContactPerson: String? = null,
    var primaryContactNumber: String? = null,
    var primaryEmail: String? = null,
    var secondaryContactPerson: String? = null,
    var secondaryContactNumber: String? = null,
    var secondaryEmail: String? = null,
    var address: String? = null,
    var creditLimit: Double? = null,
    var description: String? = null,
    var latitude: Double? = null,
    var longitude: Double? = null,
    var updatedBy: Int? = null,
    var createdAt: String? = null
)