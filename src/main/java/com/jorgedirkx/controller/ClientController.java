package com.jorgedirkx.controller;

import com.jorgedirkx.entities.Client;
import com.jorgedirkx.entities.Location;
import com.jorgedirkx.entities.Vaccine;
import com.jorgedirkx.repository.VaccineRepository;
import com.jorgedirkx.service.ClientService;
import com.jorgedirkx.service.RegistrationService;
import com.jorgedirkx.service.VaccineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class ClientController {

    @Autowired
    @Qualifier("clientService")
    private ClientService clientService;

    @Autowired
    private VaccineService vaccineService;

    @Autowired
    @Qualifier("registrationService")
    private RegistrationService registrationService;


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
        return "new_client";
    }

    @PostMapping("/saveClient")
    public String saveClient(@ModelAttribute("client") Client client) {
        // save client to database
        clientService.saveClient(client);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {

        // get client from the service
        Client client = clientService.getClientById(id);

        // set client as a model attribute to pre-populate the form
        model.addAttribute("client", client);
        return "update_client";
    }

    @GetMapping("/deleteClient/{id}")
    public String deleteClient(@PathVariable(value = "id") int id) {

        // call delete client method
        this.clientService.deleteClientById(id);
        return "redirect:/";
    }

    //adding vaccine to a client

    @GetMapping("addClientVaccine/{id}")
    public String addVaccine(@PathVariable(value = "id") int id, Model model){
        Client client = clientService.getClientById(id);

        // set client as a model attribute to pre-populate the form
        model.addAttribute("client", client);
        model.addAttribute("registration", registrationService.getAllRegistrations());
        /*
        model.addAttribute("registration", registrationService.getAllRegistrations());
        model.addAttribute("client", clientService.getClientById(id));
        */

        return "add_client_vaccine";
    }


}
