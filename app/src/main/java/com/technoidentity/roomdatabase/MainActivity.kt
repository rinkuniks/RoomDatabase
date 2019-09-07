package com.technoidentity.roomdatabase

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.technoidentity.roomdatabase.customers.CustomerModel
import com.technoidentity.roomdatabase.customers.CustomersResponse
import com.technoidentity.roomdatabase.retrofit.MpiSource
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.activityUiThread
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.longToast

class MainActivity : AppCompatActivity() {

    private var dataBase: AppDB? = null
    private lateinit var recyclerView: RecyclerView
    private lateinit var myAdapter: AddressAdapter
    private lateinit var arrayList: List<CustomerModel>
    private val TAG = MainActivity::class.java.simpleName
    private var progress: ProgressDialog? = null
    private var source = MpiSource()
    private lateinit var response: List<CustomerModel>
    private lateinit var items: List<CustomerModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseInitialize()

        getServiceCall(0, 100)
    }

    private fun getServiceCall(i: Int, i1: Int) {
       // call Api functionality with response of it.
    }

    private fun saveData(arrayList: List<CustomerModel>) {
        doAsync {
            val currentDBPath = getDatabasePath("app_database").absolutePath
            println("DBPath is $currentDBPath")
            dataBase?.empDAO()?.insertOrReplaceAll(arrayList)

            val musicAlbums = dataBase?.empDAO()?.fetchAll()
            activityUiThread {
                longToast("Data Got saved")
                refreshUIWith(musicAlbums!!)
            }
        }
    }

    private fun refreshUIWith(musicAlbums: List<CustomerModel>) {
        recyclerView = recyclerView_customer
        recyclerView.layoutManager = LinearLayoutManager(this)
        myAdapter = AddressAdapter(this, musicAlbums)
        recyclerView.adapter = myAdapter
        myAdapter.notifyDataSetChanged()
    }

    private fun showLoadingDialog() {
        if (progress == null) {
            progress = ProgressDialog(this)
            progress!!.setTitle("MPI")
            progress!!.setMessage("Loading......")
        }
        progress?.show()
        progress?.setCancelable(false)
    }

    private fun dismissLoadingDialog() {
        if (progress != null && progress!!.isShowing) {
            progress?.dismiss()
        }
    }

    private fun databaseInitialize() {
        dataBase = AppDB.getDatabase(applicationContext)
    }
}
