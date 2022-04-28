package net.ktc.pack.mappers;

import net.ktc.pack.dto.OffreResponseDTO;
import net.ktc.pack.entities.Offre;
import net.ktc.pack.dto.OffreRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OffreMapper {
    OffreResponseDTO offreToOffreResponseDTO(Offre offre);
    Offre offreRequestDTOTOOffre(OffreRequestDTO offreRequestDTO);
}
