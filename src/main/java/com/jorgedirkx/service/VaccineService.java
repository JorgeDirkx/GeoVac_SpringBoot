package com.jorgedirkx.service;

import com.jorgedirkx.entities.Client;
import com.jorgedirkx.entities.Vaccine;

import java.util.List;

public interface VaccineService {

    List<Vaccine> getAllVaccines();
    void saveVaccine(Vaccine vaccine);
    Vaccine getVaccineById(int id);
    void deleteVaccineById(int id);
}
