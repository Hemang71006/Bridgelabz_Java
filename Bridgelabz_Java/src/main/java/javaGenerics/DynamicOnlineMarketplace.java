
package javaGenerics;

abstract class ProductCategory {
    public abstract String getName();
}

class BookCategory extends ProductCategory {
    public String getName() {
        return "Books";
    }
}

class ClothingCategory extends ProductCategory {
    public String getName() {
        return "Clothing";
    }
}

class GadgetCategory extends ProductCategory {
    public String getName() {
        return "Gadgets";
    }
}

class Product<T extends ProductCategory> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public T getCategory() {
        return category;
    }
}

class Marketplace {
    public <T extends ProductCategory> void applyDiscount(
            Product<T> product, double percentage) {
        double newPrice = product.getPrice()
                - (product.getPrice() * percentage / 100);
        product.setPrice(newPrice);

        System.out.println(product.getName()
                + " (" + product.getCategory().getName()
                + ") price after discount: Rs." + newPrice);
    }
}

public class DynamicOnlineMarketplace {
    public static void main(String[] args) {
        Product<BookCategory> book =
                new Product<>("Java Book", 500, new BookCategory());

        Product<ClothingCategory> shirt =
                new Product<>("Shirt", 1000, new ClothingCategory());

        Product<GadgetCategory> phone =
                new Product<>("Headphones", 2000, new GadgetCategory());

        Marketplace marketplace = new Marketplace();

        marketplace.applyDiscount(book, 10);
        marketplace.applyDiscount(shirt, 20);
        marketplace.applyDiscount(phone, 15);
    }
}

