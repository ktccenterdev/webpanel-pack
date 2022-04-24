package net.webpanel.pack.mappers;

import net.webpanel.pack.dto.PackDetailsRequestDTO;
import net.webpanel.pack.dto.PackDetailsResponseDTO;
import net.webpanel.pack.entities.PackDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackDetailsMapper {
    PackDetailsResponseDTO packDetailsToPackDetailsResponseDTO(PackDetails packDetails);
    PackDetails packDetailsRequestDTOTOPackDetails(PackDetailsRequestDTO packDetailsRequestDTO);
}
