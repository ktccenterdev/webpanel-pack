package entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PackDetails extends AbstractDefaultValues implements Serializable {
    @Id
    private String id;

    @Column(nullable = true)
    private String valeur;

    @ManyToOne
    private Pack pack;

    @ManyToMany
    private Details details;


}
