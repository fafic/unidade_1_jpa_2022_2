package br.edu.fafic.ppi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "owner_id")
public class Customer extends Owner {

    @Column(name = "doc_cpf", unique = true)
    private String cpf;
}
