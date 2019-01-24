package com.radek.entranceSystem.hibernate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
public class BoxHistoryId implements Serializable {

    @Column(name = "ID_BOX")
    private Integer boxId;

    @Column(name = "ID_USER")
    private Integer userId;

    public BoxHistoryId(Integer boxId, Integer userId) {
        this.boxId = boxId;
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoxHistoryId that = (BoxHistoryId) o;
        return Objects.equals(boxId, that.boxId) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(boxId, userId);
    }
}
