package rs.raf.student.isleheights.mapper;

import rs.raf.student.isleheights.dto.image.ImageCreateDto;
import rs.raf.student.isleheights.dto.image.ImageGetDto;
import rs.raf.student.isleheights.entity.Image;

public class ImageMapper {

    public static ImageGetDto mapDto(Image image) {
        return new ImageGetDto(image.id(),
                               image.name(),
                               image.type(),
                               image.data());
    }

    public static Image map(Image image, ImageCreateDto createDto) {
        return image.setName(createDto.name())
                    .setType(createDto.type())
                    .setData(createDto.data());
    }

    public static Image mapEntity(ImageCreateDto createDto) {
        return map(new Image(), createDto);
    }

}
