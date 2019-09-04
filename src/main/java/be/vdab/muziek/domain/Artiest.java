package be.vdab.muziek.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "artiesten")
public class Artiest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String naam;


    protected Artiest() {
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
