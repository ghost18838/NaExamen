package com.company.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "pacients")
public class Pacient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Column
    private String fio;
    @NonNull
    @Column(name = "Date_of_birthday")
    private Date dateOfBirthday;
    @NonNull
    @Column
    private String mainImagePath;

    @OneToMany(mappedBy = "pacient")
    Set<Reference> references;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "doctors_pacients",
            joinColumns = @JoinColumn(name = "Doctors_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "Pacients_id", referencedColumnName = "id")
    )
    Set<Doctor> doctors;


    @Override
    public String toString() {
        return "Pacient{" +
                "id=" + id +
                ", fio='" + fio + '\'' +
                ", dateOfBirthday=" + dateOfBirthday +
                ", mainImagePath='" + mainImagePath + '\'' +
                '}';
    }
}
