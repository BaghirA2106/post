package com.post.az.repository;


import com.post.az.entity.TransactionData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionDataRepository extends JpaRepository<TransactionData, Long> {
}
