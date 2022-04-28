package net.ktc.pack.mappers;

import net.ktc.pack.dto.PackDetailsRequestDTO;
import net.ktc.pack.dto.PackDetailsResponseDTO;
import net.ktc.pack.entities.PackDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackDetailsMapper {
    PackDetailsResponseDTO packDetailsToPackDetailsResponseDTO(PackDetails packDetails);
    PackDetails packDetailsRequestDTOTOPackDetails(PackDetailsRequestDTO packDetailsRequestDTO);
}
