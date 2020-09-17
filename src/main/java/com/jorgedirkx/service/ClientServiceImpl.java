package com.jorgedirkx.service;

import com.jorgedirkx.entities.Client;
import com.jorgedirkx.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
    @Override
    public void saveClient(Client client){
        this.clientRepository.save(client);
    }

    @Override
    public Client getClientById(int id) {
        Optional<Client>optional = clientRepository.findById(id);
        Client client = null;
        if (optional.isPresent()) {
            client = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return client;
    }

    @Override
    public void deleteClientById(int id) {
        this.clientRepository.deleteById(id);

    }
}
