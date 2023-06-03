package com.srdevpereira.springbootmongodb.repository;

import com.srdevpereira.springbootmongodb.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    @Query("{'title': {$regex: ?0, $options: 'i'}}")
    List<Post> searchTitle(String Text);

    List<Post> findByTitleContainsIgnoreCase(String text);
}
