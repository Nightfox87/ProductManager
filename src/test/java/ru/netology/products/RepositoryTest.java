package ru.netology.products;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Product book1 = new Book(123, "Основание", 450, "Айзек Азимов");
    Product phone1 = new Smartphone(322, "Samsung Galaxy S22", 70_000, "Samsung");
    Product book2 = new Book(154, "Основание и Земля", 480, "Айзек Азимов");
    Product phone2 = new Smartphone(367, "iPhone 13", 80_000, "Apple");
    Product book3 = new Book(176, "Маленькие тролли и большое наводнение", 350, "Туве Янссон");

    @Test
    void shouldSave() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(phone1);
        repo.save(book2);
        repo.save(phone2);
        repo.save(book3);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, phone1, book2, phone2, book3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveById() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(phone1);
        repo.save(book2);
        repo.save(phone2);
        repo.save(book3);

        int idToRemove = 367;
        repo.removeById(idToRemove);

        Product[] actual = repo.findAll();
        Product[] expected = {book1, phone1, book2, book3};

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldThrowException() {
        ProductRepository repo = new ProductRepository();
        repo.save(book1);
        repo.save(phone1);
        repo.save(book2);
        repo.save(phone2);
        repo.save(book3);

        assertThrows(NotFoundException.class, () -> {
            repo.removeById(100);
        });
    }
}
