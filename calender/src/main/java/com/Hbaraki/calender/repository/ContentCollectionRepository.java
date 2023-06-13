package com.Hbaraki.calender.repository;

import com.Hbaraki.calender.model.Content;
import com.Hbaraki.calender.model.Status;
import com.Hbaraki.calender.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList=new ArrayList<>();

    public ContentCollectionRepository(){

    }
    public List<Content> findAll(){
        return contentList;
    }
    public Optional<Content>findById(Integer id){
        return contentList.stream().filter(c ->c.id().equals(id) ).findFirst();
    }
    @PostConstruct
    private void init(){
        Content c =new Content(1,
                 "my first Blog post",
                 "my first Blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                 null,
                "");
        contentList.add(c);

    }
    public void save(Content content){
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c ->c.id().equals(id) ).count()==1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c ->c.id().equals(id));
    }
}
