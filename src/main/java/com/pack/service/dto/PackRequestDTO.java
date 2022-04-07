package com.pack.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PackRequestDTO {

    private String id;
    private String intitule;
    private String description;
    private String offreId ;
}
