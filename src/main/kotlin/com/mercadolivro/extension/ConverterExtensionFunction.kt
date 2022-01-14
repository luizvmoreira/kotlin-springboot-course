package com.mercadolivro.extension

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.controller.request.PutCustomerRequest
import com.mercadolivro.model.CustomerModel

fun PostCustomerRequest.convertToCustomerModel(): CustomerModel {
    return CustomerModel(id = null, name = this.name, email = this.email)
}

fun PutCustomerRequest.convertToCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}