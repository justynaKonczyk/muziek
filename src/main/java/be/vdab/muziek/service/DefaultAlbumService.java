package be.vdab.muziek.service;

import be.vdab.muziek.domain.Album;
import be.vdab.muziek.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DefaultAlbumService implements AlbumService{

    private final AlbumRepository repository;

    public DefaultAlbumService(AlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Album> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public List<Album> findAll() {
        return repository.findAll();
    }
}
