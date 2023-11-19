package org.atwop.infrastructure.repository.panache;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "movies")
public class MovieEntity extends PanacheEntityBase {

    @Id
    public String id;

    @Column(name = "title")
    public String title;

    @Column(name = "punctuation")
    public Float punctuation;

    public LocalDateTime dateCreated;

    public String status;
}
