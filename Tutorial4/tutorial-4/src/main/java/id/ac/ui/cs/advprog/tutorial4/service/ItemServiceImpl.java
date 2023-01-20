package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.core.item.MembershipItem;
import id.ac.ui.cs.advprog.tutorial4.core.item.MerchItem;
import id.ac.ui.cs.advprog.tutorial4.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;

// DO NOT TOUCH
@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public Item getItem(String name, ItemType itemType) {
        return itemRepository.findByNameAndType(name, itemType);
    }

    @Override
    public Collection<MerchItem> getAllMerchItem() {
        return itemRepository.findAllMerch();
    }

    @Override
    public Collection<MembershipItem> getAllMembershipItem() {
        return itemRepository.findAllMembership();
    }

    @PostConstruct
    public void init()
    {
        itemRepository.save(new MerchItem("Figurine"));
        itemRepository.save(new MerchItem("Mouse Pad"));
        itemRepository.save(new MerchItem("Plushie"));

        itemRepository.save(new MembershipItem("Iron Membership"));
        itemRepository.save(new MembershipItem("Gold Membership"));
        itemRepository.save(new MembershipItem("Diamond Membership"));
    }}
