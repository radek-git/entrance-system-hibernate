package com.radek.entranceSystem.hibernate;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "gates_history")
@Getter
@NoArgsConstructor
public class GateHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GATE")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private User user;

    @Column(name = "OPERATION_TYPE")
    private String operation;

    public GateHistory(User user, String operation) {
        this.user = user;
        this.operation = operation;
    }
}
