package com.learn.account;

import com.learn.account.Account;
import com.learn.account.Address;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation() {
//        given
        Account newAccount = new Account();
//        then
        assertFalse(newAccount.isActive(), "Check");
        //hamcrest
        assertThat(newAccount.isActive(), equalTo(false));
        assertThat(newAccount.isActive(), is(false));
        //assertj
        assertThat(newAccount.isActive()).isFalse();
    }

    @Test
    void accountShouldBeActiveAfterActivation() {
//        given
        Account newAccount = new Account();
        assertFalse(newAccount.isActive(), "Check");
//        when
        newAccount.activate();
//        then
        assertTrue(newAccount.isActive());
        //hamcrest
        assertThat(newAccount.isActive(), equalTo(true));
        //assertj
        assertThat(newAccount.isActive()).isTrue();

    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
        //given
        Account account = new Account();

        //when
        Address address = account.getDefaultDeliveryAddress();
        //then
        assertNull(address);
        //hamcrest
        assertThat(address, nullValue());
        //assertj
        assertThat(address).isNull();

    }
    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet(){
        //given
        Address address = new Address("Krakowska", "67c");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);

        //when
        Address defaultAddress = account.getDefaultDeliveryAddress();

        //then
        assertNotNull(defaultAddress);
        assertNotNull(defaultAddress);
        //hamcrest
        assertThat(defaultAddress, is(notNullValue()));
        //assertj
        assertThat(address).isNotNull();
    }
    @RepeatedTest(3)
    void newAccountWithNotNullAddressShouldBeActive() {
        //given
        Address address = new Address("Puławska", "46/6");
        //when
        Account account = new Account(address);

        //then
        assumingThat(address != null, () -> {
            assertTrue(account.isActive());
        });
    }
    @Test
    void invalidEmailShouldThrowException() {
        //given
        Account account = new Account();
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> account.setEmail("wrongEmail"));
    }
    @Test
    void validEmailShouldBeSet() {
        //given
        Account account = new Account();
        //when
        account.setEmail("kontakt@wp.pl");
        //then
        assertThat(account.getEmail(), is("kontakt@wp.pl"));
    }
}

