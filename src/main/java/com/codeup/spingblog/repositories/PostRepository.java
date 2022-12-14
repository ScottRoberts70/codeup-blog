package com.codeup.spingblog.repositories;

import com.codeup.spingblog.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Post p SET p.title = :title, p.body = :body WHERE p.id = :id")
    Integer editPost(@Param ("title") String title, @Param("body") String body, @Param("id") Long id);

}
