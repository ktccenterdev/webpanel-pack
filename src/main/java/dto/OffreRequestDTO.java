package dto;

import entities.AbstractDefaultValues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Collection;

@Data @NoArgsConstructor @AllArgsConstructor
public class OffreRequestDTO{

    private String id;
    private String intitule;
    private String description;


}
