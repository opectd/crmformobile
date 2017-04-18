package com.oppein.repository.crm;

import com.oppein.domain.crm.CrmClient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<CrmClient, Integer> {
    List<CrmClient> findById(int id);
}
