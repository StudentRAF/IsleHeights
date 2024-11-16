package rs.raf.student.isleheights.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rs.raf.student.isleheights.dto.level.LevelCreateDto;
import rs.raf.student.isleheights.dto.level.LevelGetDto;
import rs.raf.student.isleheights.dto.level.LevelThumbnailGetDto;
import rs.raf.student.isleheights.logger.LoggerUtils;
import rs.raf.student.isleheights.service.level.ILevelService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/levels")
public class LevelController {

    private final ILevelService service;

    @GetMapping("")
    public ResponseEntity<List<LevelThumbnailGetDto>> getAll() {
        return LoggerUtils.handleResponse(() -> new ResponseEntity<>(service.getAll(), HttpStatus.OK));
    }

    @GetMapping("/{name}")
    public ResponseEntity<LevelGetDto> getById(@PathVariable("name") String name) {
        return LoggerUtils.handleResponse(() -> new ResponseEntity<>(service.getLevel(name), HttpStatus.OK));
    }

    @PostMapping("")
    public ResponseEntity<LevelGetDto> create(@RequestBody @Valid LevelCreateDto createDto) {
        return LoggerUtils.handleResponse(() -> new ResponseEntity<>(service.create(createDto), HttpStatus.CREATED));
    }

}
