package com.jorgedirkx.service;

import com.jorgedirkx.entities.Registration;

import java.util.List;

public interface RegistrationService {

    List<Registration> getAllRegistrations();
    void saveRegistration(Registration registration);
    Registration getRegistrationById(int id);
    void deleteRegistrationById(int id);
}
