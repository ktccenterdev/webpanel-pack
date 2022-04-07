package com.pack.service.dto;

import com.pack.service.entities.Details;
import com.pack.service.entities.Pack;

import java.io.Serializable;

public class PackDetailsResponseDTO extends AbstractDefaultValuesResponseDTO implements Serializable {
    private String id;
    private Pack pack;
    private Details details;
    private String valeur;
}
