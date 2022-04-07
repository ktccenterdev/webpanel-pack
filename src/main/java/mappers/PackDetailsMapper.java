package mappers;

import dto.PackDetailsRequestDTO;
import dto.PackDetailsResponseDTO;
import entities.PackDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PackDetailsMapper {
    PackDetailsResponseDTO packDetailsToPackDetailsResponseDTO(PackDetails packDetails);
    PackDetails packDetailsRequestDTOTOPackDetails(PackDetailsRequestDTO packDetailsRequestDTO);
}
