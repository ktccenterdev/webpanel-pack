package net.ktc.pack.repositories;

import net.ktc.pack.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepository extends JpaRepository<Pack, String> {
}
