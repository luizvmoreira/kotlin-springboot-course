package com.mercadolivro.application.model

import javax.persistence.*

@Entity(name = "customer")
data class CustomerModel(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int?,
    @Column
    var name: String,
    @Column
    var email: String
)