package com.springboot.mustache.boardexample.domain.dto;

import com.springboot.mustache.boardexample.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ArticleDto {

    private Long id;
    private String title;
    private String content;

    public ArticleDto(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public Article toEntity(){
        return new Article(title, content);
    }

    public Article toEntity(Long id){
        return new Article(id, title, content);
    }
}
