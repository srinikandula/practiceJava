package com.kalyani.collections;


import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.*;

public class TellerMapImplTest {
    public TellerMapImplTest(){

    }
    @Test
    public void testCreate() throws Exception {
        Teller teller = new TellerImpl();
        teller.createAccount(101, "Srini", 3000);
        double balance = teller.getBalance(101);
        assertEquals(3000, balance, 0.0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetBalanceError() throws Exception {
        Teller teller = new TellerMapImpl();
        teller.createAccount(101, "Srini", 3000);
        double balance = teller.getBalance(102);
    }
    @Test
    public void testDeposit() throws Exception {
        Teller teller = new TellerImpl();
        teller.createAccount(101, "Srini", 3000);
        teller.cashDeposit(101, 3000);
        double balance = teller.getBalance(101);
        assertEquals(6000, balance, 0.0);
    }

    @Test
    public void testAccountExists() throws Exception {
        TellerMapImpl teller = new TellerMapImpl();
        teller.createAccount(101, "Srini", 3000);
        assertTrue(teller.accountExists(101));
        assertFalse(teller.accountExists(102));

    }
}