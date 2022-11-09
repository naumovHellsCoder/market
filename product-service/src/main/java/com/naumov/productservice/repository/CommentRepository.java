package com.naumov.productservice.repository;

import com.naumov.productservice.model.Comment;
import com.naumov.productservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository
extends JpaRepository<Comment, Integer> {

    @Query()
    List<Comment> getCommentByProduct(Product product);
}
