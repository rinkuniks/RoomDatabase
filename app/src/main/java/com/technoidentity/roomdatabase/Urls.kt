package com.technoidentity.roomdatabase

object Urls {

    //Base Url For All
   // const val BASE_URL_MPI = "http://3.16.149.6:3000/api/"
    const val BASE_URL_MPI = "http://183.82.121.156:3333/api/"

    const val LOGIN = "token"

    const val LOCATION = " users/{userId}/locations"

    const val CUSTOMERS = "customers"

    const val CUSTOMERDETAILS = "customers/{id}/details"

    const val PRODUCTPREORDER = "products/preorder"

    const val PRODUCTDETAIL = "products/{productId}/details"

    const val COMPANYLIST = "products/all/companies"

    const val GETCATEGORYLIST = "products/all/categories"

    const val FILTERCOMPANYLIST = "products/preorder"

    const val FILTERCATEGORYLIST = "products/preorder"

    const val CLASSIFICATION = "products/preorder"

    const val GETPRODUCTPRICELIST = "productprices"

    const val GETCOMPANYLIST = "companies"

    const val GETPUSHSALE = "offers" // api used for OFFERS

    const val PLACEPREORDER = "preorders"

    // this api contain BATCH NUMBER
    const val INVENTORIESTOCKRECEIVED = "inventories/stockreceiveds/{productId}"
}
