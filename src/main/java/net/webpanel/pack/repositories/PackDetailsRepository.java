package net.webpanel.pack.repositories;

import net.webpanel.pack.entities.Details;
import net.webpanel.pack.entities.Pack;
import net.webpanel.pack.entities.PackDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackDetailsRepository extends JpaRepository<PackDetails, String> {
    List<PackDetails> findByDetails(Details details);
    List<PackDetails> findByPack(Pack pack);
}
