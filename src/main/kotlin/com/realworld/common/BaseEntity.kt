package com.realworld.common

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class BaseEntity : Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    val id: Long? = lateinit()

    @Column(updatable = false, nullable = false)
    @CreatedDate
    var createdAt: LocalDateTime = lateinit()
        private set

    @Column(nullable = false)
    @LastModifiedDate
    var modifiedAt: LocalDateTime = lateinit()
        private set

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as BaseEntity
        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}

@Suppress("UNCHECKED_CAST")
fun <T> lateinit() = null as T
