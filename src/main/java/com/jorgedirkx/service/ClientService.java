package com.jorgedirkx.service;

import com.jorgedirkx.entities.Client;

import java.util.List;

public interface ClientService {

    List<Client> getAllClients();
    void saveClient(Client client);
    Client getClientById(int id);
    void deleteClientById(int id);
}
