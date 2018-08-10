package com.example.baseball.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;



@Entity // DBのテーブルと紐づく
public class Player {
    @Id // @Idを付けた変数がテーブルのプライマーキーになる
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 連番が自動で振られるようになる

    private Long id;
    @NotEmpty // ①
    private String name;
    @NotNull // ②
    @Min(value = 0) // ③
    @Max(value = 150)
    private Integer age;
    @Size(max = 20) // 文字数の制限
    private String team;
    private String position;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Player [id=" + id + ", name=" + name + ", age=" + age + ", team=" + team + ", position=" + position + "]";
    }
}
