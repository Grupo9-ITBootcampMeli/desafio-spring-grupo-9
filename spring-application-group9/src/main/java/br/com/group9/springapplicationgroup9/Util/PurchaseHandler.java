package br.com.group9.springapplicationgroup9.Util;

import br.com.group9.springapplicationgroup9.Dto.PurchaseDTO;
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
public class PurchaseHandler implements IJsonHandler<PurchaseDTO> {
    private final String PURCHASE_PATH = DEFAULT_PATH.concat("purchases.json");
    private final File PURCHASE_FILE = new File(PURCHASE_PATH);
    private ObjectMapper objectMapper;

    public PurchaseHandler() {
        objectMapper = new ObjectMapper();
    }

    @Override
    public List<PurchaseDTO> read() {
        try {
            return objectMapper.readValue(PURCHASE_FILE, new TypeReference<>() {
            });
        } catch (IOException e) {
            //e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public boolean save(List<PurchaseDTO> list) {
        try {
            objectMapper.writeValue(PURCHASE_FILE, list);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
