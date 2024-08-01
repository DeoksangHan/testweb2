package egovframework.example.restapi.client.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import egovframework.example.restapi.client.dto.ArticleListViewResponse;
import egovframework.example.restapi.client.dto.ArticleResponse;
import egovframework.example.restapi.client.dto.ArticleViewResponse;
import egovframework.example.restapi.client.dto.UpdateArticleRequest;
import egovframework.example.restapi.client.openfeign.BlogFeignClient;
import egovframework.example.sample.service.SampleVO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Controller
@RequiredArgsConstructor
public class ArticleViewController {
	
    private final BlogFeignClient blogFeignClient;  
    		
	@GetMapping("/articles")
	public String viewBookList(Model model) {
       
		/*
		ResponseEntity<List<Article>> responseEntity = restTemplate.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Article>>() {}
        );
		*/

		List<ArticleListViewResponse> articles = blogFeignClient.getArticleList();
        model.addAttribute("articles", articles);		

        return "article/articleList";
	}
	
    @GetMapping("/articles/{id}")
    public String getArticle(@PathVariable Long id, Model model) {
		ArticleViewResponse article = blogFeignClient.getArticleById(id);
        model.addAttribute("article", article);		

        return "article/article";
    }
    
    @PutMapping("/articles/{id}")
    public ResponseEntity<ArticleViewResponse> updateArticle(@PathVariable long id,
                                                 @RequestBody UpdateArticleRequest request) {
    	ArticleViewResponse updatedArticle = blogFeignClient.updateArticle(id, request);

        return ResponseEntity.ok()
                .body(updatedArticle);
    }

    @GetMapping("/new-article")
    // id 키를 가진 쿼리 파라미터의 값을 id 변수에 매핑 ( id는 없을 수도 있음 )
    public String newArticle(@RequestParam(required = false) Long id, Model model) {
        if (id == null) {  // ID가 없으면 생성 
            model.addAttribute("article", new ArticleViewResponse());
        } else {  // id가 있으면 수정
    		ArticleViewResponse article = blogFeignClient.getArticleById(id);
            model.addAttribute("article", article);
        }

        return "article/newArticle";
    }
    
 	@PostMapping("/new-article")
 	public ResponseEntity<ArticleViewResponse> addArticle(@RequestBody UpdateArticleRequest request) {
 		ArticleViewResponse savedArticle = blogFeignClient.addArticle(request);
 				
 	    return ResponseEntity.status(HttpStatus.CREATED)
		       .body(savedArticle); 				
	
 	}
    
    @DeleteMapping("/articles/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable long id) {
 		
    	blogFeignClient.deleteArticle(id);

        return ResponseEntity.ok()
                .build();
    }
 	
    
 	
    
	

	
	
	

}
