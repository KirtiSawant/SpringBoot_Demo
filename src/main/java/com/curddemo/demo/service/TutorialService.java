package com.curddemo.demo.service;

import com.curddemo.demo.dao.TutorialRepository;
import com.curddemo.demo.model.Tutorial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TutorialService {
    @Autowired
    TutorialRepository tutorialRepository;

    public List<Tutorial> getAllTutorial(String title) {
        List<Tutorial> tutorials = new ArrayList<Tutorial>();
        if (title == null && tutorials.isEmpty())
            tutorialRepository.findAll().forEach(tutorials::add);
        else
            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);
         return tutorials;
    }
}
