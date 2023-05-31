package com.srdevpereira.springbootmongodb.config;

import com.srdevpereira.springbootmongodb.domain.Post;
import com.srdevpereira.springbootmongodb.domain.User;
import com.srdevpereira.springbootmongodb.dto.AuthorDTO;
import com.srdevpereira.springbootmongodb.dto.CommentDTO;
import com.srdevpereira.springbootmongodb.repository.PostRepository;
import com.srdevpereira.springbootmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User u1 = new User(null, "Maria Silva", "maria@gmail.com");
        User u2 = new User(null, "Alex Monteiro", "alex@gmail.com");
        User u3 = new User(null, "Saulo Pereira", "saulo@gmail.com");
        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Post post1 = new Post(null, sdf.parse("21/03/2022"),"Partiu viagem!","Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
        Post post2 = new Post(null, sdf.parse("23/03/2023"),"Bom dia!","Acordei feliz hoje!", new AuthorDTO(u1));

        CommentDTO c1 = new CommentDTO( "Boa viagem mano!", sdf.parse("21/03/2022"), new AuthorDTO(u2));
        CommentDTO c2 = new CommentDTO( "Aproveite!", sdf.parse("22/03/2022"), new AuthorDTO(u3));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2023"), new AuthorDTO(u2));

        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        postRepository.saveAll(Arrays.asList(post1, post2));

        u1.getPosts().addAll(Arrays.asList(post1,post2));
        userRepository.save(u1);

    }
}
