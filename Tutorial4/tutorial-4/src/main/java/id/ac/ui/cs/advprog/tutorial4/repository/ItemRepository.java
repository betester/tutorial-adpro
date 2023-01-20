package id.ac.ui.cs.advprog.tutorial4.repository;

import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.core.item.MembershipItem;
import id.ac.ui.cs.advprog.tutorial4.core.item.MerchItem;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ItemRepository {
    private final Map<String, MerchItem> merchItemMap = new HashMap<>();
    private final Map<String, MembershipItem> membershipItemMap = new HashMap<>();

    public Collection<MerchItem> findAllMerch() {
        return merchItemMap.values();
    }

    public Collection<MembershipItem> findAllMembership() {
        return membershipItemMap.values();
    }

    public Item save(Item item) {
        if (item instanceof MerchItem) {
            merchItemMap.put(item.getName(), (MerchItem) item);
            return item;
        }
        else if (item instanceof MembershipItem) {
            membershipItemMap.put(item.getName(), (MembershipItem) item);
            return item;
        }
        return null;
    }

    public Item findByNameAndType(String name, ItemType itemType) {
        if (itemType.equals(ItemType.MERCH))
            return merchItemMap.get(name);
        else if (itemType.equals(ItemType.MEMBERSHIP))
            return membershipItemMap.get(name);
        return null;
    }


}
