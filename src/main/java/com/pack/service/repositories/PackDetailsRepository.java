package com.pack.service.repositories;

import com.pack.service.entities.Details;
import com.pack.service.entities.Pack;
import com.pack.service.entities.PackDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackDetailsRepository extends JpaRepository<PackDetails, String> {
    List<PackDetails> findByDetails(Details details);
    List<PackDetails> findByPack(Pack pack);
}
