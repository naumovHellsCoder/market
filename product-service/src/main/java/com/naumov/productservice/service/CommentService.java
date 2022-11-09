package com.naumov.productservice.service;

import com.naumov.productservice.dto.CommentDto;
import com.naumov.productservice.model.Comment;
import com.naumov.productservice.model.Product;
import com.naumov.productservice.repository.CommentRepository;
import com.naumov.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {
    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;
    public ResponseEntity<?> createComment(CommentDto commentDto, Integer productId){
        Product product = productRepository.findProductById(productId)
                .orElseThrow(()->new RuntimeException("product not found"));
        Comment comment = new Comment();
        comment.setProduct(product);
        comment.setText(commentDto.getText());
        commentRepository.save(comment);
        return ResponseEntity.ok().body(comment);
    }
    public ResponseEntity<List<Comment>> getCommentByProduct(Integer productId){
        Product product  = productRepository.findProductById(productId)
                .orElseThrow(()->new RuntimeException(""));
        List<Comment> comments= commentRepository.getCommentByProduct(product);
        return ResponseEntity.ok().body(comments);
    }
}
