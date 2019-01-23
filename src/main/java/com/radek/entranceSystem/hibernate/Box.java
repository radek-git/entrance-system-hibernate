package com.radek.entranceSystem.hibernate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "boxes")
@Data
@NoArgsConstructor
public class Box implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_BOX")
    private Integer id;

    public Box(Integer id) {
        this.id = id;
    }
}
