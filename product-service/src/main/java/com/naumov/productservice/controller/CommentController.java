package com.naumov.productservice.controller;

import com.naumov.productservice.dto.CommentDto;
import com.naumov.productservice.model.Comment;
import com.naumov.productservice.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/shop/comment")
@AllArgsConstructor
public class CommentController {

    private final CommentService commentService;


    @PostMapping(path = "/create/{productId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)

    public ResponseEntity<?> createComment(
           @RequestBody CommentDto commentDto,
           @PathVariable("productId") Integer productId
    ){
        return commentService.createComment(commentDto, productId);
    }
    @GetMapping(path = "/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Comment>> getCommentByProduct(
            @PathVariable("productId") Integer productId
    ){
        return commentService.getCommentByProduct(productId);
    }
}
