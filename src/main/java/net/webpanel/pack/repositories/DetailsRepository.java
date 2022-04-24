package net.webpanel.pack.repositories;

import net.webpanel.pack.entities.Details;
import net.webpanel.pack.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailsRepository extends JpaRepository<Details, String> {
    List<Details> findByOffre(Offre offre);
}
