package com.example.legal.repository;

import com.example.legal.entity.LawFirm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawFirmRepository extends JpaRepository<LawFirm, Long> {
}