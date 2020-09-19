package com.jorgedirkx.controller;

import com.jorgedirkx.entities.Client;
import com.jorgedirkx.entities.Vaccine;
import com.jorgedirkx.repository.VaccineRepository;
import com.jorgedirkx.service.ClientService;
import com.jorgedirkx.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class ClientController {

    @Autowired
    private ClientService clientService;

/*
    //good practice ? multiple controllers cause of hibernate ?
    @Autowired
    private VaccineService vaccineService;
    */

    // display list of clients
    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listClients", clientService.getAllClients());
        return "index";
    }

    @GetMapping("/showNewClientForm")
    public String showNewClientForm(Model model) {
        // create model attribute to bind form data
        Client client = new Client();
        model.addAttribute("client", client);
        return "new_employee";
    }

    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client) {
        // save client to database
        clientService.saveClient(client);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        // get employee from the service
        Client client = clientService.getClientById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", client);
        return "update_employee";
    }

    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable(value = "id") int id) {

        // call delete client method
        this.clientService.deleteClientById(id);
        return "redirect:/";
    }
}
