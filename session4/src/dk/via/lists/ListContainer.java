package dk.via.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListContainer {
    private List<Integer> list;

    public ListContainer() {
        list = Collections.synchronizedList(new ArrayList<>());
    }

    public void add(int i) {
        list.add(i);
    }

    public int size() {
        return list.size();
    }
}
