package com.codeup.spingblog.repositories;

import com.codeup.spingblog.model.Post;
import com.codeup.spingblog.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {
}


