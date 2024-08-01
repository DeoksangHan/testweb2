package egovframework.example.restapi.client.openfeign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import egovframework.example.restapi.client.dto.ArticleListViewResponse;
import egovframework.example.restapi.client.dto.ArticleResponse;
import egovframework.example.restapi.client.dto.ArticleViewResponse;
import egovframework.example.restapi.client.dto.UpdateArticleRequest;

//HDS-feign
// value : 중요하지 않으나 필수값이라 임의의 값을 넣어도 된다...
//@FeignClient(value = "api-service", url = "http://172.17.120.48:30164")
@FeignClient(value = "api-service", url = "${openfeign.api_call_base_url}")

public interface BlogFeignClient {

	// JPA API call...............
	
// 	@GetMapping("/api/articles") List<ArticleListViewResponse> getArticleList();
//	
//	@GetMapping("/api/articles/{id}") ArticleViewResponse
//	getArticleById(@PathVariable Long id);
//	
//	
//	@PostMapping("/api/articles") public ArticleViewResponse
//	addArticle(@RequestBody UpdateArticleRequest request);
//	
//	@PutMapping("/api/articles/{id}") public ArticleViewResponse
//	updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest
//	request);
//	
//	@DeleteMapping("/api/articles/{id}") public ResponseEntity<Void>
//	deleteArticle(@PathVariable long id);
	
	
	
	// Mybatis API call............

	
	@GetMapping("/api/mybatis/articles") List<ArticleListViewResponse>
	getArticleList();
	
	@GetMapping("/api/mybatis/articles/{id}") ArticleViewResponse
	getArticleById(@PathVariable Long id);
	
	@PostMapping("/api/mybatis/articles") public ArticleViewResponse
	addArticle(@RequestBody UpdateArticleRequest request);
	
	@PutMapping("/api/mybatis/articles/{id}") public ArticleViewResponse
	updateArticle(@PathVariable long id, @RequestBody UpdateArticleRequest
	request);
	
	@DeleteMapping("/api/mybatis/articles/{id}") public ResponseEntity<Void>
	deleteArticle(@PathVariable long id);
	
}
