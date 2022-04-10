package ru.auto.dunkan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auto.dunkan.model.Part;

@Repository
public interface PartRepository extends JpaRepository<Part, Long> {
}
