package io.shs0160.springapi.controller;

import io.shs0160.springapi.dto.SaveRequest;
import io.shs0160.springapi.dto.UpdateRequest;
import io.shs0160.springapi.entity.Post;
import io.shs0160.springapi.repository.PostRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
//@Controller
//@ResponseBody
@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostRepository postRepository;

    @GetMapping("/{postId}")
    //@ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Post> findById(@PathVariable Long postId) {
        log.info("Find post by id: {}", postId);
        Post findPost = postRepository.findById(postId);
        return ResponseEntity.status(HttpStatus.OK).body(findPost);
    }


    @PostMapping
    public ResponseEntity<Long> save(@RequestBody SaveRequest request) {
        Post saved = postRepository.save(Post.of(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(saved.getId());
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<Post> update(@PathVariable Long postId, @RequestBody UpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(postRepository.update(postId, request));
    }


    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> delete(@PathVariable Long postId) {
        return ResponseEntity.ok(postRepository.remove(postId));
    }
}
