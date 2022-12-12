package com.thanhthien.cuoiki.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "db_roles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleEnity extends BaseEntity {
    public static final String AUTHOR_ADMIN = "ROLE_ADMIN";
    public static final String AUTHOR_USER = "ROLE_USER";

    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<UserEntity> users;
}
