package dto;

import entities.AbstractDefaultValues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor
public class PackRequestDTO {

    private String id;
    private String intitule;
    private String description;
    private String offreId ;
}
