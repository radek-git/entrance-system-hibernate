package com.radek.entranceSystem.hibernate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "boxes_history")
@Data
@NoArgsConstructor
public class BoxHistory implements Serializable {


    @EmbeddedId
    private BoxHistoryId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("boxId")
    private Box box;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @Column(name = "OPERATION_TYPE")
    private String operationType;

    @Column(name = "DATETIME")
    private LocalDateTime dateTime;

    public BoxHistory(Box box, User user) {
        this.id = new BoxHistoryId(box.getId(), user.getId());
        this.box = box;
        this.user = user;
    }
}