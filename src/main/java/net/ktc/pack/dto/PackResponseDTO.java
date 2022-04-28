package net.ktc.pack.dto;

import net.ktc.pack.entities.Offre;
import net.ktc.pack.entities.PackDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Collection;


@Data @NoArgsConstructor @AllArgsConstructor
public class PackResponseDTO extends AbstractDefaultValuesResponseDTO implements Serializable{

    private String id;
    private String intitule;
    private String description;
    private Offre offre;
    private Collection<PackDetails> packDetails;

}
