package com.example.springsocialnetworkapi.controller;

import com.example.springsocialnetworkapi.controller.output.CommentOutput;
import com.example.springsocialnetworkapi.dto.comment.CommentDto;
import com.example.springsocialnetworkapi.service.comment.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private ICommentService commentService;

    @GetMapping(value = "/show")
    public CommentOutput showComment() {
        CommentOutput result = new CommentOutput();
        result.setListComment(commentService.getListComment());
        return result;
    }

    @PostMapping(value = "/create")
    public CommentDto createComment(@Valid @RequestBody CommentDto model) {
        return commentService.save(model);
    }

    @PutMapping(value = "/update/{id}")
    public CommentDto createComment(@Valid @RequestBody CommentDto model, @PathVariable("id") long id) {
        model.setId(id);
        return commentService.save(model);
    }

    @DeleteMapping(value = "/delete")
    public void deleteComment(@RequestBody long[] ids) {
        commentService.delete(ids);
    }
}
