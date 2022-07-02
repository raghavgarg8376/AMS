package com.audit.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.audit.model.AuditResponse;

public interface AuditResponseRepo extends JpaRepository<AuditResponse,Integer>{

}
