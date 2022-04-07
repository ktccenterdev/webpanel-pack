package repositories;

import entities.Offre;
import entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackRepository extends JpaRepository<Pack, String> {
    List<Pack> findByPack(Offre offre);
}
