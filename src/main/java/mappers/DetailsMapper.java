package mappers;

import dto.DetailsRequestDTO;
import dto.DetailsResponseDTO;
import entities.Details;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetailsMapper {
    DetailsResponseDTO detailsToDetailsResponseDTO(Details details);
    Details detailsRequestDTOTODetails(DetailsRequestDTO detailsRequestDTO);
}
