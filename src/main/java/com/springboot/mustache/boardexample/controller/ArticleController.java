package com.springboot.mustache.boardexample.controller;

import com.springboot.mustache.boardexample.domain.Article;
import com.springboot.mustache.boardexample.domain.dto.ArticleDto;
import com.springboot.mustache.boardexample.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/sample-board")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


    @GetMapping("")
    public String firstDisplay(){
        return "redirect:/sample-board/list";
    }
    // redirect를 이용해서 게시판이 첫 화면에서 보이게 함

    @GetMapping("/list")
    public String list(Model model){
        List<Article> articleList = articleRepository.findAll();
        model.addAttribute("article", articleList);
        // Model에 담긴 내용을 view 페이지에서 변수(ex. {{article}})의 형태로 조회할 수 있음
        // 내용을 조회해야하는 페이지에는 Model을 파라미터로 넣기
        // model.addAttribute를 해주지 않으면 model에 결과가 들어가지 않아 결과를 view로 보여줄 수 없음
        // attributeName이 view 페이지에서 변수로 작용함


        return "list";
    }

    @GetMapping("/write")
    public String write(){
        return "write";
    }

    @GetMapping("/list/{id}")
    public String findById(@PathVariable Long id, Model model){
        Optional<Article> findedContent = articleRepository.findById(id);
        if (!findedContent.isEmpty()) {
            model.addAttribute("article", findedContent.get());
            return "show";
        } else {
            return "error";
        }
    }

    @GetMapping("/list/{id}/delete")
    public String deleteById(@PathVariable Long id, ArticleDto articleDto){

        articleRepository.deleteById(id);

        return "redirect:/sample-board/list";
    }

    @GetMapping("/list/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        Optional<Article> articleOptional = articleRepository.findById(id);

        if (!articleOptional.isEmpty()) {
            model.addAttribute("article", articleOptional.get());
            // addAttribute를 해주지 않으면 결과를 view로 보여줄 수 없음
            return "edit";
        } else {
            model.addAttribute("message", String.format("%d 가 없습니다.", id));
            return "error";
        }
    }

    // GetMapping은 어떤 정보를 가져오거나 정보를 입력하는 화면을 보여줌
    // 글을 작성하거나 수정할 때 정보를 저장하는 기능은 PostMapping으로 구현하지만
    // GetMapping을 통해서 작성전, 작성 후의 페이지를 꼭 구현해주어야 한다.


    @PostMapping("/write")
    public String writeContent(ArticleDto articleDto){
        // id가 null이 나옴 -> database에 저장할때 DB 자체에서 id를 할당해줌 -> 입력받는 상황에서는 getId()로 넘어오는 값이 없으므로
        log.info("id: {}, title: {}, content: {}", String.valueOf(articleDto.getId()), articleDto.getTitle(), articleDto.getContent());
        Article savedArticle = articleDto.toEntity();
        articleRepository.save(savedArticle);
        return "list";
    }

    @PostMapping("/list/{id}/update")
    public String editContent(@PathVariable Long id, ArticleDto articleDto, Model model){
        Article article = articleRepository.save(articleDto.toEntity(id));
        // id를 넣어서 primarykey를 고정함
        model.addAttribute("article", article);
        return "redirect:/sample-board/list";
    }


}
