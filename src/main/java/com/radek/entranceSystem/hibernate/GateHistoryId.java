package com.radek.entranceSystem.hibernate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
public class GateHistoryId implements Serializable {

    @Column(name = "ID_GATE")
    private Integer gateId;

    @Column(name = "ID_USER")
    private Integer userId;

    public GateHistoryId(Integer gateId, Integer userId) {
        this.gateId = gateId;
        this.userId = userId;
    }
}
