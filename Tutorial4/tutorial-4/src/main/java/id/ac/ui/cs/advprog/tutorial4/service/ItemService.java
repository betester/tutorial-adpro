package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.core.item.MembershipItem;
import id.ac.ui.cs.advprog.tutorial4.core.item.MerchItem;

import java.util.Collection;

public interface ItemService {
    Item getItem(String name, ItemType itemType);
    Collection<MembershipItem> getAllMembershipItem();
    Collection<MerchItem> getAllMerchItem();
}
