package com.chryl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ChrylSystemApplicationTests {

    @Test
    public void contextLoads() {
    }


    public void show() {
        System.out.println();
    }
    public static void main(String args[]) {
        System.out.println(
                "3"
        );
        System.out.println("1");
        System.out.println("2");
    }
}
