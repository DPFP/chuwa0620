package org.example.optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;


/**
 * @author b1go
 * @date 4/12/23 12:46 AM
 */
public class OptionalTest {

    @Test
    public void testOf() {
        String value = "Hello, Optional!";
        Optional<String> optional = Optional.of(value);
        assertTrue(optional.isPresent());
        assertEquals(value, optional.get());
    }

    @Test
    public void testOfNullable() {
        String value = null;
        Optional<String> optional = Optional.ofNullable(value);
        assertFalse(optional.isPresent());
    }

    @Test
    public void testEmpty() {
        Optional<String> optional = Optional.empty();
        System.out.println(optional.isPresent());
    }

    @Test
    public void testIfPresent() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        optional.ifPresent(value -> assertEquals("Hello, Optional!", value));
    }

    @Test
    public void testOrElse() {
        Optional<String> optional = Optional.empty();
        String result = optional.orElse("Default value");
        assertEquals("Default value", result);
    }

    @Test
    public void testOrElseGet() {
        Optional<String> optional = Optional.empty();
        String result = optional.orElseGet(() -> "Default value");
        assertEquals("Default value", result);
    }

    @Test
    public void testOrElseThrow() {
        Optional<String> optional = Optional.empty();
        //optional.orElseThrow(()->new RuntimeException("Wow Exception"));
        assertThrows(NoSuchElementException.class, optional::orElseThrow);
    }

    @Test
    public void testFilter() {
        Optional<Integer> optional = Optional.of(42);
        Optional<Integer> filtered = optional.filter(value -> value % 2 == 0);
        assertTrue(filtered.isPresent());
        assertEquals(42, filtered.get().intValue());

        filtered = optional.filter(value -> value % 2 != 0);
        assertFalse(filtered.isPresent());
    }

    @Test
    public void testMap() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        Optional<Integer> mapped = optional.map(String::length);
        assertTrue(mapped.isPresent());
        assertEquals(16, mapped.get().intValue());
    }

    @Test
    public void testFlatMap() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        Optional<Integer> flatMapped = optional.flatMap(value -> Optional.of(value.length()));
        assertTrue(flatMapped.isPresent());
        assertEquals(16, flatMapped.get().intValue());
    }
}
