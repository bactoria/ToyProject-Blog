package com.bactoria.toy1.domain.post;

import com.bactoria.toy1.domain.category.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query (value = "select post from Post post where post.category.id = ?1")
    Page<Post> findByCategoryId(Long categoryId, Pageable pabeable);

    @Query (value = "select post from Post post where lower(post.title) like lower(concat('%',?1,'%'))")
    Page<Post> findBySearchData(String SearchData, Pageable pageable);

    @Query (value = "select * from post order by id desc LIMIT 10", nativeQuery = true)
    List<Post> findInFive();

    //객체로 받는게 이쓸까? title, content, category를 한번에..
    @Modifying(clearAutomatically = true)
    @Query(value = "update Post p set p.title = ?2, p.content = ?3, p.category = ?4 where p.id = ?1")
    void modifyPost(Long id, String title, String content, Category category);
}
