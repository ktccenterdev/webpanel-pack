package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Offre extends AbstractDefaultValues implements Serializable {

    @Id
    private String id;
    @Column(nullable = false, unique = true)

    private String intitule;
    @Column(nullable = true)

    private String description;

    @OneToMany(mappedBy = "offre")
    private Collection<Pack> packs = new ArrayList<>();

    @OneToMany(mappedBy = "offre")
    private List<Details> details = new ArrayList<>();


}
