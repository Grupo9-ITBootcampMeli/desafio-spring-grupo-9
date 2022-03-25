package br.com.group9.springapplicationgroup9.Controller;


import br.com.group9.springapplicationgroup9.Entity.Client;
import br.com.group9.springapplicationgroup9.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {

    @Autowired
    public ClientService clientService;

    @PostMapping("/v1/clients")
    public ResponseEntity<String> getClients(@RequestBody List<Client> client) {
        clientService.registerClient(client);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/v1/clients")
    public String insertClient(@RequestParam String params) {
        return "Foi";
    }

}
