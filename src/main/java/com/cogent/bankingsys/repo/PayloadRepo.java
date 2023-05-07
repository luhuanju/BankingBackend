package com.cogent.bankingsys.repo;

import com.cogent.bankingsys.entity.Payload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PayloadRepo extends JpaRepository<Payload, Long> {

    @Override
    Optional<Payload> findById(Long along);
}
