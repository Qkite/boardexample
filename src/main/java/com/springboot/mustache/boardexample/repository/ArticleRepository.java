package com.springboot.mustache.boardexample.repository;

import com.springboot.mustache.boardexample.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}
