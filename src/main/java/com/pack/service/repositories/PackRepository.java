package com.pack.service.repositories;

import com.pack.service.entities.Offre;
import com.pack.service.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackRepository extends JpaRepository<Pack, String> {
    List<Pack> findByPack(Offre offre);
}
