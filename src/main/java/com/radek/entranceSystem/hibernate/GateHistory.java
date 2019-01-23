package com.radek.entranceSystem.hibernate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "gates_history")
@Data
@NoArgsConstructor
public class GateHistory implements Serializable {

    @EmbeddedId
    private GateHistoryId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("gateId")
    private Gate gate;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    private User user;

    @Column(name = "OPERATION_TYPE")
    private String operationType;

    @Column(name = "DATETIME")
    private LocalDateTime dateTime;

    public GateHistory(Gate gate, User user) {
        this.id = new GateHistoryId(gate.getId(), user.getId());
        this.gate = gate;
        this.user = user;
    }
}
