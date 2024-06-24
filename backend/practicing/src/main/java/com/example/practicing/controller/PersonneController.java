package com.example.practicing.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practicing.model.Personne;
import com.example.practicing.repository.PersonneRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/personnes")
@Api(value = "Personne Management System")
public class PersonneController {

    @Autowired
    private PersonneRepository personneRepository;

    @ApiOperation(value = "View a list of available personnes", response = List.class)
    @GetMapping
    public List<Personne> getAllpersonnes() {
        return personneRepository.findAll();
    }

    @ApiOperation(value = "Add a personne")
    @PostMapping
    public Personne createPersonne(@RequestBody Personne personne) {
        return personneRepository.save(personne);
    }

    @ApiOperation(value = "Get a personne by Id")
    @GetMapping("/{id}")
    public ResponseEntity<Personne> getPersonneById(@PathVariable Long id) {
        return personneRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @ApiOperation(value = "Update a personne")
    @PutMapping("/{id}")
    public ResponseEntity<Personne> updatePersonne(@PathVariable Long id, @RequestBody Personne personneDetails) {
        Optional<Personne> personneOptional = personneRepository.findById(id);
        if (personneOptional.isPresent()) {
            Personne personne = personneOptional.get();
            personne.setNom(personneDetails.getNom());
            personne.setPrenom(personneDetails.getPrenom());
            personne.setNbrVote(personneDetails.getNbrVote());
            personne.setHasVoted(personneDetails.isHasVoted());
            return ResponseEntity.ok(personneRepository.save(personne));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ApiOperation(value = "Delete a personne")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletepersonne(@PathVariable Long id) {
        return personneRepository.findById(id)
                .map(personne -> {
                    personneRepository.delete(personne);
                    return ResponseEntity.ok().<Void>build();
                }).orElse(ResponseEntity.notFound().build());
    }
}