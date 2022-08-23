package br.edu.fafic.ppi.domain;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "owner_id")
public class CarStore extends Owner {

    private String cnpj;

    @OneToMany
    private List<Customer> customers;
}
