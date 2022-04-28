package net.ktc.pack.repositories;

import net.ktc.pack.entities.Details;
import net.ktc.pack.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailsRepository extends JpaRepository<Details, String> {
    List<Details> findByOffre(Offre offre);
}
