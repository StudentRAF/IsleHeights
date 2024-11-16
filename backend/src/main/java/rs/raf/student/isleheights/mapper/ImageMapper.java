package rs.raf.student.isleheights.mapper;

import rs.raf.student.isleheights.dto.image.ImageGetDto;
import rs.raf.student.isleheights.entity.Image;

public class ImageMapper {

    public static ImageGetDto mapDto(Image image) {
        return new ImageGetDto(image.id(),
                               image.name(),
                               image.type(),
                               image.data());
    }

}
