package com.bactoria.toy1.web;

import com.bactoria.toy1.domain.post.Post;
import com.bactoria.toy1.domain.post.PostService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping("/api/posts")
public class PostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebRestController.class);

    private PostService postService;

    @GetMapping // == @GetMapping("") != @GetMapping("/")
    public Page<Object[]> resPost(@PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 10) Pageable pageable) {
        LOGGER.info("GET  /api/posts");
        return postService.resPostsMin(pageable);
    }

    @GetMapping("/{id}")
    public Optional<Post> resPostById(@PathVariable Long id) {

        LOGGER.info("GET  /api/posts/" + id);
        return postService.resPostsById(id);
    }

    @GetMapping("/categories/{id}")
    public Page<Object[]> resPostsByCategory(
            @PathVariable Long id,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.DESC, size = 10) Pageable pageable) {

        LOGGER.info("GET  /api/posts/categories/" + id);
        return postService.resPostsByCategory(id, pageable);
    }

    @GetMapping("/search/{searchData}")
    public List<Object[]> resPostBySearchData(@PathVariable String searchData) {
        LOGGER.info("GET  /api/search" + "  searchData : " + searchData);
        return postService.resPostBySearchData(searchData.trim());
    }

}