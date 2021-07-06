package ru.auto.dunkan.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auto.dunkan.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
