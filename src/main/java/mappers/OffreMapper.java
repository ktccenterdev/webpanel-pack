package mappers;

import dto.OffreRequestDTO;
import dto.OffreResponseDTO;
import entities.Offre;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OffreMapper {
    OffreResponseDTO offreToOffreResponseDTO(Offre offre);
    Offre offreRequestDTOTOOffre(OffreRequestDTO offreRequestDTO);
}
