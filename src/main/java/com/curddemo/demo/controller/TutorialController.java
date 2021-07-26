package com.curddemo.demo.controller;

import com.curddemo.demo.dao.TutorialRepository;
import com.curddemo.demo.exception.ResourceNotFoundException;
import com.curddemo.demo.model.Tutorial;
import com.curddemo.demo.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TutorialController {

    @Autowired
    TutorialRepository tutorialRepository;

    @GetMapping("tutorial")
    public ResponseEntity<List<Tutorial>> getAllTutorials(@RequestParam(required = false) String title) {
        List<Tutorial> tutorials = new ArrayList<Tutorial>();

        if (title == null)
            tutorialRepository.findAll().forEach(tutorials::add);
        else
            tutorialRepository.findByTitleContaining(title).forEach(tutorials::add);

        if (tutorials.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tutorials, HttpStatus.OK);
    }


    @GetMapping("/tutorial/{id}")
    public ResponseEntity<Tutorial> getTutorialById(@PathVariable("id") int id) {
        Tutorial tutorial = tutorialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
        return new ResponseEntity<>(tutorial, HttpStatus.OK);
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Tutorial> createTutorial(@Valid  @RequestBody Tutorial tutorial) {
        Tutorial tut = tutorialRepository.save(tutorial);
        return new ResponseEntity<>(tut, HttpStatus.CREATED);
    }

    @PutMapping("/tutorial/{id}")
    public ResponseEntity<Tutorial> updateTutorial(@PathVariable("id") int id, @RequestBody Tutorial tutorial) {
        Tutorial tut = tutorialRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found Tutorial with id = " + id));
        tut.setTitle(tutorial.getTitle());
        tut.setDescription(tutorial.getDescription());
        tut.setPublished(tutorial.isPublished());
        return new ResponseEntity<>(tutorialRepository.save(tut), HttpStatus.OK);
    }


    @DeleteMapping("/tutorial/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") int id) {
        tutorialRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/tutorial")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        tutorialRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
