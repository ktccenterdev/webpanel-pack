package net.webpanel.pack.mappers;

import net.webpanel.pack.dto.DetailsRequestDTO;
import net.webpanel.pack.entities.Details;
import net.webpanel.pack.dto.DetailsResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetailsMapper {
    DetailsResponseDTO detailsToDetailsResponseDTO(Details details);
    Details detailsRequestDTOTODetails(DetailsRequestDTO detailsRequestDTO);
}
