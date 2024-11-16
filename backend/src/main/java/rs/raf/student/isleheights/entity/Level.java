package rs.raf.student.isleheights.entity;

import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Accessors(fluent = true, chain = true)
@EntityListeners(AuditingEntityListener.class)
@Table(
    name = Level.Meta.Table.NAME,
    indexes = {
        @Index(
            name = "index_level_on_name",
            columnList = Level.Meta.Column.NAME
        ),
    },
    uniqueConstraints = {
        @UniqueConstraint(
            name = "unique_level_on_name",
            columnNames = Level.Meta.Column.NAME
        ),
    }
)
public class Level {

    @Id
    @Column(name = Meta.Column.IDENTIFIER)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = Meta.Column.NAME, nullable = false, length = 64)
    private String name;

    @Column(name = Meta.Column.THUMBNAIL, nullable = false)
    private Long thumbnailId;

    @Type(ListArrayType.class)
    @Column(name = Meta.Column.ISLANDS, nullable = false, columnDefinition = "integer[]")
    private List<Integer> islands;

    @CreatedDate
    @Column(name = Meta.Column.CREATED_AT, nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = Meta.Column.MODIFIED_AT, nullable = false)
    private LocalDateTime modifiedAt;

    //region Constructors

    public Level() { }

    public Level(Long id, String name, Long thumbnailId, List<Integer> islands, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        setId(id);
        setName(name);
        setThumbnailId(thumbnailId);
        setIslands(islands);
        setCreatedAt(createdAt);
        setModifiedAt(modifiedAt);
    }

    //endregion Constructors

    //region Data

    public Level setId(Long id) {
        this.id = id;

        return this;
    }

    public Long id() {
        return id;
    }

    public Level setName(String name) {
        this.name = name;

        return this;
    }

    public String name() {
        return name;
    }

    public Level setThumbnailId(Long thumbnailId) {
        this.thumbnailId = thumbnailId;

        return this;
    }

    public Long thumbnail() {
        return thumbnailId;
    }

    public Level setIslands(List<Integer> islands) {
        this.islands = islands;

        return this;
    }

    public List<Integer> islands() {
        return islands;
//        return List.of();
    }

    public Level setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;

        return this;
    }

    public LocalDateTime createdAt() {
        return createdAt;
    }

    public Level setModifiedAt(LocalDateTime modifiedAt) {
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

        if (object instanceof Level image)
            return Objects.equals(image.id, id) &&
                   Objects.equals(image.name, name);

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public String toString() {
        return MessageFormat.format("""
                                    {0}: '{' id = {1} | name = {2} | createdAt = {3} | modifiedAt = {4} '}'\
                                    """,
                                    Level.class.getSimpleName(), id, name, createdAt, modifiedAt);
    }

    //endregion Object

    //region Meta

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Meta {

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class Table {

            public static final String NAME = "Level";

        }

        @NoArgsConstructor(access = AccessLevel.PRIVATE)
        public static class Column {

            public static final String IDENTIFIER  = "id";
            public static final String NAME        = "name";
            public static final String THUMBNAIL   = "image_id";
            public static final String ISLANDS     = "islands";
            public static final String CREATED_AT  = "created_at";
            public static final String MODIFIED_AT = "modified_at";

        }

    }

    //endregion Meta

}
