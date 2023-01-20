package id.ac.ui.cs.advprog.tutorial4.repository;


import id.ac.ui.cs.advprog.tutorial4.core.item.Item;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.core.item.MembershipItem;
import id.ac.ui.cs.advprog.tutorial4.core.item.MerchItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemRepositoryTest {

    private ItemRepository itemRepository;

    private Item dummyMembership;

    private Item dummyMerch;

    @BeforeEach
    public void setUp() {
        itemRepository = new ItemRepository();
        dummyMembership = new MembershipItem("dummyMembership");
        dummyMerch = new MerchItem("dummyMerch");
        itemRepository.save(dummyMembership);
        itemRepository.save(dummyMerch);
    }

    @Test
    public void whenSaveNewItemShouldAddToCorrectRepository() throws Exception {
        Item dummyMerch = new MerchItem("dummyMerch2");
        itemRepository.save(dummyMerch);

        Collection<MembershipItem> membershipItems = itemRepository.findAllMembership();
        Collection<MerchItem> merchItems = itemRepository.findAllMerch();

        assertThat(membershipItems).hasSize(1);
        assertThat(merchItems).hasSize(2);
    }

    @Test
    public void whenFindItemByNameAndTypeShouldReturnCorrectObject() throws Exception {
        Item item = itemRepository.findByNameAndType("dummyMembership", ItemType.MEMBERSHIP);
        Item item1 = itemRepository.findByNameAndType("dummyMerch", ItemType.MERCH);

        assertEquals(item.getName(), dummyMembership.getName());
        assertEquals(item1.getName(), dummyMerch.getName());

        assertEquals(item, dummyMembership);
        assertEquals(item1, dummyMerch);
    }

}
