package net.webpanel.pack.mappers;

import net.webpanel.pack.entities.Offre;
import net.webpanel.pack.dto.OffreRequestDTO;
import net.webpanel.pack.dto.OffreResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OffreMapper {
    OffreResponseDTO offreToOffreResponseDTO(Offre offre);
    Offre offreRequestDTOTOOffre(OffreRequestDTO offreRequestDTO);
}
