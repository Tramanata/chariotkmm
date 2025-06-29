//package com.chariot.backend.controller
//
//import com.chariot.backend.model.User
//import com.chariot.backend.repository.UserRepository
//import org.springframework.web.bind.annotation.*
//
//@RestController
//@RequestMapping("/users")
//class UserController(private val userRepository: UserRepository) {
//
//    @GetMapping
//    fun getAllUsers(): List<User> = userRepository.findAll()
//
//    @PostMapping
//    fun createUser(@RequestBody user: User): User = userRepository.save(user)
//}
