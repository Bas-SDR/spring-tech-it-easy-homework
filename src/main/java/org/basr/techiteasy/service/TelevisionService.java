package org.basr.techiteasy.service;

import org.basr.techiteasy.dto.TelevisionRequestDto;
import org.basr.techiteasy.dto.TelevisionResponseDto;
import org.basr.techiteasy.exceptions.RecordNotFoundException;
import org.basr.techiteasy.mapper.TelevisionMapper;
import org.basr.techiteasy.model.Television;
import org.basr.techiteasy.repository.TelevisionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

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

    public void deleteTelevision(@RequestBody Long id) {
        repos.deleteById(id);
    }

    public TelevisionResponseDto updateTelevision(Long id, TelevisionRequestDto newTelevision) {

        Optional<Television> television = repos.findById(id);

        if (television.isEmpty()) {
            throw new RecordNotFoundException("No television found with id: " + id);
        } else {

            Television tv = television.get();

            tv.setAmbiLight(newTelevision.getAmbiLight());
            tv.setAvailableSize(newTelevision.getAvailableSize());
            tv.setAmbiLight(newTelevision.getAmbiLight());
            tv.setBluetooth(newTelevision.getBluetooth());
            tv.setBrand(newTelevision.getBrand());
            tv.setHdr(newTelevision.getHdr());
            tv.setName(newTelevision.getName());
            tv.setOriginalStock(newTelevision.getOriginalStock());
            tv.setPrice(newTelevision.getPrice());
            tv.setRefreshRate(newTelevision.getRefreshRate());
            tv.setScreenQuality(newTelevision.getScreenQuality());
            tv.setScreenType(newTelevision.getScreenType());
            tv.setSmartTv(newTelevision.getSmartTv());
            tv.setSold(newTelevision.getSold());
            tv.setType(newTelevision.getType());
            tv.setVoiceControl(newTelevision.getVoiceControl());
            tv.setWifi(newTelevision.getWifi());

            Television returnTelevision = repos.save(tv);

            return TelevisionMapper.toResponseDto(returnTelevision);
        }
    }

    public TelevisionResponseDto patchTelevision(Long id, TelevisionRequestDto newTelevision) {
    Optional<Television> television = repos.findById(id);

        if (television.isEmpty()) {
            throw new RecordNotFoundException("No television found with id: " + id);
        } else {

            Television tv = television.get();
            if (newTelevision.getAmbiLight() != null) {
                tv.setAmbiLight(newTelevision.getAmbiLight());
            }
            if (newTelevision.getAvailableSize() != null) {
                tv.setAvailableSize(newTelevision.getAvailableSize());
            }
            if (newTelevision.getBluetooth()) {
                tv.setBluetooth(newTelevision.getBluetooth());
            }
            if (newTelevision.getBrand() != null) {
                tv.setBrand(newTelevision.getBrand());
            }
            if (newTelevision.getHdr() != null) {
                tv.setHdr(newTelevision.getHdr());
            }
            if (newTelevision.getName() != null) {
                tv.setName(newTelevision.getName());
            }
            if (newTelevision.getOriginalStock() != null) {
                tv.setOriginalStock(newTelevision.getOriginalStock());
            }
            if (newTelevision.getPrice() != null) {
                tv.setPrice(newTelevision.getPrice());
            }
            if (newTelevision.getRefreshRate() != null) {
                tv.setRefreshRate(newTelevision.getRefreshRate());
            }
            if (newTelevision.getScreenQuality() != null) {
                tv.setScreenQuality(newTelevision.getScreenQuality());
            }
            if (newTelevision.getScreenType() != null) {
                tv.setScreenType(newTelevision.getScreenType());
            }
            if (newTelevision.getSmartTv() != null) {
                tv.setSmartTv(newTelevision.getSmartTv());
            }
            if (newTelevision.getSold() != null) {
                tv.setSold(newTelevision.getSold());
            }
            if (newTelevision.getType() != null) {
                tv.setType(newTelevision.getType());
            }
            if (newTelevision.getVoiceControl() != null) {
                tv.setVoiceControl(newTelevision.getVoiceControl());
            }
            if (newTelevision.getWifi() != null) {
                tv.setWifi(newTelevision.getWifi());
            }

            Television returnTelevision = repos.save(tv);
            return TelevisionMapper.toResponseDto(returnTelevision);
        }
    }
}
