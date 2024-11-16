package rs.raf.student.isleheights.mapper;

import lombok.experimental.ExtensionMethod;
import rs.raf.student.isleheights.dto.level.LevelGetDto;
import rs.raf.student.isleheights.dto.level.LevelThumbnailGetDto;
import rs.raf.student.isleheights.entity.Level;

@ExtensionMethod({ImageMapper.class})
public class LevelMapper {

    public static LevelGetDto mapDto(Level level) {
        return new LevelGetDto(level.name(),
                               level.islands(),
                               level.thumbnail());
    }

    public static LevelThumbnailGetDto mapThumbnailDto(Level level) {
        return new LevelThumbnailGetDto(level.name(),
                                        level.thumbnail());
    }

}
