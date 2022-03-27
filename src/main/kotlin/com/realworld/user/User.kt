package com.realworld.user

import com.realworld.common.BaseEntity
import com.realworld.dto.UserResponse
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Table(name = "USERS")
@Entity
class User(

    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    val username: String,

    @Column(nullable = false)
    val password: String,

    @Column(nullable = false)
    val bio: String,

    @Column(nullable = true)
    val image: String?
) : BaseEntity()
