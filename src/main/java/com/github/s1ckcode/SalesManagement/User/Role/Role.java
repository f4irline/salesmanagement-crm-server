package com.github.s1ckcode.SalesManagement.User.Role;

import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private RoleDefinition definition;

    public Role() {

    }

    public Role(RoleDefinition definition) {
        this.definition = definition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(RoleDefinition definition) {
        this.definition = definition;
    }
}

