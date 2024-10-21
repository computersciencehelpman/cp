package com.coderscampus.cp.service;

import com.coderscampus.cp.domain.Dinosaur;

import org.springframework.stereotype.Service;

import com.coderscampus.cp.repository.*;
import java.util.List;

@Service
public class DinosaurService {

    private final DinosaurRepository dinosaurRepository;

    public DinosaurService(DinosaurRepository dinosaurRepository) {
        this.dinosaurRepository = dinosaurRepository;
    }

    public Dinosaur save(Dinosaur dinosaur) {
        return dinosaurRepository.save(dinosaur);
    }

    public List<Dinosaur> findAll() {
        return dinosaurRepository.findAll();
    }

    public Dinosaur findById(Long id) {
        return dinosaurRepository.findById(id).get();
    }

    public void delete(Dinosaur dinosaur) {
    	dinosaurRepository.delete(dinosaur);
    }

}