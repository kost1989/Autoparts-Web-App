package ru.auto.dunkan.repository;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.auto.dunkan.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
