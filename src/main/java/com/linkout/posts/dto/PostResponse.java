package com.linkout.posts.dto;

import com.linkout.user.model.User;

import java.time.LocalDateTime;

public record PostResponse(
        Long id,
        Long authorId,
        String authorUsername,
        String content,
        String imageUrl,
        LocalDateTime createdAt,
        LocalDateTime updateAt

) {
}
