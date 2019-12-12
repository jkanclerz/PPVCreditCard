package pl.krakow.uek.pp5.jkan.banking.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ClientController {

    @Autowired
    ClientRepository clientRepository;

    @GetMapping("/api/clients/{id}")
    ClientData client(@PathVariable String id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException());
    }

    @PostMapping("/api/client")
    String create(@RequestBody ClientData clientData) {
        clientData.setId(UUID.randomUUID().toString());
        clientRepository.save(clientData);

        return clientData.getId();
    }
    @GetMapping("/api/clients")
    Iterable<ClientData> all() {
        return clientRepository.findAll();
    }
 }
