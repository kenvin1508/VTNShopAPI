package com.vtn.repository;

import com.vtn.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Page<Comment> findByProductId(int productId, Pageable pageable);
    Comment findByCustomerIdAndProductId(int customerId, int producId);
}
