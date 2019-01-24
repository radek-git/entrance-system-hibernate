package com.radek.entranceSystem.hibernate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

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

    public BoxHistory(Box box, User user, String operationType) {
        this.id = new BoxHistoryId(box.getId(), user.getId());
        this.box = box;
        this.user = user;
        this.operationType = operationType;
        this.dateTime = LocalDateTime.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxHistory that = (BoxHistory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(box, that.box) &&
                Objects.equals(user, that.user) &&
                Objects.equals(operationType, that.operationType) &&
                Objects.equals(dateTime, that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, box, user, operationType, dateTime);
    }
}