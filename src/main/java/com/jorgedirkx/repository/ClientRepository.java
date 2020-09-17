package com.jorgedirkx.repository;

import com.jorgedirkx.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,String> {

    //manually added, necessary ?
    public void deleteById(int id);

    public Optional<Client> findById(int id);


}
