package com.technoidentity.roomdatabase

import androidx.room.*
import com.technoidentity.roomdatabase.customers.CustomerModel

@Dao
interface EmpDAO
{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrReplaceAll(list : List<CustomerModel>)

    @Delete
    fun delete (items : CustomerModel)

    @Query("SELECT * FROM customerListDb ")
    fun fetchAll(): List<CustomerModel>
}
