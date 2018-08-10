package com.example.baseball.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.baseball.domain.Player;
//テーブルへアクセスするための基本的な処理はJPAがが用意してくれているのでSQLを書かなくてよい
//JPAのJpaRepositoryを継承したinterfaceを作成することで利用できる
@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

}