package com.example.baseball;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller // このClassがユーザからのアクセスを受け取ることができる
public class HelloWorld {
    @GetMapping("/") // httpメソッドがGETでURLが/のアクセスがあるとこのメソッドが呼ばれるようになる(Route)
    public String hello() {
        return "こんにちは"; // templates/配下のhello.htmlをユーザに返す
    }
}