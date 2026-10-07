package com.linkout.posts.controller;

import com.linkout.posts.dto.PostRequest;
import com.linkout.posts.dto.PostResponse;
import com.linkout.posts.dto.PostUpdateRequest;
import com.linkout.posts.service.PostService;
import com.linkout.user.dtos.UserRequest;
import com.linkout.user.dtos.UserResponse;
import com.linkout.user.dtos.UserUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@Tag(name = "Posts", description = "CRUD de posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping()
    @Operation(summary = "Cria um novo post")
    public ResponseEntity<PostResponse> create(@Valid @RequestBody PostRequest request){
        return ResponseEntity.status(201).body(postService.create(request));
    }
    @GetMapping
    @Operation(summary = "Listar todos posts")
    public List<PostResponse> findAll(){ return postService.findAll(); }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um post")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        postService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um post")
    public PostResponse update(@PathVariable Long id, @Valid @RequestBody PostUpdateRequest postRequest){
        return postService.update(id,postRequest);
    }
}
