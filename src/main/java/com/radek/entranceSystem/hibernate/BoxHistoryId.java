package com.radek.entranceSystem.hibernate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

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
}
