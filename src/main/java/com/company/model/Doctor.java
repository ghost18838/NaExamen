package com.company.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column
    private String fio;
    @NonNull
    @Column
    private String profession;
    @NonNull
    @Column
    private String categories;
    @NonNull
    @Column
    private String mainImagePath;

    @ManyToMany(mappedBy = "doctors")
    Set<Pacient> pacients;

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", profession='" + profession + '\'' +
                ", categories='" + categories + '\'' +
                ", mainImagePath='" + mainImagePath + '\'' +
                '}';
    }
}
