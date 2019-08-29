package com.felixsoinfotech.user_response.service.mapper;

import com.felixsoinfotech.user_response.domain.*;
import com.felixsoinfotech.user_response.service.dto.CommentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Comment and its DTO CommentDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CommentMapper extends EntityMapper<CommentDTO, Comment> {


    @Mapping(target = "replies", ignore = true)
    @Mapping(target = "loves", ignore = true)
    Comment toEntity(CommentDTO commentDTO);

    default Comment fromId(Long id) {
        if (id == null) {
            return null;
        }
        Comment comment = new Comment();
        comment.setId(id);
        return comment;
    }
}
