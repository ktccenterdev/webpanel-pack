package mappers;

import dto.PackRequestDTO;
import dto.PackResponseDTO;
import entities.Pack;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackMapper {
    PackResponseDTO packToPackResponseDTO(Pack pack);
    Pack packRequestDTOTOPack(PackRequestDTO packRequestDTO);
}
