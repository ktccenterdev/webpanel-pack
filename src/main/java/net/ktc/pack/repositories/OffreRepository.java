package net.ktc.pack.repositories;

import net.ktc.pack.entities.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreRepository extends JpaRepository<Offre, String> {
    Offre findByIntitule(String intitule);
}
