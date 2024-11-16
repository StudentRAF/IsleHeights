package rs.raf.student.isleheights.dto.level;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

public class LevelCreateDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("islands")
    private List<Integer> islands;

    @JsonProperty("thumbnail_id")
    private Long thumbnail;

    //region Constructors

    public LevelCreateDto() { }

    public LevelCreateDto(String name, List<Integer> islands, Long thumbnail) {
        setName(name);
        setIslands(islands);
        setThumbnail(thumbnail);
    }

    //endregion Constructors

    //region Data

    public LevelCreateDto setName(String name) {
        this.name = name;

        return this;
    }

    public String name() {
        return name;
    }

    public LevelCreateDto setIslands(List<Integer> islands) {
        this.islands = islands;

        return this;
    }

    public List<Integer> islands() {
        return islands;
    }

    public LevelCreateDto setThumbnail(Long thumbnail) {
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

        if (object instanceof LevelCreateDto dto)
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
                                    LevelCreateDto.class.getSimpleName(), name);
    }

    //endregion Object

}
