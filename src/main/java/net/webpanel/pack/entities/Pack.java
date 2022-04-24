package net.webpanel.pack.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Pack extends AbstractDefaultValues implements Serializable {

    @Id
    private String id;

    @Column(nullable = false)
    private String intitule;

    @Column(nullable = true)
    private String description;

    @ManyToOne
    @JsonIgnore
    private Offre offre;

    @OneToMany(mappedBy = "pack")
    @JsonIgnore
    private Collection<PackDetails> packDetails;

}
