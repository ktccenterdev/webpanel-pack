package repositories;

import entities.Details;
import entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailsRepository extends JpaRepository<Details, String> {
    List<Details> findByOffre(Offre offre);
}
