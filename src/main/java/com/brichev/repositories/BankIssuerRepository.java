package com.brichev.repositories;

import com.brichev.models.BankIssuer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface BankIssuerRepository extends JpaRepository<BankIssuer, Integer> {
    List<BankIssuer> findByUrlAndAndTargetName(String url, String targetName);
    void removeById(Integer id);
}