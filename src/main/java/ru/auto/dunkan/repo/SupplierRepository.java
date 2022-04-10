package ru.auto.dunkan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.auto.dunkan.model.Supplier;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query(value = "select s from Supplier s where (:id is null or s.id = :id) " +
            "and (:name is null or s.name like %:name%) and (:url is null or s.url like %:url%)" +
            "and (:comments is null or s.comments like %:comments%) and (:enabled is null or s.enabled = :enabled)")
    List<Supplier> getListByFilter(@Param(value = "id") Long id,
                                   @Param(value = "name") String name,
                                   @Param(value = "url") String url,
                                   @Param(value = "comments") String comments,
                                   @Param(value = "enabled") Boolean enabled);
}
