package com.mobile.tenantmanagementsystem

import java.io.Serializable
data class Tenant(
    val name: String,
    val phone: String,
    val rent: String

) : Serializable {

    // Unchanged: the text shown by @{tenant.summary()}
    fun summary(): String {
        return "Tenant: $name\nPhone: $phone\nRent: KSh $rent"
    }
}