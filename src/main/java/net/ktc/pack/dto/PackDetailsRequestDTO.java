package net.ktc.pack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class PackDetailsRequestDTO{

    private String id;
    private String packId;
    private String DetailsId;
    private String valeur;
}
