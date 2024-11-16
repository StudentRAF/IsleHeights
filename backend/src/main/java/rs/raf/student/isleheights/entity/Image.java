package rs.raf.student.isleheights.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import rs.raf.student.isleheights.type.ImageType;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Accessors(fluent = true, chain = true)
@EntityListeners(AuditingEntityListener.class)
@Table(
    name = Image.Meta.Table.NAME,
    indexes = {
        @Index(
            name = "index_image_on_name",
            columnList = Image.Meta.Column.NAME
        ),
    },
    uniqueConstraints = {
        @UniqueConstraint(
            name = "unique_image_on_name_and_type",
            columnNames = {
                Image.Meta.Column.NAME,
                Image.Meta.Column.TYPE
            }
        ),
    }
)
public class Image {

    @Id
    @Column(name = Meta.Column.IDENTIFIER)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = Meta.Column.NAME, nullable = false, length = 64)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = Meta.Column.TYPE, nullable = false)
    private ImageType type;

    @Lob
    @Column(name = Meta.Column.DATA, nullable = false)
    private byte[] data;

    @CreatedDate
    @Column(name = Meta.Column.CREATED_AT, nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = Meta.Column.MODIFIED_AT, nullable = false)
    private LocalDateTime modifiedAt;

    //region Constructors

    public Image() { }

    public Image(Long id, String name, ImageType type, byte[] data, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        setId(id);
        setName(name);
        setType(type);
        setData(data);
        setCreatedAt(createdAt);
        setModifiedAt(modifiedAt);
    }

    //endregion Constructors

    //region Data

    public Image setId(Long id) {
        this.id = id;

        return this;
    }

    public Long id() {
        return id;
    }

    public Image setName(String name) {
        this.name = name;

        return this;
    }

    public String name() {
        return name;
    }

    public Image setType(ImageType type) {
        this.type = type;

        return this;
    }

    public ImageType type() {
        return type;
    }

    public Image setData(byte[] data) {
        this.data = data;

        return this;
    }

    public byte[] data() {
        return data;
    }

    public Image setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;

        return this;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public Image setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;

        return this;
    }

    public LocalDateTime modifiedAt() {
        return modifiedAt;
    }

    //endregion Data

    //region Object

    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;

        if (object instanceof Image image)
            return Objects.equals(image.id, id) &&
                   Objects.equals(image.name, name) &&
                   Objects.equals(image.type, type);

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type);
    }

    public String toString() {
        return MessageFormat.format("""
                                    {0}: '{' id = {1} | name = {2} | type = {3} | createdAt = {4} | modifiedAt = {5} '}'\
                                    """,
                                    Image.class.getSimpleName(), id, name, type, createdAt, modifiedAt);
    }

    //endregion Object

    //region Meta

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Meta {

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class Table {

            public static final String NAME = "image";

        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class Column {

            public static final String IDENTIFIER  = "id";
            public static final String NAME        = "name";
            public static final String DATA        = "data";
            public static final String TYPE        = "type";
            public static final String CREATED_AT  = "created_at";
            public static final String MODIFIED_AT = "modified_at";

        }

    }

    //endregion Meta

}
