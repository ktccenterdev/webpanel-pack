package net.webpanel.pack.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class DetailsRequestDTO {
    private String id;
    private String caracteristique;
    private String offreId;
}
