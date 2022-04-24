package net.webpanel.pack.dto;

import net.webpanel.pack.entities.Offre;
import net.webpanel.pack.entities.PackDetails;
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
