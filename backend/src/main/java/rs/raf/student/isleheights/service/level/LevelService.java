package rs.raf.student.isleheights.service.level;

import lombok.RequiredArgsConstructor;
import lombok.experimental.ExtensionMethod;
import org.springframework.stereotype.Service;
import rs.raf.student.isleheights.dto.level.LevelGetDto;
import rs.raf.student.isleheights.dto.level.LevelThumbnailGetDto;
import rs.raf.student.isleheights.exception.ExceptionType;
import rs.raf.student.isleheights.exception.IsleHeightsException;
import rs.raf.student.isleheights.mapper.LevelMapper;
import rs.raf.student.isleheights.repository.ILevelRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@ExtensionMethod({LevelMapper.class})
public class LevelService implements ILevelService {

    private final ILevelRepository repository;

    @Override
    public List<LevelThumbnailGetDto> getAll() {
        return repository.findAll()
                         .stream()
                         .map(LevelMapper::mapThumbnailDto)
                         .toList();
    }

    @Override
    public LevelGetDto getLevel(String name) {
        return repository.findByName(name)
                         .orElseThrow(() -> new IsleHeightsException(ExceptionType.FIND_LEVEL_NOT_FOUND_NAME, name))
                         .mapDto();
    }

}
