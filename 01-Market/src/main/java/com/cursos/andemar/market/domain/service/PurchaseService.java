package com.cursos.andemar.market.domain.service;

import com.cursos.andemar.market.domain.Purchase;
import com.cursos.andemar.market.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll() {
        return purchaseRepository.getALl();
    }

    public Optional<List<Purchase>> getByClient(String cliendId) {
        return purchaseRepository.getByClient(cliendId);
    }

    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}
