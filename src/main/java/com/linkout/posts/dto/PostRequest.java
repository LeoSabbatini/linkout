package com.linkout.posts.dto;

import com.linkout.user.model.User;

public record PostRequest (
    Long authorId,
    String content,
    String imageUrl

){
}
