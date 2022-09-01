package br.edu.fafic.ppi.domain;

import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "owner_id")
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
public class Customer extends Owner {

    @Column(name = "doc_cpf", unique = true)
    private String cpf;
}
