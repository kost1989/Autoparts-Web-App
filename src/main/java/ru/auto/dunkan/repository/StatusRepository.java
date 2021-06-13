package ru.auto.dunkan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auto.dunkan.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
}
