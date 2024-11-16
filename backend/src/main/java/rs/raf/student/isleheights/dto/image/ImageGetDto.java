package rs.raf.student.isleheights.dto.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import rs.raf.student.isleheights.type.ImageType;

import java.text.MessageFormat;
import java.util.Objects;

public class ImageGetDto {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private ImageType type;

    @JsonProperty("data")
    private byte[] data;

    //region Constructors

    public ImageGetDto() { }

    public ImageGetDto(Long id, String name, ImageType type, byte[] data) {
        setId(id);
        setName(name);
        setType(type);
        setData(data);
    }

    //endregion Constructors

    //region Data

    public ImageGetDto setId(Long id) {
        this.id = id;

        return this;
    }

    public Long id() {
        return id;
    }

    public ImageGetDto setName(String name) {
        this.name = name;

        return this;
    }

    public String name() {
        return name;
    }

    public ImageGetDto setType(ImageType type) {
        this.type = type;

        return this;
    }

    public ImageType type() {
        return type;
    }

    public ImageGetDto setData(byte[] data) {
        this.data = data;

        return this;
    }

    public byte[] data() {
        return data;
    }

    //endregion Data

    //region Object

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;

        if (object instanceof ImageGetDto dto)
            return Objects.equals(dto.id, id)     &&
                   Objects.equals(dto.name, name) &&
                   Objects.equals(dto.type, type);

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public String toString() {
        return MessageFormat.format("""
                                    {0}: '{' id = {1} | name = {2} | type = {3} '}'\
                                    """,
                                    ImageGetDto.class.getSimpleName(), id, name, type);
    }

    //endregion Object

}
