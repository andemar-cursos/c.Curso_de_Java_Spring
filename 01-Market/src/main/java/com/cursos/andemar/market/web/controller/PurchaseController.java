package com.cursos.andemar.market.web.controller;

import com.cursos.andemar.market.domain.Purchase;
import com.cursos.andemar.market.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;


    @GetMapping()
    public ResponseEntity<List<Purchase>> getAll() {

        return new ResponseEntity<List<Purchase>>(purchaseService.getAll(),HttpStatus.OK);
    }


    @GetMapping("/byClient/{clientId}")
    public ResponseEntity<List<Purchase>> getByClient(@PathVariable("clientId") String clientId) {

        return purchaseService.getByClient(clientId)
                .map(purchases -> new ResponseEntity<List<Purchase>>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @PostMapping()
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<Purchase>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
