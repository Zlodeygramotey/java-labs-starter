package edu.course.lab04;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    @Test
    void equalByIsbnFindsValueByOtherInstance() {
        Book b1 = new Book("978-1", "Clean Code");
        Book b2 = new Book("978-1", "Другое название");
        Map<Book, String> map = new HashMap<>();
        map.put(b1, "found");
        assertEquals("found", map.get(b2));
    }

    @Test
    void differentIsbnNotEqual() {
        Book b1 = new Book("978-1", "Title");
        Book b2 = new Book("978-2", "Title");
        assertNotEquals(b1, b2);
    }
}
