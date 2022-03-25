package br.com.group9.springapplicationgroup9.Repository;


import br.com.group9.springapplicationgroup9.Dto.PurchaseDTO;

import br.com.group9.springapplicationgroup9.Repository.Interfaces.IPurchaseRepository;
import br.com.group9.springapplicationgroup9.Util.PurchaseHandler;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Repository
public class PurchaseRepository implements IPurchaseRepository<PurchaseDTO> {

    @Autowired
    private PurchaseHandler jsonFile;

    @Override
    public void add(PurchaseDTO newPurchase) {
        List<PurchaseDTO> purchases = jsonFile.read();
        purchases.add(newPurchase);
        jsonFile.save(purchases);
    }


    @Override
    public List<PurchaseDTO> getAll() {
        return jsonFile.read();
    }

}
