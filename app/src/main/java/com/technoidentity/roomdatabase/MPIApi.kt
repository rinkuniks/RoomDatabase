package com.technoidentity.roomdatabase

import com.technoidentity.roomdatabase.customers.CustomersResponse
import com.technoidentity.roomdatabase.Urls.CUSTOMERS
import com.technoidentity.roomdatabase.Urls.LOGIN
import retrofit2.Call
import retrofit2.http.*

interface MPIApi
{

//    @POST(LOGIN)

    @GET(CUSTOMERS)
    fun getCustomerDetails(@Query("pageIndex") pageIndex: Int, @Query("pageSize") pageSize: Int): Call<CustomersResponse>

//    @GET(CUSTOMERDETAILS)
//    fun getCustomerDetail(@Path("id") id : Int) : Call<CustomerDetailResponse>
//
//    @GET(COMPANYLIST)
//    fun getCompany(@Query("classificationName") classificationName : String) : Call<ArrayList<CompanyListResponse>>
//
//    @GET(FILTERCOMPANYLIST)
//    fun getFilterCompanyList(@Query("pageIndex") pageIndex : Int, @Query("pageSize") pageSize : Int, @Query("classificationName") classificationName : String,
//                             @Query("propertyName") propertyName : String, @Query("propertyValue") propertyValue : String) : Call<GetFilteredCompanyList>
//
//    @GET(FILTERCATEGORYLIST)
//    fun getFilterCategoryList(@Query("pageIndex", encoded = false) pageIndex : Int, @Query(value = "pageSize",encoded = false) pageSize : Int,
//                              @Query("classificationName") classificationName : String, @Query("propertyName", encoded = false) propertyName : String,
//                              @Query(value = "propertyValue", encoded = false) propertyValue : String) : Call<CategoryFilterResponse>
//
//    @GET(CLASSIFICATION)
//    fun getClassification(@Query("pageIndex") pageIndex : Int, @Query("pageSize") pageSize : Int, @Query("classificationName") classificationName : String)
//            : Call<ClassificationResponse>
//
//    @GET(PRODUCTDETAIL)
//    fun getProductDetail(@Path("productId") productId : Int) : Call<ProductDetailResponse>
//
//    @GET(GETPRODUCTPRICELIST)
//    fun getProductPriceList(@Query("pageIndex") pageIndex: Int, @Query("pageSize") pageSize: Int): Call<ProductPriceResponse>
//
//    @GET(GETCOMPANYLIST)
//    fun getCompanyList(@Query("pageIndex") pageIndex: Int, @Query("pageSize") pageSize: Int): Call<CompanyListResponse>
//
//    @GET(GETCATEGORYLIST)
//    fun getCategoryList(@Query("classificationName") classificationName : String) : Call<ArrayList<CategoryListResponse>>
//
//    @GET(GETPUSHSALE)
//    fun getPushSaleList(@Query("pageIndex") pageIndex: Int, @Query("pageSize") pageSize: Int): Call<PushSaleResponse>
//
//    @POST(PLACEPREORDER)
//    fun getPlacePreOrder(@Body request : PlacePreOrderRequest) : Call<PlacePreOrderResponse>
//
//    @GET(LOCATION)
//    fun getUserLocation(@Path("userId") userId : Int) : Call<LocationUserResponse>
//
//    @GET(INVENTORIESTOCKRECEIVED)
//    fun getInventoryStockreceived(@Path("productId") productId : Int) : Call<ArrayList<InventoryStockReceivedResponse>>
//
//    @GET(PRODUCTPREORDER)
//    fun getProductPreOrder(@Query("pageIndex") pageIndex: Int, @Query("pageSize") pageSize: Int): Call<ProductPreOrderResponse>

}