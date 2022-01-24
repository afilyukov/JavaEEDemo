package ru.veles;

import java.util.ArrayList;
import java.util.List;

class ProductCatalog {
    private final List<Product> products;
    public ProductCatalog() {
        this.products = new ArrayList<>();
    }

    public void add(Product product) {
        if (!isExisting(product)) {
            products.add(product);
        }
    }

    public boolean remove(Product product) {
        return products.remove(product);
    }

    public boolean isExisting(Product product) {
        return products.contains(product);
    }

    public String printAll() {
        String t = "<table border=\"1\">";
        for (Product p : products) {
            t = t.concat(String.format("<tr><td>%s</td><td>%s</td><td>%s</td></tr>", p.getId(), p.getTitle(), p.getCost()));
        }
        t = t.concat("</table>");
        return t;
    }

}
