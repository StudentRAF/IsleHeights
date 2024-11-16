package rs.raf.student.isleheights.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import rs.raf.student.isleheights.dto.image.ImageCreateDto;
import rs.raf.student.isleheights.dto.image.ImageGetDto;
import rs.raf.student.isleheights.exception.ExceptionType;
import rs.raf.student.isleheights.exception.IsleHeightsException;
import rs.raf.student.isleheights.logger.LoggerUtils;
import rs.raf.student.isleheights.service.image.IImageService;
import rs.raf.student.isleheights.type.ImageType;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/images")
public class ImageController {

    private final IImageService service;

    @GetMapping("/{id}")
    public ResponseEntity<ImageGetDto> getById(@PathVariable("id") Long id) {
        return LoggerUtils.handleResponse(() -> new ResponseEntity<>(service.getImage(id), HttpStatus.OK));
    }

    @GetMapping("/raw/{id}")
    public ResponseEntity<byte[]> getDataById(@PathVariable("id") Long id) {
        return LoggerUtils.handleResponse(() -> new ResponseEntity<>(service.getImageData(id),
                                                                     new HttpHeaders(CollectionUtils.toMultiValueMap(Map.of(HttpHeaders.CONTENT_TYPE, List.of(MediaType.IMAGE_PNG.toString())))),
                                                                     HttpStatus.OK));
    }

    @PostMapping("")
    public ResponseEntity<ImageGetDto> create(@RequestParam("name") String name,
                                              @RequestParam("type") ImageType type,
                                              @RequestPart("data")  MultipartFile file) {
        return LoggerUtils.handleResponse(() -> {
            byte[] data;

            try {
                data = file.getBytes();
            }
            catch (Exception exception) {
                throw new IsleHeightsException(ExceptionType.GET_BYTES_FILE_FAILED_STORE, file.getName());
            }

            return new ResponseEntity<>(service.create(new ImageCreateDto(name, type, data)), HttpStatus.CREATED);
        });
    }

}
