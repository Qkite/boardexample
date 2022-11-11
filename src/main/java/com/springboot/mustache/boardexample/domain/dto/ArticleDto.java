package com.springboot.mustache.boardexample.domain.dto;

import com.springboot.mustache.boardexample.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


/*
@PostMapping에서
@NoArgConstructor와 @AllArgConstructor를 모두 사용하면 @Setter를 설정해주어야 함
둘 다 있으면 NoArgConstructor 호출하고 Setter를 호출해서 초기화함
하지만 Setter가 없으면 필드에 값을 못 넣어줌  null로 반환됨
 */

//@NoArgsConstructor
@AllArgsConstructor
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
    // @pathVariable을 통해서 들어오는 id를 넘겨받아 repository에서 save를 할 때 같은 primarykey(id)를 인식해서
    // insert가 되지 않고 update가 되도록 함
}
