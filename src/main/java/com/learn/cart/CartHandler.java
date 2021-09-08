package com.learn.cart;

public interface CartHandler {

    boolean canHandleCart(Cart cart);
    void sendToPrepare(Cart cart);

}
