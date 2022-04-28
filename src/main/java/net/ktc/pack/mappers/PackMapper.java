package net.ktc.pack.mappers;

import net.ktc.pack.entities.Pack;
import net.ktc.pack.dto.PackRequestDTO;
import net.ktc.pack.dto.PackResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackMapper {
    PackResponseDTO packToPackResponseDTO(Pack pack);
    Pack packRequestDTOTOPack(PackRequestDTO packRequestDTO);
}
