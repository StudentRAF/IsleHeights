package rs.raf.student.isleheights.service.image;

import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import org.springframework.stereotype.Service;
import rs.raf.student.isleheights.dto.image.ImageGetDto;
import rs.raf.student.isleheights.exception.ExceptionType;
import rs.raf.student.isleheights.exception.IsleHeightsException;
import rs.raf.student.isleheights.mapper.ImageMapper;
import rs.raf.student.isleheights.repository.IImageRepository;

@Service
@RequiredArgsConstructor
@ExtensionMethod({ImageMapper.class})
public class ImageService implements IImageService {

    private final IImageRepository repository;

    @Override
    public ImageGetDto getImage(Long id) {
        return repository.findById(id)
                         .orElseThrow(() -> new IsleHeightsException(ExceptionType.FIND_IMAGE_NOT_FOUND_ID, id.toString()))
                         .mapDto();
    }

    @Override
    public byte[] getImageData(Long id) {
        return repository.findById(id)
                         .orElseThrow(() -> new IsleHeightsException(ExceptionType.FIND_IMAGE_NOT_FOUND_ID, id.toString()))
                         .data();
    }

}
