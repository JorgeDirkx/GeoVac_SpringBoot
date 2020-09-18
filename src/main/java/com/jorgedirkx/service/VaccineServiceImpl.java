package com.jorgedirkx.service;

import com.jorgedirkx.entities.Client;
import com.jorgedirkx.entities.Vaccine;
import com.jorgedirkx.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class VaccineServiceImpl implements VaccineService {

    @Autowired
    VaccineRepository vaccineRepository;

    @Override
    public List<Vaccine> getAllVaccines() {
        return vaccineRepository.findAll();
    }

    @Override
    public void saveVaccine(Vaccine vaccine) {
        this.vaccineRepository.save(vaccine);

    }

    @Override
    public Vaccine getVaccineById(int id) {
        Optional<Vaccine> optional = vaccineRepository.findById(id);
        Vaccine vaccine = null;
        if (optional.isPresent()) {
            vaccine = optional.get();
        } else {
            throw new RuntimeException(" Vaccine not found for id :: " + id);
        }
        return vaccine;
    }

    @Override
    public void deleteVaccineById(int id) {
        this.vaccineRepository.deleteById(id);

    }
}
