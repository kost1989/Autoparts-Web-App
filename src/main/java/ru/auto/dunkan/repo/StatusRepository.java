package ru.auto.dunkan.repo;

import org.springframework.stereotype.Repository;
import ru.auto.dunkan.model.Status;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

@Repository
public interface StatusRepository extends CrudRepository<Status, Long> {

    Optional<Status> findById(Long id);

}
