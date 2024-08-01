package egovframework.example.restapi.client.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Builder @NoArgsConstructor @AllArgsConstructor
@Setter
public class UpdateArticleRequest {
    private String title;
    private String content;
}