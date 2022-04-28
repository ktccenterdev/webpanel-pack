package net.ktc.pack.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Collection<PackDetails> packDetails;

    @ManyToOne
    @JsonIgnore
    private Offre offre;
}
