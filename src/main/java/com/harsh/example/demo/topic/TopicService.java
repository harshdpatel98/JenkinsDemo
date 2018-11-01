package com.harsh.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

	@Autowired
	TopicRepository topicRepository;
	
	/*private List<Topic> topiclist = Arrays.asList(
			new Topic("spring","Spring Framework","Spring Framework Description"),
			new Topic("Java","Advance Java","Advance Java Description")
			);*/
	
	public List<Topic> getAllTopics(){
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
		//return topiclist;
	}
	
	public Topic getTopic(String id) {
		return topicRepository.findById(id).get();
		//return topiclist.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
		//topiclist.add(topic);
	}

	public void updateTopic(Topic topic, String id) {
		topicRepository.save(topic);
		/*for(int i=0;i<topiclist.size();i++) {
			Topic t = topiclist.get(i);
			if(t.getId().equals(id)) {
				topiclist.set(i,topic);
				return;
			}
		}*/
	}

	public void deleteTopic(String id) {
		topicRepository.deleteById(id);
		//topiclist.removeIf(t -> t.getId().equals(id));
	}
	
	
	
	
}
