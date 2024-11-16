package rs.raf.student.isleheights.service.image;

import rs.raf.student.isleheights.dto.image.ImageCreateDto;
import rs.raf.student.isleheights.dto.image.ImageGetDto;

public interface IImageService {

    ImageGetDto getImage(Long id);

    byte[] getImageData(Long id);

    ImageGetDto create(ImageCreateDto createDto);

}
