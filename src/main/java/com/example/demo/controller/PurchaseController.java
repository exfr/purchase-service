package com.example.demo.controller;

import com.example.demo.entity.Purchase;
import com.example.demo.repository.PurchaseRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@Api(tags = {"Controller for Purchase"})
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    @ApiOperation(value = "Get all Purchase for all time", produces = "application/json", consumes = "applications/json",
            response = Purchase.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal error")})
    @GetMapping
    public ResponseEntity<List<Purchase>> getAllPurchase() {
        List<Purchase> purchaseResponse = purchaseRepository.findAll();
        if (purchaseResponse == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(purchaseResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get all Purchase for User", produces = "application/json", consumes = "applications/json",
            response = Purchase.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal error")})
    @GetMapping("/{id}")
    public ResponseEntity<Purchase> getPurchaseByUserId(@PathVariable(name = "id") Long id) {
        Purchase purchaseResponse = purchaseRepository.findByUserId(id);
        if (purchaseResponse == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(purchaseRepository.findByUserId(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Add Purchase", produces = "application/json", consumes = "applications/json",
            response = Purchase.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Internal error")})
    @PostMapping("/add")
    public ResponseEntity<Purchase> addPurchase(@RequestBody Purchase purchase) {
        try {
            purchase.getProducts().forEach(product -> product.setPurchase(purchase));
            purchaseRepository.save(purchase);
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(purchase);
    }
}
