package com.linkout.posts.mapper;

import com.linkout.posts.dto.PostResponse;
import com.linkout.posts.model.Post;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {
    List<PostResponse> toResponseList(List<Post> posts);

    @Mapping(source = "author.id", target = "authorId")
    @Mapping(source = "author.username", target = "authorUsername")
    PostResponse toResponse(Post post);


}
