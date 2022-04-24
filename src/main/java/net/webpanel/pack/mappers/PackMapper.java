package net.webpanel.pack.mappers;

import net.webpanel.pack.entities.Pack;
import net.webpanel.pack.dto.PackRequestDTO;
import net.webpanel.pack.dto.PackResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackMapper {
    PackResponseDTO packToPackResponseDTO(Pack pack);
    Pack packRequestDTOTOPack(PackRequestDTO packRequestDTO);
}
