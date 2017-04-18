package com.oppein.repository.crm;


import com.oppein.domain.crm.CrmContractImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CrmContractImageRepository extends JpaRepository<CrmContractImage, Integer> {
    List<CrmContractImage> findById(int id);
}
