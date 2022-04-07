package com.pack.service.mappers;

import com.pack.service.entities.Pack;
import com.pack.service.dto.PackRequestDTO;
import com.pack.service.dto.PackResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackMapper {
    PackResponseDTO packToPackResponseDTO(Pack pack);
    Pack packRequestDTOTOPack(PackRequestDTO packRequestDTO);
}
