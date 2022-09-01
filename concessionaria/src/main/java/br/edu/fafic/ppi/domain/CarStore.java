package br.edu.fafic.ppi.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "owner_id")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@Data
public class CarStore extends Owner {

    @Column(unique = true, nullable = false)
    private String cnpj;

    @OneToMany(cascade = CascadeType.REFRESH, orphanRemoval = true)
    private List<Customer> customers;

}
