package com.kalyani.collections;


import com.srini.LinkedList;
import com.srini.Node;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class TestLinkedList {

    @Before
    public void before(){

    }

    @After
    public void cleanup(){

    }
    @Test
    public void testAdd(){
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());
        list.add(23);
        assertFalse(list.isEmpty());
    }

    @Test
    public void testGet(){
        LinkedList list = new LinkedList();
        list.add(23);
        list.add(26);
        list.add(44);
        list.add(66);
        Node node = list.get(3);
        assertEquals(66, node.getValue());
        node = list.get(6);
        assertEquals(null, node);
        node = list.get(2);
        assertEquals(44, node.getValue());
    }

    @Test
    public void testDelete(){
        LinkedList list = new LinkedList();
        list.add(23);
        list.add(26);
        list.add(44);
        list.add(66);
        list.delete(2);
        Node node = list.get(2);
        assertEquals(66, node.getValue());
    }

}
