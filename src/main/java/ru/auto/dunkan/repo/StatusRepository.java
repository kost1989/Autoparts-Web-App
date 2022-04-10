package ru.auto.dunkan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ru.auto.dunkan.model.Status;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query(value = "select s from Status s where (:id is null or s.id = :id) " +
            "and (:name is null or lower(s.name) like %:name%) " +
            "and (:color is null or s.color = :color) and (:enabled is null or s.enabled = :enabled)")
    List<Status> getListByFilter(@Param("id") Long id,
                                 @Param("name") String name,
                                 @Param("color") String color,
                                 @Param("enabled") Boolean enabled);
}
