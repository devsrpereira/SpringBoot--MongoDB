package com.srdevpereira.springbootmongodb.resources;

import com.srdevpereira.springbootmongodb.domain.Post;
import com.srdevpereira.springbootmongodb.domain.User;
import com.srdevpereira.springbootmongodb.dto.UserDTO;
import com.srdevpereira.springbootmongodb.services.PostService;
import com.srdevpereira.springbootmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResources {

    @Autowired
    private PostService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
