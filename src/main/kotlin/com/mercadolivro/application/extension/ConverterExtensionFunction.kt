package com.mercadolivro.application.extension

import com.mercadolivro.application.controller.request.PostCustomerRequest
import com.mercadolivro.application.controller.request.PutCustomerRequest
import com.mercadolivro.application.model.CustomerModel

fun PostCustomerRequest.convertToCustomerModel(): CustomerModel {
    return CustomerModel(id = null, name = this.name, email = this.email)
}

fun PutCustomerRequest.convertToCustomerModel(id: Int): CustomerModel {
    return CustomerModel(id = id, name = this.name, email = this.email)
}