package io.shs0160.springapi.entity;

import io.shs0160.springapi.dto.SaveRequest;
import io.shs0160.springapi.dto.UpdateRequest;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Post {

    private Long id;

    private String title;
    private String content;
    private String author;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = LocalDateTime.now();

    public static Post of(SaveRequest Request) {
        Post post = new Post();
        post.title = Request.getTitle();
        post.content = Request.getContent();
        post.author = Request.getAuthor();
        return post;
    }

    public void update(UpdateRequest request) {
        this.title = request.getTitle();
        this.content = request.getContent();

        this.updatedAt = LocalDateTime.now();
    }

}
