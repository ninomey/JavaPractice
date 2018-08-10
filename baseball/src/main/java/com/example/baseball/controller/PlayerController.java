package com.example.baseball.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

import org.springframework.validation.*;



import com.example.baseball.domain.Player;
import com.example.baseball.service.PlayerService;


@Controller
@RequestMapping("/players") // @RequestMappingはクラス内のメソッド全てに適用される
//つまりこのクラスのメソッドは全て、http://localhost:8080/playersから始まるURLにマッピングされている
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    @GetMapping
    public String index(Model model) { // Modelのインスタンスが自動的に渡される
        List<Player> players = playerService.findAll();
        model.addAttribute("players", players); // テンプレートに値を渡すことができる
        return "players/index"; // templates/配下からファイルを見つけてユーザに返している
    }

    @GetMapping("new")
    public String newPlayer(Model model) {
        // 新規作成画面に対してPlayerインスタンスを渡すようにする
        Player player = new Player();
        model.addAttribute("player", player);
        return "players/new";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model) {
        //引数に@PathVariableを設定するとURL上の値をidに取得することができる
        Player player = playerService.findOne(id);
        model.addAttribute("player", player);
        return "players/edit";
    }

    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Player player = playerService.findOne(id);
        model.addAttribute("player", player);
        return "players/show";
    }

    @PostMapping
    public String create(@Valid @ModelAttribute Player player, BindingResult bindingResult) { // ②
        //引数に@ModelAttributeをつけると送信されたリクエストのbodyの情報を取得できる
        if(bindingResult.hasErrors()) return "players/new"; // ③
        playerService.save(player);
        return "redirect:/players";
        // createメソッドの処理が終わった後にhttp://localhost:8080/playersにリダイレクトされる
    }

    @PutMapping("{id}")
    public String update(@PathVariable Long id, @Valid @ModelAttribute Player player, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) return "players/edit";
        player.setId(id);
        playerService.save(player);
        return "redirect:/players";
    }

    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        playerService.delete(id);
        return "redirect:/players";
    }
}
