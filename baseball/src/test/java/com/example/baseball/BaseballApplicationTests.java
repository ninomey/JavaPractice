package com.example.baseball;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;




@RunWith(SpringRunner.class)//Spring BootでJUnitテストするときはコレをつける
@SpringBootTest//SpringのJava/XML Based Configurationなどの設定を読み込んでくれる

public class BaseballApplicationTests {

    @Autowired
    HelloWorld helloWorld;//インスタンスを作成



    @Test
    public void testHelloWorld() throws Exception {
        assertEquals("こんにちは", helloWorld.hello());
        //等しいか判断(expected:期待される値、インスタス名.メソッド名)
    }

}
