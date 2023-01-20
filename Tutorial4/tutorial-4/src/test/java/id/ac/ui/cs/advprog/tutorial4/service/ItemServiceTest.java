package id.ac.ui.cs.advprog.tutorial4.service;

import id.ac.ui.cs.advprog.tutorial4.repository.*;
import id.ac.ui.cs.advprog.tutorial4.core.item.ItemType;
import id.ac.ui.cs.advprog.tutorial4.core.item.MembershipItem;
import id.ac.ui.cs.advprog.tutorial4.core.item.MerchItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    private ItemServiceImpl itemService;

    @Mock
    private MerchItem mockMerch;

    @Mock
    private MembershipItem mockMembership;

    @BeforeEach
    public void setup() {
        itemService = new ItemServiceImpl(itemRepository);
    }

    @Test
    public void whenGetItemShouldCallFindByNameAndType() throws Exception {

        when(itemRepository.findByNameAndType("Figurine", ItemType.MERCH)).thenReturn(mockMerch);
        itemService.getItem("Figurine", ItemType.MERCH);
        verify(itemRepository, times(1)).findByNameAndType("Figurine", ItemType.MERCH);
    }

    @Test
    public void whenGetAllMembershipItemShouldReturnAllItem() throws Exception {
        Map<String, MembershipItem> membershipItemMap = new HashMap<>();
        membershipItemMap.put("Figurine", mockMembership);
        when(itemRepository.findAllMembership()).thenReturn(membershipItemMap.values());

        Collection<MembershipItem> items = itemService.getAllMembershipItem();

        verify(itemRepository, times(1)).findAllMembership();
        assertEquals(1, items.size());
    }

    @Test
    public void whenGetAllMerchItemShouldReturnAllItem() throws Exception {
        Map<String, MerchItem> merchItemMap = new HashMap<>();
        merchItemMap.put("Figurine", mockMerch);

        when(itemRepository.findAllMerch()).thenReturn(merchItemMap.values());

        Collection<MerchItem> items = itemService.getAllMerchItem();

        verify(itemRepository, times(1)).findAllMerch();
        assertEquals(1, items.size());
    }

}
