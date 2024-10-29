package com.indra.book_my_show.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;

    @Column(unique = true, nullable = false)
    private String email;

    @NonNull
    @Column(unique = true)
    private String mobNo;

    private String address;

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL)
    private List<TicketEntity> bookedTickets = new ArrayList<>();

}

