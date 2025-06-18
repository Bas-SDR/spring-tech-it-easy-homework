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
import java.util.Optional;

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

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Object> deleteTelevision(@PathVariable Long id) {
//        televisionRepository.deleteById(id);
//        return ResponseEntity.noContent().build();
//
//    }
//
//    @PutMapping("{id}")
//    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television newTelevision) {
//
//        Optional<Television> television = televisionRepository.findById(id);
//
//        if (television.isEmpty()) {
//            throw new RecordNotFoundException("No television found with id: " + id);
//        } else {
//
//            Television television1 = television.get();
//            television1.setAmbiLight(newTelevision.getAmbiLight());
//            television1.setAvailableSize(newTelevision.getAvailableSize());
//            television1.setAmbiLight(newTelevision.getAmbiLight());
//            television1.setBluetooth(newTelevision.getBluetooth());
//            television1.setBrand(newTelevision.getBrand());
//            television1.setHdr(newTelevision.getHdr());
//            television1.setName(newTelevision.getName());
//            television1.setOriginalStock(newTelevision.getOriginalStock());
//            television1.setPrice(newTelevision.getPrice());
//            television1.setRefreshRate(newTelevision.getRefreshRate());
//            television1.setScreenQuality(newTelevision.getScreenQuality());
//            television1.setScreenType(newTelevision.getScreenType());
//            television1.setSmartTv(newTelevision.getSmartTv());
//            television1.setSold(newTelevision.getSold());
//            television1.setType(newTelevision.getType());
//            television1.setVoiceControl(newTelevision.getVoiceControl());
//            television1.setWifi(newTelevision.getWifi());
//            // Sla de gewijzigde waarden op in de database onder dezelfde id. Dit moet je niet vergeten.
//            Television returnTelevision = televisionRepository.save(television1);
//            // Return de nieuwe versie van deze tv en een 200 code
//            return ResponseEntity.ok().body(returnTelevision);
//        }
//
//    }
//
//    @PatchMapping("{id}")
//    public ResponseEntity<Television> updatePartialTelevision(@PathVariable Long id, @RequestBody Television newTelevision) {
//        Optional<Television> television = televisionRepository.findById(id);
//
//        if (television.isEmpty()) {
//            throw new RecordNotFoundException("No television found with id: " + id);
//        } else {
//
//            Television television1 = television.get();
//            if (newTelevision.getAmbiLight() != null) {
//                television1.setAmbiLight(newTelevision.getAmbiLight());
//            }
//            if (newTelevision.getAvailableSize() != null) {
//                television1.setAvailableSize(newTelevision.getAvailableSize());
//            }
//            if (newTelevision.getBluetooth()) {
//                television1.setBluetooth(newTelevision.getBluetooth());
//            }
//            if (newTelevision.getBrand() != null) {
//                television1.setBrand(newTelevision.getBrand());
//            }
//            if (newTelevision.getHdr() != null) {
//                television1.setHdr(newTelevision.getHdr());
//            }
//            if (newTelevision.getName() != null) {
//                television1.setName(newTelevision.getName());
//            }
//            if (newTelevision.getOriginalStock() != null) {
//                television1.setOriginalStock(newTelevision.getOriginalStock());
//            }
//            if (newTelevision.getPrice() != null) {
//                television1.setPrice(newTelevision.getPrice());
//            }
//            if (newTelevision.getRefreshRate() != null) {
//                television1.setRefreshRate(newTelevision.getRefreshRate());
//            }
//            if (newTelevision.getScreenQuality() != null) {
//                television1.setScreenQuality(newTelevision.getScreenQuality());
//            }
//            if (newTelevision.getScreenType() != null) {
//                television1.setScreenType(newTelevision.getScreenType());
//            }
//            if (newTelevision.getSmartTv() != null) {
//                television1.setSmartTv(newTelevision.getSmartTv());
//            }
//            if (newTelevision.getSold() != null) {
//                television1.setSold(newTelevision.getSold());
//            }
//            if (newTelevision.getType() != null) {
//                television1.setType(newTelevision.getType());
//            }
//            if (newTelevision.getVoiceControl() != null) {
//                television1.setVoiceControl(newTelevision.getVoiceControl());
//            }
//            if (newTelevision.getWifi() != null) {
//                television1.setWifi(newTelevision.getWifi());
//            }
//
//            Television returnTelevision = televisionRepository.save(television1);
//            return ResponseEntity.ok().body(returnTelevision);
//        }
//    }
}