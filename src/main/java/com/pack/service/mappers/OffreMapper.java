package com.pack.service.mappers;

import com.pack.service.entities.Offre;
import com.pack.service.dto.OffreRequestDTO;
import com.pack.service.dto.OffreResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OffreMapper {
    OffreResponseDTO offreToOffreResponseDTO(Offre offre);
    Offre offreRequestDTOTOOffre(OffreRequestDTO offreRequestDTO);
}
