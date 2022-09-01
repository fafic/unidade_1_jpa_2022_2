package br.edu.fafic.ppi.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mark;
    private String model;
    private Double value;
    private Integer year;
    @ManyToOne(cascade = CascadeType.MERGE)
    @ToString.Exclude
    private Owner owner;

    @ManyToMany
    private List<Accessory> accesories;


}
