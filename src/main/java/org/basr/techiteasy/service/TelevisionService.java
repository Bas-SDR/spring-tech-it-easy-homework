package org.basr.techiteasy.service;

import org.basr.techiteasy.dto.TelevisionRequestDto;
import org.basr.techiteasy.dto.TelevisionResponseDto;
import org.basr.techiteasy.exceptions.RecordNotFoundException;
import org.basr.techiteasy.mapper.TelevisionMapper;
import org.basr.techiteasy.model.Television;
import org.basr.techiteasy.repository.TelevisionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelevisionService {
    private final TelevisionRepository repos;

    public TelevisionService(TelevisionRepository repos) {
        this.repos = repos;
    }

    public Television createTelevision(TelevisionRequestDto televisionRequestDto) {
        return this.repos.save(TelevisionMapper.toEntity(televisionRequestDto));
    }

    public Television getSingleTelevision(Long id) {
        return this.repos.findById(id).orElseThrow(() -> new RecordNotFoundException("Television " + id + " not found"));
    }

    public List<Television> getAllTelevisions() {
        return repos.findAll();
    }
}
