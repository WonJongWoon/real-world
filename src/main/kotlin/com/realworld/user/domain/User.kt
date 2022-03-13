package com.realworld.user.domain

import com.realworld.common.BaseEntity
import javax.persistence.Entity
import javax.persistence.Table

@Table(name = "user")
@Entity
class User(
    var username: String,
    var email: String,
    var password: String,
    var bio: String,
    var image: String,
) : BaseEntity()
