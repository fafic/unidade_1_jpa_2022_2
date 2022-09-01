package br.edu.fafic.ppi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@SuperBuilder(toBuilder = true)
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
public abstract class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;
    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Vehicle> vehicles;
}
