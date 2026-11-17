package com.example.swapcampus_mamaabbas.shared.domain

import kotlinx.datetime.LocalDate
import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ListingStatusTest {

    private val sold = Sold(LocalDate(2026, 11, 18))

    // TODO Exercise 1 · Unit
    // Check the rules of canTransitionTo (shared/src/commonMain/.../domain/ListingStatus.kt):
    //   - Available -> Sold is refused (a listing must be reserved first)
    //   - Sold -> Available is allowed (the sale is cancelled)
    // Hint: Available.canTransitionTo(sold) returns a Boolean. Use assertFalse and assertTrue.
    // Check: ./gradlew :shared:testAndroidHostTest
    @Test
    fun canTransitionTo_followsTheAllowedTransitions() {
        TODO("Exercise 1: write this test")
    }
}
