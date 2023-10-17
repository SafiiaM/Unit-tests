package seminars.first.Shop;

import java.util.Comparator;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                if (o1.getCost() > o2.getCost())
                    return 1;
                else if (o1.getCost() < o2.getCost()) {
                    return -1;
                } else return 0;
            }
        });
        return products;
    }
    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        return products.get(products.size() - 1);
    }

    public void print() {
        for (Product product: getProducts()) {
            System.out.println(product.getTitle() + " = €" + product.getCost());
        }
    }
}