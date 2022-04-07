package dto;

import entities.Details;
import entities.Pack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class OffreResponseDTO extends AbstractDefaultValuesResponseDTO implements Serializable {

    private String id;
    private String intitule;
    private String description;
    private Collection<Pack> packs;
    private Collection<Details> details;

}
