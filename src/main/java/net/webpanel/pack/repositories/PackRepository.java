package net.webpanel.pack.repositories;

import net.webpanel.pack.entities.Pack;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackRepository extends JpaRepository<Pack, String> {
}
