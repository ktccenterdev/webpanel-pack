package dto;

import entities.AbstractDefaultValues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data @AllArgsConstructor @NoArgsConstructor
public class DetailsRequestDTO {
    private String id;
    private String caracteristique;
    private String offreId;
}
