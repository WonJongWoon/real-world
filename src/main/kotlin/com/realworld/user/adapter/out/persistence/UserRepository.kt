package com.realworld.user.adapter.out.persistence

import com.realworld.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
