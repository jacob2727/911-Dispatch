package com.dispatch.user.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "user")
public class UserModel {

    @Id
    @Column(name = "id")
    private String id;


    @Column(name = "roles")
    private List<String> roles;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "picture")
    private String picture;


}
