package dev.gabrielgianelli.cleanarch9.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.gabrielgianelli.cleanarch9.infra.model.OrderModelJpa;

@Repository
public interface JpaOrderRepository extends JpaRepository<OrderModelJpa, Long>{
}
