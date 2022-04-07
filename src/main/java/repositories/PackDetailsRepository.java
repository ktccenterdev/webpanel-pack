package repositories;

import entities.Details;
import entities.Pack;
import entities.PackDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackDetailsRepository extends JpaRepository<PackDetails, String> {
    List<PackDetails> findByDetails(Details details);
    List<PackDetails> findByPack(Pack pack);
}
