package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    /**
     * this adds a city object to the list *for the first phase it will be empty * @param city
     */
    public void addCity(City city){

    }
    private CustomList list; /**
     * create a mocklist for my citylist * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>()); return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }
    @Test
    void testHasCity() {
        list = MockCityList();
        City city = new City("Edmonton", "Alberta");
        list.addCity(city);

        assertTrue(list.hasCity(city));
        assertFalse(list.hasCity(new City("Toronto", "Ontario")));
    }
    @Test
    void testDeleteException() {
        list = MockCityList();
        assertThrows(IllegalArgumentException.class, () -> {
            list.delete(new City("Toronto", "Ontario"));
        });
    }
    @Test
    void testCountCities() {
        list = MockCityList();
        assertEquals(0, list.countCities());

        list.addCity(new City("Edmonton", "Alberta"));
        assertEquals(1, list.countCities());
    }
}
