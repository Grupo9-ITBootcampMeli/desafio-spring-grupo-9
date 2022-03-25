package br.com.group9.springapplicationgroup9.Repository;

import br.com.group9.springapplicationgroup9.Entity.Client;
import br.com.group9.springapplicationgroup9.Repository.Interfaces.IRepository;
import br.com.group9.springapplicationgroup9.Util.ClientHandler;
import br.com.group9.springapplicationgroup9.Util.ProductHandler;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Repository
public class ClientRepository implements IRepository<Client, Long> {

    @Autowired
    private ClientHandler jsonFile;


    @Override
    public void add(Client newClient) {

    }

    @Override
    public void addAll(List<Client> newClient) {
        List<Client> clients = jsonFile.read();
        System.out.println(newClient);
        clients.addAll(newClient);
        jsonFile.save(clients);
    }

    @Override
    public Client get(Long id) {
        return null;
    }

    @Override
    public List<Client> getAll() {
        return null;
    }
}
