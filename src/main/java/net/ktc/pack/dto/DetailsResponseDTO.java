package net.ktc.pack.dto;

import net.ktc.pack.entities.Offre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @AllArgsConstructor @NoArgsConstructor
public class DetailsResponseDTO extends AbstractDefaultValuesResponseDTO implements Serializable {
    private String id;
    private String caracteristique;
    private Offre offre;
}
