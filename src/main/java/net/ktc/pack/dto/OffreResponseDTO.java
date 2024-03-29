package net.ktc.pack.dto;

import net.ktc.pack.entities.Pack;
import net.ktc.pack.entities.Details;
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
