package com.srdevpereira.springbootmongodb.services;

import com.srdevpereira.springbootmongodb.domain.Post;
import com.srdevpereira.springbootmongodb.domain.User;
import com.srdevpereira.springbootmongodb.dto.UserDTO;
import com.srdevpereira.springbootmongodb.repository.PostRepository;
import com.srdevpereira.springbootmongodb.repository.UserRepository;
import com.srdevpereira.springbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrato"));
    }


}
