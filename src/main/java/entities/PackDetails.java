package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
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
