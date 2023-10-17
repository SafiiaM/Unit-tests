/*
1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов (правильное количество продуктов, верное содержимое корзины).
2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
*/

package seminars.first.HW;

import seminars.first.Shop.Product;
import seminars.first.Shop.Shop;
import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShopTest {

    public static void main(String[] args) {
        Shop shop = new Shop();
        List<Product> products = new ArrayList<>();
        products.add(new Product(1000, "Дверь"));
        products.add(new Product(500, "Окно"));
        products.add(new Product(2000, "Лестница"));
        shop.setProducts(products);

        shop.print();
        System.out.println();
        shop.sortProductsByPrice();
        shop.print();
        System.out.println();
        System.out.println("Самый дорогой товар - " + shop.getMostExpensiveProduct().getTitle()
                + " = €" + shop.getMostExpensiveProduct().getCost());

        test(shop, products);

    }

    public static void test(Shop shop, List<Product> products) {
        assertThat(shop.getProducts()).hasSize(3);
        for (Product prod: shop.getProducts()) {
            assertThat(prod.getClass()).isEqualTo(Product.class);
            assertThat(prod.getCost()).isPositive();
            assertThat(Arrays.asList("Дверь", "Окно", "Лестница")).contains(prod.getTitle());
        }
        assertThat(shop.getMostExpensiveProduct().getCost()).isEqualTo(2000);
        assertThat(shop.getMostExpensiveProduct().getTitle()).isEqualTo("Лестница");
        assertThat(shop.getProducts().get(0).getCost() <= products.get(0).getCost())
                .isTrue();
        assertThat(shop.getProducts().get(shop.getProducts().size() - 1).getCost()
                >= products.get(products.size() - 1).getCost()).isTrue();
    }
}
