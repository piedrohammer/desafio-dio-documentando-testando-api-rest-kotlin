package me.dio.creditapplicationsystem.dto.request

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import me.dio.creditapplicationsystem.entity.Credit
import me.dio.creditapplicationsystem.entity.Customer
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull("Invalid input") val creditValue: BigDecimal,
    @field:Future val dayFirstOfInstallment: LocalDate,
    @field:Min(value = 1) @field:Max(value = 48) val numberOfInstallments: Int,
    @field:NotNull("Invalid input") val customerId: Long
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )
}
