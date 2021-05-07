package pl.github.gpietrzyk.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

@Entity
@Table(name = "users")
public class User implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @NotBlank(message = "User's email must not be empty!")
    private String email;

    @NotBlank(message = "User's password must not be empty!")
    private String password;

    @NotBlank(message = "User's first name must not be empty!")
    private String firstName;

    @NotBlank(message = "User's last name must not be empty!")
    private String lastName;

    @NotBlank(message = "User's city must not be empty!")
    private String city;

    private String phone;

    private boolean active;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinTable(name = "users_roles", joinColumns = {@JoinColumn(name = "user_id")}, inverseJoinColumns = {
                @JoinColumn(name = "role_id") })
    private List<Role> roles = new ArrayList<>();



}

