package be.vdab.muziek.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "albums")
@NamedEntityGraph(name = Album.MET_ARTIST,
attributeNodes =  @NamedAttributeNode("artiest"))
public class Album implements Serializable {
    public static final long serialVersionUID = 1L;
    public static final String MET_ARTIST = "Album.metArtist";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String naam;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artiestid")
    private Artiest artiest;

    @ElementCollection
    @CollectionTable(name = "tracks", joinColumns = @JoinColumn(name = "albumid"))
    private Set<Track> tracks = new LinkedHashSet<>();



    protected Album() {
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Artiest getArtiest() {
        return artiest;
    }

    public Set<Track> getTracks() {
        return Collections.unmodifiableSet(tracks);
    }

    public BigDecimal getTijd(){
        return tracks.stream().map(track -> track.getTijd())
                .reduce(BigDecimal.ZERO, (vorigTotaal, huidigeWaarde) ->
                vorigTotaal.add(huidigeWaarde));
    }
}
