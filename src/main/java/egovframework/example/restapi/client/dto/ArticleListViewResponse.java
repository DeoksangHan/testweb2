package egovframework.example.restapi.client.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Builder @NoArgsConstructor @AllArgsConstructor
//@ModelAttribute 사용이 필요하다면
@Setter
public class ArticleListViewResponse {
    private Long id;
    private String title;
    private String content;

}
