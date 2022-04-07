package dto;

import entities.Details;
import entities.Pack;

import java.io.Serializable;

public class PackDetailsResponseDTO extends AbstractDefaultValuesResponseDTO implements Serializable {
    private String id;
    private Pack pack;
    private Details details;
    private String valeur;
}
