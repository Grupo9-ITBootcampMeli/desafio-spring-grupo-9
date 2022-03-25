package br.com.group9.springapplicationgroup9.Util;

import br.com.group9.springapplicationgroup9.Entity.Client;
import br.com.group9.springapplicationgroup9.Util.Interfaces.IJsonHandler;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Component
public class ClientHandler implements IJsonHandler<Client> {

    private final String CLIENTS_PATH = DEFAULT_PATH.concat("clients.json");
    private final File CLIENTS_FILE = new File(CLIENTS_PATH);
    private ObjectMapper objectMapper;

    public ClientHandler() {
        objectMapper = new ObjectMapper();
    }


    @Override
    public List<Client> read() {

        try{
            return objectMapper.readValue(CLIENTS_FILE, new TypeReference<List<Client>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean save(List<Client> list) {

        try{
            objectMapper.writeValue(CLIENTS_FILE, list);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
