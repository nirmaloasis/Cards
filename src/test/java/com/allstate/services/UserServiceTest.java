package com.allstate.services;

import com.allstate.entities.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
    @Test
    public void shouldCreateUserWithBalanceAndName() throws Exception{
        User u = this.userService.create("sameer", 50000);
        assertEquals(3, u.getId());
        assertEquals(50000, u.getBalance(),.01);
        assertEquals("sameer", u.getUserName());
    }

    @Test
    public void shouldReturnAllUsers() throws Exception{
        ArrayList<User> list = (ArrayList<User>) this.userService.findAll();
        assertEquals("pankaj", list.get(0).getUserName());
        assertEquals(1, list.get(0).getId());
    }

    @Test
    public void shouldReturnUserById() throws Exception{
        User u = this.userService.findById(1);
        assertEquals("pankaj", u.getUserName());
        assertEquals(1, u.getId());
    }
}