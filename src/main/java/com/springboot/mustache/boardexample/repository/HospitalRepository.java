package com.springboot.mustache.boardexample.repository;

import com.springboot.mustache.boardexample.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
