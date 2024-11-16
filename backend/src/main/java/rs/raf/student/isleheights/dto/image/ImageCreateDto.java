package rs.raf.student.isleheights.dto.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import rs.raf.student.isleheights.type.ImageType;

import java.text.MessageFormat;
import java.util.Objects;

public class ImageCreateDto {

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private ImageType type;

    @JsonProperty("data")
    private byte[] data;

    //region Constructors

    public ImageCreateDto() { }

    public ImageCreateDto(String name, ImageType type, byte[] data) {
        setName(name);
        setType(type);
        setData(data);
    }

    //endregion Constructors

    //region Data

    public ImageCreateDto setName(String name) {
        this.name = name;

        return this;
    }

    public String name() {
        return name;
    }

    public ImageCreateDto setType(ImageType type) {
        this.type = type;

        return this;
    }

    public ImageType type() {
        return type;
    }

    public ImageCreateDto setData(byte[] data) {
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

        if (object instanceof ImageCreateDto dto)
            return Objects.equals(dto.name, name) &&
                   Objects.equals(dto.type, type);

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return MessageFormat.format("""
                                    {0}: '{' name = {1} | type = {2} '}'\
                                    """,
                                    ImageCreateDto.class.getSimpleName(), name, type);
    }

    //endregion Object

}
