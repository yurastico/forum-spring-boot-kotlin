package com.yurastico.forum.model

import jakarta.persistence.*
import net.minidev.json.annotate.JsonIgnore

@Entity
data class User(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String,
        val email: String,
        val password: String,

        @JsonIgnore
        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "user_role", // Name of the join table
                joinColumns = [JoinColumn(name = "user_id")], // Join column in the join table referencing the current entity
                inverseJoinColumns = [JoinColumn(name = "role_id")] // Join column in the join table referencing the related entity
        )
        val role: List<Role> = mutableListOf()
)
