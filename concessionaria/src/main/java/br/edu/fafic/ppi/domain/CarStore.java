package br.edu.fafic.ppi.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "owner_id")
public class CarStore extends Owner {

    @Column(unique = true)
    private String cnpj;

    @OneToMany
    private List<Customer> customers;
}
