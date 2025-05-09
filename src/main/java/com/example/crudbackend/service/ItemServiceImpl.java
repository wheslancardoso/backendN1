package com.example.crudbackend.service;

import com.example.crudbackend.exception.ResourceNotFoundException;
import com.example.crudbackend.model.Item;
import com.example.crudbackend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Item> getItemById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    @Transactional
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    @Transactional
    public Item updateItem(Long id, Item itemDetails) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));

        item.setName(itemDetails.getName());
        item.setDescription(itemDetails.getDescription());

        return itemRepository.save(item);
    }

    @Override
    @Transactional
    public void deleteItem(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Item not found with id: " + id));
        itemRepository.delete(item);
    }
}