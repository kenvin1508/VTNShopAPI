package com.vtn.service;

import com.vtn.VtnShopUtil;
import com.vtn.model.Comment;
import com.vtn.repository.CommentRepository;
import com.vtn.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    CommentRepository comRep;
    @Autowired
    CustomerRepository cusRep;

    public List<Comment> findByProductId(int productId, int page, int size) {
        List<Comment> comments = comRep.findByProductId(productId,
                PageRequest.of(page, size, Sort.by("CreatedDate").descending())).getContent();
        List<Comment> commentss = new ArrayList<>();
        for (Comment comment : comments) {
            comment.setCustomerName(cusRep.getCustomerName(comment.getCustomerId()));
            comment.setCreatedDate(VtnShopUtil.formatDate(comment.getCreatedDate()));
            commentss.add(comment);
        }
        return commentss;
    }

    public List<Comment> insert(Comment comment) {
        Comment commentt = checkCommentedOrNot(comment.getCustomerId(), comment.getProductId());
        if (commentt != null) {
            commentt.setCreatedDate(comment.getCreatedDate());
            commentt.setContent(comment.getContent());
            commentt.setTitle(comment.getTitle());
            commentt.setRating(comment.getRating());
            comRep.save(commentt);
        } else {
            comRep.save(comment);
        }
        return findByProductId(comment.getProductId(), 0, 5);
    }


    public Comment checkCommentedOrNot(int customerId, int productId) {
        Comment comment = comRep.findByCustomerIdAndProductId(customerId, productId);
        if (comment != null) {
            return comment;
        }
        return null;
    }
}
