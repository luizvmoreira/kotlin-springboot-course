package com.mercadolivro.application.controller

import com.mercadolivro.application.controller.request.PostCustomerRequest
import com.mercadolivro.application.controller.request.PutCustomerRequest
import com.mercadolivro.application.model.CustomerModel
import com.mercadolivro.application.extension.convertToCustomerModel
import com.mercadolivro.application.service.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(
    val customerService: CustomerService
) {

    @GetMapping
    fun getAll(@RequestParam name: String?): List<CustomerModel> {
        return customerService.getAll(name)
    }

    @GetMapping("/{id}")
    fun getCustomer(@PathVariable id: Int): CustomerModel {
        return customerService.getCustomer(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody customer: PostCustomerRequest) {
        customerService.create(customer.convertToCustomerModel())
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun update(@PathVariable id: Int, @RequestBody updatedCustomer: PutCustomerRequest) {
        customerService.update(updatedCustomer.convertToCustomerModel(id))
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun remove(@PathVariable id: Int) {
        customerService.remove(id)
    }

}