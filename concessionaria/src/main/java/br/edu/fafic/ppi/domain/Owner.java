package br.edu.fafic.ppi.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToOne
    private Address address;
    @OneToOne
    private Contact contact;
    @OneToMany
    private List<Vehicle> vehicles;
}
