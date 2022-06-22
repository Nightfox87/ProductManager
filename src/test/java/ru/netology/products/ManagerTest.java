package ru.netology.products;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTest {

    Product book1 = new Book(123, "Основание", 450, "Айзек Азимов");
    Product phone1 = new Smartphone(322, "Samsung Galaxy S22", 70_000, "Samsung");
    Product book2 = new Book(154, "Основание и Земля", 480, "Айзек Азимов");
    Product phone2 = new Smartphone(367, "iPhone 13", 80_000, "Apple");
    Product book3 = new Book(176, "Маленькие тролли и большое наводнение", 350, "Туве Янссон");


    @Test
    void shouldAddProduct() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(phone2);
        manager.add(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, phone1, book2, phone2, book3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFind1Product() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(phone2);
        manager.add(book3);

        Product[] actual = manager.searchBy("sun");
        Product[] expected = {phone1};

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFind2Products() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(phone2);
        manager.add(book3);

        Product[] actual = manager.searchBy("снова");
        Product[] expected = {book1, book2};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFind3Products() {
        ProductRepository repo = new ProductRepository();
        ProductManager manager = new ProductManager(repo);

        manager.add(book1);
        manager.add(phone1);
        manager.add(book2);
        manager.add(phone2);
        manager.add(book3);

        Product[] actual = manager.searchBy("ние");
        Product[] expected = {book1, book2, book3};

        assertArrayEquals(expected, actual);
    }
}
