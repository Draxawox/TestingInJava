package com.learn.order;

import com.learn.Meal;
import com.learn.order.Order;
import com.learn.order.OrderBackup;
import org.junit.jupiter.api.*;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderBackupTest {
    private static OrderBackup orderBackup;

    @BeforeAll
    static void setup() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @BeforeEach
    void appendAtTheStartOfTheLine() {
        try {
            orderBackup.getWriter().append("New order: ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterEach
    void appendAtTheEndOfLine() throws IOException {
        orderBackup.getWriter().append(" backed up.");
    }

    @Tag("fries")
    @Test
    void backupOrderWithOneMeal() throws IOException {
        //given
        Meal meal = new Meal(7, "Fries");
        com.learn.order.Order order = new Order();
        order.addMealToOrder(meal);

        //when
        orderBackup.backupOrder(order);

        //then
        System.out.println("Order: " + order.toString() + " backed up.");
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }
}
