package com.john.DeliveryApplication.Item;

import com.john.DeliveryApplication.Factory.DTO_Factory;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/item")
public class ItemController {
    private final ItemService itemService;
    private final DTO_Factory dto_factory;

    @PostMapping(path = "/add")
    public ItemDTO addItem(@RequestBody ItemDTO item)
    {
        return dto_factory.create(itemService.createItem(item));
    }

    @GetMapping(path = "/all")
    public List<ItemDTO> getItemList()
    {
        return itemService
                .getItemList()
                .stream()
                .map(e -> dto_factory.create(e))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @GetMapping(path = "/{id}")
    public ItemDTO getItem(@PathVariable(name = "id") int id)
    {
        return dto_factory.create(itemService.getItem(id));
    }

    @DeleteMapping(path = "/{id}")
    public boolean deleteItem(@PathVariable(name = "id") int id)
    {
        return itemService.deleteItem(id);
    }

    @PostMapping(path = "/{id}/update/price")
    public ItemDTO updateItemPrice(
            @PathVariable(name = "id") int id,
            @RequestBody String price)
    {
        return dto_factory.create(
                itemService.updateItemPrice(id,price));
    }


}
