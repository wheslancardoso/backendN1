package com.example.crudbackend.controller;

import com.example.crudbackend.exception.ResourceNotFoundException;
import com.example.crudbackend.model.Item;
import com.example.crudbackend.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // Permite requisições do Angular (porta padrão 4200)
@RestController
@RequestMapping("/api/v1/items") // Define o path base para os endpoints deste controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    // Endpoint para listar todos os itens (GET /api/v1/items)
    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    // Endpoint para buscar um item por ID (GET /api/v1/items/{id})
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "id") Long itemId) {
        Item item = itemService.getItemById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + itemId));
        return ResponseEntity.ok().body(item);
    }

    // Endpoint para criar um novo item (POST /api/v1/items)
    @PostMapping
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
        Item createdItem = itemService.createItem(item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED); // Retorna 201 Created
    }

    // Endpoint para atualizar um item existente (PUT /api/v1/items/{id})
    @PutMapping("/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable(value = "id") Long itemId,
                                           @Valid @RequestBody Item itemDetails) {
        Item updatedItem = itemService.updateItem(itemId, itemDetails);
        return ResponseEntity.ok(updatedItem);
    }

    // Endpoint para deletar um item (DELETE /api/v1/items/{id})
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable(value = "id") Long itemId) {
        // Primeiro, verificamos se o item existe para lançar uma exceção clara se não existir.
        itemService.getItemById(itemId)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + itemId + ". Cannot delete."));
        
        itemService.deleteItem(itemId);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content, indicando sucesso sem corpo na resposta
    }
}