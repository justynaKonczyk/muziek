package be.vdab.muziek.repository;

import be.vdab.muziek.domain.Album;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import java.util.List;
import java.util.Optional;

@Repository
public class JPAAlbumRepository implements AlbumRepository{

    private final EntityManager manager;

    public JPAAlbumRepository(EntityManager manager) {
        this.manager = manager;
    }


    @Override
    public Optional<Album> findById(long id) {
        return Optional.ofNullable(
                manager.find(Album.class, id));
    }

    @Override
    public List<Album> findAll() {
        return manager.createNamedQuery("Album.findAll", Album.class)
                .setHint("javax.persistence.loadgraph",
                        manager.createEntityGraph(Album.MET_ARTIST))
                .getResultList();
    }
}
