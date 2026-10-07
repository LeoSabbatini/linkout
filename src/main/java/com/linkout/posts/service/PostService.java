package com.linkout.posts.service;

import com.linkout.posts.dto.PostRequest;
import com.linkout.posts.dto.PostResponse;
import com.linkout.posts.dto.PostUpdateRequest;
import com.linkout.posts.mapper.PostMapper;
import com.linkout.posts.model.Post;
import com.linkout.posts.repository.PostRepository;
import com.linkout.user.dtos.UserResponse;
import com.linkout.user.model.User;
import com.linkout.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostMapper postMapper;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    public PostService(PostMapper postMapper, PostRepository postRepository, UserRepository userRepository) {
        this.postMapper = postMapper;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }


    public List<PostResponse> findAll(){
        return postMapper.toResponseList(postRepository.findAll());
    }

    public PostResponse create(PostRequest request){
        User author = userRepository.findById(request.authorId()).orElseThrow(()-> new RuntimeException("Usuário nao encontrado"));
        Post post = Post.builder()
                .author(author)
                .content(request.content())
                .imageUrl(request.imageUrl())
                .build();
        return postMapper.toResponse(postRepository.save(post));
    }
    public PostResponse update(Long id, PostUpdateRequest request){
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Post não encontrado."));
        post.setContent(request.content());
        return postMapper.toResponse(postRepository.save(post));
    }

    public void delete(Long id){
        Post post = postRepository.findById(id).orElseThrow(()-> new RuntimeException("Post não encontrado."));
        postRepository.delete(post);
    }
}
