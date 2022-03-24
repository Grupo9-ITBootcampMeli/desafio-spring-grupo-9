package br.com.group9.springapplicationgroup9.Repository;


import br.com.group9.springapplicationgroup9.Entity.Purchase;
import br.com.group9.springapplicationgroup9.Repository.Interfaces.IRepository;
import br.com.group9.springapplicationgroup9.Util.PurchaseHandler;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Repository
public class PurchaseRepository implements IRepository<Purchase, Long> {

    @Autowired
    private PurchaseHandler jsonFile;

    @Override
    public void add(Purchase newPurchase) {
        // TODO: Validar regra de negócio sobre ID único
        List<Purchase> purchases = jsonFile.read();
        purchases.add(newPurchase);
        jsonFile.save(purchases);
    }

    @Override
    public void addAll(List<Purchase> newPurchases) {
        List<Purchase> purchases = jsonFile.read();
        purchases.addAll(newPurchases);
        jsonFile.save(purchases);
    }

    @Override
    public Purchase get(Long id) {
        return jsonFile.read().stream().filter(p -> p.getPurchaseId() == id).findFirst().orElse(null);
    }

    @Override
    public List<Purchase> getAll() {
        return jsonFile.read();
    }

}
