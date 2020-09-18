package com.jorgedirkx.repository;

import com.jorgedirkx.entities.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<Vaccine,Integer> {


}
