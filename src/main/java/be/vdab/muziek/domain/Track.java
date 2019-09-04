package be.vdab.muziek.domain;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Embeddable
public class Track implements Serializable {
    private static final long serialVersionUID = 1L;

    private String naam;
    private BigDecimal tijd;


    protected Track() {
    }

    public String getNaam() {
        return naam;
    }

    public BigDecimal getTijd() {
        return tijd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return Objects.equals(naam, track.naam) &&
                Objects.equals(tijd, track.tijd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(naam, tijd);
    }
}
