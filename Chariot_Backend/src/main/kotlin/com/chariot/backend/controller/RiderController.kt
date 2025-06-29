package com.chariot.backend.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicInteger

@RestController
@RequestMapping("/api/rides")
class RideController {

    data class Ride(val id: Int, val pickup: String, val destination: String)

    private val rides = mutableListOf(
        Ride(1, "123 Main St", "456 Oak Ave"),
        Ride(2, "789 Elm St", "101 Pine Blvd")
    )

    private val idCounter = AtomicInteger(rides.size + 1)

    @GetMapping
    fun getAllRides(): List<Ride> = rides

    @GetMapping("/{id}")
    fun getRideById(@PathVariable id: Int): ResponseEntity<Ride> {
        val ride = rides.find { it.id == id }
        return if (ride != null) ResponseEntity.ok(ride)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createRide(@RequestBody newRide: RideRequest): ResponseEntity<Ride> {
        val ride = Ride(idCounter.getAndIncrement(), newRide.pickup, newRide.destination)
        rides.add(ride)
        return ResponseEntity.ok(ride)
    }

    @PutMapping("/{id}")
    fun updateRide(@PathVariable id: Int, @RequestBody updated: RideRequest): ResponseEntity<Ride> {
        val index = rides.indexOfFirst { it.id == id }
        return if (index != -1) {
            val updatedRide = Ride(id, updated.pickup, updated.destination)
            rides[index] = updatedRide
            ResponseEntity.ok(updatedRide)
        } else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteRide(@PathVariable id: Int): ResponseEntity<Void> {
        val removed = rides.removeIf { it.id == id }
        return if (removed) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }

    data class RideRequest(val pickup: String, val destination: String)
}
