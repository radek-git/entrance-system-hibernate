package com.radek.entranceSystem.hibernate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "gates")
@Data
@NoArgsConstructor
public class Gate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_GATE")
    private Integer id;

    public Gate(Integer id) {
        this.id = id;
    }
}
