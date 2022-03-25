package br.com.group9.springapplicationgroup9.Service;

import br.com.group9.springapplicationgroup9.Entity.Client;
import br.com.group9.springapplicationgroup9.Repository.ClientRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Service
public class ClientService {

    @Autowired
    public ClientRepository repository;

    public void registerClient(List<Client> client){
        repository.addAll(client);
    }

}
