package org.pet.entities;

import lombok.Getter;
import lombok.Setter;
import org.pet.enums.RoleType;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
@Getter
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('ROLE_USER', 'ROLE_ADMIN')")
    private RoleType role;
}
