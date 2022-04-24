package net.webpanel.pack.dto;

import net.webpanel.pack.entities.Details;
import net.webpanel.pack.entities.Pack;

import java.io.Serializable;

public class PackDetailsResponseDTO extends AbstractDefaultValuesResponseDTO implements Serializable {
    private String id;
    private Pack pack;
    private Details details;
    private String valeur;
}
