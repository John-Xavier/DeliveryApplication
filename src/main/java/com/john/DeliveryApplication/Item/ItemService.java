package com.john.DeliveryApplication.Item;

import com.john.DeliveryApplication.entity.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public Item createItem(ItemDTO item)
    {

            Item i = new Item(item.getId(),
                    item.getItemName(),
                    item.getPrice());

            return itemRepository.save(i);

    }
    public List<Item> getItemList()
    {
        return itemRepository.findAll();
    }
    public Item getItem(int id)
    {
        return itemRepository.findById(id).orElse(null);
    }

    public boolean deleteItem(int id)
    {
        if (itemRepository.existsById(id))
        {
            try
            {
                itemRepository.deleteById(id);
                return true;
            }
            catch (Exception e)
            {
                e.printStackTrace(System.err);
                return false;
            }
        }
        return false;
    }
    public Item updateItemPrice(int itemId, String price)
    {
        Optional<Item> optionalItem = itemRepository.findById(itemId);

        if (!optionalItem.isPresent())
        {
            return null;
        }

        String newPrice = price;

        Item itemEntity = optionalItem.get();
        itemEntity.setPrice(newPrice);
        return itemRepository.save(itemEntity);
    }
}


