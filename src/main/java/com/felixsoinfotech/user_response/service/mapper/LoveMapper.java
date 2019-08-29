package com.felixsoinfotech.user_response.service.mapper;

import com.felixsoinfotech.user_response.domain.*;
import com.felixsoinfotech.user_response.service.dto.LoveDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Love and its DTO LoveDTO.
 */
@Mapper(componentModel = "spring", uses = {CommentMapper.class, ReplyMapper.class})
public interface LoveMapper extends EntityMapper<LoveDTO, Love> {

    @Mapping(source = "comment.id", target = "commentId")
    @Mapping(source = "reply.id", target = "replyId")
    LoveDTO toDto(Love love);

    @Mapping(source = "commentId", target = "comment")
    @Mapping(source = "replyId", target = "reply")
    Love toEntity(LoveDTO loveDTO);

    default Love fromId(Long id) {
        if (id == null) {
            return null;
        }
        Love love = new Love();
        love.setId(id);
        return love;
    }
}
