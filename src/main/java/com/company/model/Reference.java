package com.company.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column(name = "Date_of_reference")
    private Date dateOfReference;
    @NonNull
    @Column
    private String diagnosis;
    @NonNull
    @Column
    private int cost;

    @ManyToOne
    @JoinColumn(name = "pacients_id")
    private Pacient pacient;

    @Override
    public String toString() {
        return "Reference{" +
                "id=" + id +
                ", dateOfReference=" + dateOfReference +
                ", diagnosis='" + diagnosis + '\'' +
                ", cost=" + cost +
                '}';
    }
}
