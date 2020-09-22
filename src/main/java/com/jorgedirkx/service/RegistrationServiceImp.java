package com.jorgedirkx.service;

import com.jorgedirkx.entities.Registration;
import com.jorgedirkx.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("registrationService")
public class RegistrationServiceImp implements RegistrationService {

    @Autowired
    private RegistrationRepository registrationRepository;

    @Override
    public List<Registration> getAllRegistrations() {

            return registrationRepository.findAll();
    }

    @Override
    public void saveRegistration(Registration registration) {
        this.registrationRepository.save(registration);

    }

    @Override
    public Registration getRegistrationById(int id) {

        Optional<Registration> optional = registrationRepository.findById(id);
        Registration registration = null;
        if (optional.isPresent()) {
            registration = optional.get();
        } else {
            throw new RuntimeException("Registration not found for id :: " + id);
        }
        return registration;

    }

    @Override
    public void deleteRegistrationById(int id) {
        this.registrationRepository.deleteById(id);

    }
}
