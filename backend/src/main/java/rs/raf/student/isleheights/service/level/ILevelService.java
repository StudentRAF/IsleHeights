package rs.raf.student.isleheights.service.level;

import rs.raf.student.isleheights.dto.level.LevelGetDto;
import rs.raf.student.isleheights.dto.level.LevelThumbnailGetDto;

import java.util.List;

public interface ILevelService {

    List<LevelThumbnailGetDto> getAll();

    LevelGetDto getLevel(String name);

}
