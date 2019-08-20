package com.vtn.controller;

import com.vtn.model.Comment;
import com.vtn.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    CommentService comSer;

    @GetMapping("/list")
    public List<Comment> getListComment(@RequestParam int id, @RequestParam int page, @RequestParam int size) {
        return comSer.findByProductId(id, page, size);
    }

    @PostMapping("/insert")
    public ResponseEntity<List<Comment>> insert(@RequestBody Comment comment) {
        List<Comment> comments = comSer.insert(comment);
        if (comments.size() != 0) {
            return new ResponseEntity<>(comments, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

//    @GetMapping("/commented")
//    public Comment checkCommentedOrNot(@RequestParam int customerId, @RequestParam int productId) {
//        System.out.println(customerId + " " + productId);
//        return comSer.checkCommentedOrNot(customerId, productId);
//    }

    @GetMapping("/commented")
    public ResponseEntity<Comment> checkCommentedOrNot(@RequestParam int customerId, @RequestParam int productId) {
        Comment comment = comSer.checkCommentedOrNot(customerId, productId);
        if (comment != null) {
            return new ResponseEntity<>(comment, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
