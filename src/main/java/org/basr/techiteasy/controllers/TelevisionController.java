package org.basr.techiteasy.controllers;

import org.basr.techiteasy.dto.TelevisionRequestDto;
import org.basr.techiteasy.dto.TelevisionResponseDto;
import org.basr.techiteasy.model.Television;
import org.basr.techiteasy.service.TelevisionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.basr.techiteasy.mapper.TelevisionMapper.toResponseDto;

@RestController
@RequestMapping("/televisions")

public class TelevisionController {

    private final TelevisionService service;

    public TelevisionController(TelevisionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TelevisionResponseDto> createTelevision(@RequestBody TelevisionRequestDto televisionRequestDto) {

        Television television = this.service.createTelevision(televisionRequestDto);
        TelevisionResponseDto televisionResponseDto = toResponseDto(television);

        URI uri = URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + television.getId()).toUriString());

        return ResponseEntity.created(uri).body(televisionResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> getTelevision(@PathVariable Long id) {
        return ResponseEntity.ok(toResponseDto(this.service.getSingleTelevision(id)));
    }

    @GetMapping()
    public ResponseEntity<List<Television>> getAll() {

        List<Television> televisions = service.getAllTelevisions();
        return ResponseEntity.ok(televisions);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TelevisionRequestDto> deleteTelevision(@PathVariable Long id) {
        service.deleteTelevision(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelevisionResponseDto> updateTelevision(@PathVariable Long id, @RequestBody TelevisionRequestDto newTelevision) {

        TelevisionResponseDto dto = service.updateTelevision(id, newTelevision);

        return ResponseEntity.ok(dto);
    }

    @PatchMapping("{id}")
    public ResponseEntity<TelevisionResponseDto> updatePartialTelevision(@PathVariable Long id, @RequestBody TelevisionRequestDto newTelevision) {

        TelevisionResponseDto dto = service.updateTelevision(id, newTelevision);

        return ResponseEntity.ok(dto);
        }
    }
