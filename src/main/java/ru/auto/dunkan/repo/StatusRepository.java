package ru.auto.dunkan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.auto.dunkan.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {
    public Status getStatusByName(String name);
}
