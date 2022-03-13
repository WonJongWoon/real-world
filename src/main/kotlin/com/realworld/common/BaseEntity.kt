package com.realworld.common

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class BaseEntity : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = lateInit()

    @CreatedDate
    @Column(updatable = false)
    open var createdAt: LocalDateTime = lateInit()

    @LastModifiedDate
    open var modifiedAt: LocalDateTime = lateInit()
}

@Suppress("UNCHECKED_CAST")
fun <T> lateInit() = null as T
