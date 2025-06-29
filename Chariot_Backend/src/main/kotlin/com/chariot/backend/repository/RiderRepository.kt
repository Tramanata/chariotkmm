package com.chariot.backend.repository

import com.chariot.backend.model.Rider
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RiderRepository : JpaRepository<Rider, Int>
