package elte.alkfejlbead.webshop.model.api.request;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ListDTO<T> {
    private List<T> items;

    public ListDTO() {
        items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }
}
