package id.ac.ui.cs.adpro.tutorial3.automata.core.util;

import java.util.List;

public class ItemCount {
    public static int count(List<String> items, String wanted) {
        int count = 0;
        for (String item : items) {
            if (item.equals(wanted)) count++;
        }

        return count;
    }
}
