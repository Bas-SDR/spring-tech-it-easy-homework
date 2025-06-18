package org.basr.techiteasy.mapper;

import org.basr.techiteasy.dto.TelevisionRequestDto;
import org.basr.techiteasy.dto.TelevisionResponseDto;
import org.basr.techiteasy.model.Television;

public class TelevisionMapper {

    public static Television toEntity(TelevisionRequestDto televisionRequestDto) {
        Television television = new Television(
                televisionRequestDto.type,
                televisionRequestDto.brand,
                televisionRequestDto.name,
                televisionRequestDto.price,
                televisionRequestDto.availableSize,
                televisionRequestDto.refreshRate,
                televisionRequestDto.screenType,
                televisionRequestDto.screenQuality,
                televisionRequestDto.smartTv,
                televisionRequestDto.wifi,
                televisionRequestDto.voiceControl,
                televisionRequestDto.hdr,
                televisionRequestDto.bluetooth,
                televisionRequestDto.ambiLight,
                televisionRequestDto.originalStock,
                televisionRequestDto.sold
        );
        return television;
    }

    public static TelevisionResponseDto toResponseDto(Television television) {
        TelevisionResponseDto televisionResponseDto = new TelevisionResponseDto();
        televisionResponseDto.id = television.getId();
        televisionResponseDto.type = television.getType();
        televisionResponseDto.brand = television.getBrand();
        televisionResponseDto.name = television.getName();
        televisionResponseDto.price = television.getPrice();
        televisionResponseDto.availableSize = television.getAvailableSize();
        televisionResponseDto.refreshRate = television.getRefreshRate();
        televisionResponseDto.screenType = television.getScreenType();
        televisionResponseDto.screenQuality = television.getScreenQuality();
        televisionResponseDto.smartTv = television.getSmartTv();
        televisionResponseDto.wifi = television.getWifi();
        televisionResponseDto.voiceControl = television.getVoiceControl();
        televisionResponseDto.hdr = television.getHdr();
        televisionResponseDto.bluetooth = television.getBluetooth();
        televisionResponseDto.ambiLight = television.getAmbiLight();
        televisionResponseDto.originalStock = television.getOriginalStock();
        televisionResponseDto.sold = television.getSold();
        return televisionResponseDto;
    }
}
