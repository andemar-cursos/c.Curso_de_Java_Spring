package com.cursos.andemar.market.domain.repository;

import com.cursos.andemar.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase> getALl();

    Optional<List<Purchase>> getByClient(String clientId);

    Purchase save(Purchase purchase);
}
