package com.programmetechie.inventory_service.service;

import com.programmetechie.inventory_service.repository.InventoryRepository;
import com.programmetechie.inventory_service.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {
  private InventoryRepository inventoryRepository;
  @Transactional(readOnly=true)
    public  boolean isInStock(String skuCode) {
       return  inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
