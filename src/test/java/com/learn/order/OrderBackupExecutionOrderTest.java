package com.learn.order;

import com.learn.order.Order;
import com.learn.order.OrderBackup;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OrderBackupExecutionOrderTest {
    @Test
    void callingBackupWithoutCreatingAFileShouldThrowException() throws IOException {
        //given
        OrderBackup orderBackup = new OrderBackup();

        //then
        assertThrows(IOException.class, () -> orderBackup.backupOrder(new Order()));
    }
}
