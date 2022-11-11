package com.springboot.mustache.boardexample.domain;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // IDENTITY를 사용화면 DB 자체에서 autoincreasement를 이용해서 id를 갱신
    // SEQUENCE(default)를 사용하면 hibernate_sequence 테이블 생성
    // 그 테이블의 next_value라는 값을 참조해서 id 갱신
    // 그러면 hibernnate_sequence의 next_value 값을 변경하면 중간에 삭제된 정보 때문에 비는 id를 채울 수 있나?
    private Long id;
    private String title;
    private String content;


    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
