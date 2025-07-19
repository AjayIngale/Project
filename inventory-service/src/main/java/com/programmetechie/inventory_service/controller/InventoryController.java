package com.programmetechie.inventory_service.controller;

import com.programmetechie.inventory_service.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    private InventoryService inventoryService;
@GetMapping("/{sku-code}")
@ResponseStatus(HttpStatus.OK)
public boolean isStock(@PathVariable("sku-code") String skucode) {
    return  inventoryService.isInStock(skucode);
}
}
