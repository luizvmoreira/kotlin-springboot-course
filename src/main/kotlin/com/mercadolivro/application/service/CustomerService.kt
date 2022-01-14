package com.mercadolivro.application.service

import com.mercadolivro.application.model.CustomerModel
import com.mercadolivro.application.repository.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    val customerRepository: CustomerRepository
) {

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customerRepository.findByNameContaining(it)
        }
        return customerRepository.findAll().toList()
    }

    fun getCustomer(id: Int): CustomerModel {
        return customerRepository.findById(id)
            .orElseThrow()
    }

    fun create(customer: CustomerModel) {
        customerRepository.save(customer)
        println("Customer created: $customer")
    }

    fun update(updatedCustomer: CustomerModel) {
        if (!customerRepository.existsById(updatedCustomer.id!!)) {
            throw Exception()
        }
        customerRepository.save(updatedCustomer)

        println("Customer updated with ID: ${updatedCustomer.id}")
    }

    fun remove(id: Int) {
        if (!customerRepository.existsById(id)) {
            throw Exception()
        }
        customerRepository.deleteById(id)

        println("Customer deleted with ID: $id")
    }

}