package com.harsh.example.demo.topic;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TopicRepository extends CrudRepository<Topic,String> {

}
