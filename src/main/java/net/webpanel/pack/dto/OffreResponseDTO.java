package net.webpanel.pack.dto;

import net.webpanel.pack.entities.Details;
import net.webpanel.pack.entities.Pack;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor
public class OffreResponseDTO extends AbstractDefaultValuesResponseDTO implements Serializable {

    private String id;
    private String intitule;
    private String description;
    private Collection<Pack> packs;
    private Collection<Details> details;

}
