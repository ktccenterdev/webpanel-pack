package net.ktc.pack.dto;

import net.ktc.pack.entities.Details;
import net.ktc.pack.entities.Pack;

import java.io.Serializable;

public class PackDetailsResponseDTO extends AbstractDefaultValuesResponseDTO implements Serializable {
    private String id;
    private Pack pack;
    private Details details;
    private String valeur;
}
