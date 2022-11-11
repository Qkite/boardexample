package com.springboot.mustache.boardexample.repository;

import com.springboot.mustache.boardexample.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository의 기능을 받아와서 씀

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
