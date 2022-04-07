package com.pack.service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Details extends AbstractDefaultValues implements Serializable {
    @Id
    private String id;

    @Column(nullable = false)
    private String caracteristique;

    @OneToMany(mappedBy = "details")
    private Collection<PackDetails> packDetails;

    @ManyToOne
    private Offre offre;
}
