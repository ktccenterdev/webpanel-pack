package net.ktc.pack.repositories;

import net.ktc.pack.entities.Details;
import net.ktc.pack.entities.Pack;
import net.ktc.pack.entities.PackDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackDetailsRepository extends JpaRepository<PackDetails, String> {
    List<PackDetails> findByDetails(Details details);
    List<PackDetails> findByPack(Pack pack);
}
