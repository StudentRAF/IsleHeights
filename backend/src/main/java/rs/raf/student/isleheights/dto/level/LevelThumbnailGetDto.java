package rs.raf.student.isleheights.dto.level;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.MessageFormat;
import java.util.Objects;

public class LevelThumbnailGetDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("thumbnail_id")
    private Long thumbnail;

    //region Constructors

    public LevelThumbnailGetDto() { }

    public LevelThumbnailGetDto(String name, Long thumbnail) {
        setName(name);
        setThumbnail(thumbnail);
    }

    //endregion Constructors

    //region Data

    public LevelThumbnailGetDto setName(String name) {
        this.name = name;

        return this;
    }

    public String name() {
        return name;
    }

    public LevelThumbnailGetDto setThumbnail(Long thumbnail) {
        this.thumbnail = thumbnail;

        return this;
    }

    public Long thumbnail() {
        return thumbnail;
    }

    //endregion Data

    //region Object

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;

        if (object instanceof LevelThumbnailGetDto dto)
            return Objects.equals(dto.name, name);

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return MessageFormat.format("""
                                    {0}: '{' name = {1} '}'\
                                    """,
                                    LevelThumbnailGetDto.class.getSimpleName(), name);
    }

    //endregion Object

}
