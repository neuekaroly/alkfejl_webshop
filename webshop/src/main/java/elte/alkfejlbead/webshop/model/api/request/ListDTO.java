package elte.alkfejlbead.webshop.model.api.request;

import lombok.Data;

import java.util.List;

@Data
public class ListDTO<T> {
    private List<T> items;
}
