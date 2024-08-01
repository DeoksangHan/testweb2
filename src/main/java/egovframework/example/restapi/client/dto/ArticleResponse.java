package egovframework.example.restapi.client.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.Builder;

// dto 는 그냥 무조건 이렇게 써야 문제 안생긴다.
@Getter @Builder @NoArgsConstructor @AllArgsConstructor
//@ModelAttribute 사용이 필요하다면
//@Setter

public class ArticleResponse {

	private String title;
	private String content;

}
