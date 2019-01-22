package com.radek.entranceSystem.hibernate;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "boxes_history")
@Getter
@NoArgsConstructor
public class BoxHistory implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BOX")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_USER", referencedColumnName = "ID_USER")
    private User user;

    @Column(name = "OPERATION_TYPE")
    private String operation;

    @Column(name = "DATETIME")
    private LocalDateTime dateTime;

    public BoxHistory(User user, String operation, LocalDateTime dateTime) {
        this.user = user;
        this.operation = operation;
        this.dateTime = dateTime;
    }
}
