package com.Hbaraki.calender.controller;

import com.Hbaraki.calender.model.Content;
import com.Hbaraki.calender.repository.ContentCollectionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContentController {
    private final ContentCollectionRepository repository;


    public ContentController(ContentCollectionRepository repository) {
        this.repository = repository;
    }
    // make a request and find all the pieces of the content in the system
    @GetMapping("")
    public List<Content> findAll(){
        return repository.findAll();
    }

    //create read update delete-filter |paging and sorting

    @GetMapping("/{id}")
    public Content findById(@PathVariable Integer id){
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!"));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void create( @RequestBody Content content){
        repository.save(content);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)

    @PutMapping("/{id}")

    public void update(@RequestBody Content content,Integer id){
        if(!repository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Content not found!");
        }
        repository.save(content);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(Integer id){
        repository.delete(id);
    }

}



