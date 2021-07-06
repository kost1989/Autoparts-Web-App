package ru.auto.dunkan.repo;

import ru.auto.dunkan.model.Status;

import java.awt.*;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Long> {

    Optional<Status> findById(Long id);

    Status findByColor(Color color);
}
