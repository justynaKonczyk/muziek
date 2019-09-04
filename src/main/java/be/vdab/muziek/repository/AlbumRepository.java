package be.vdab.muziek.repository;

import be.vdab.muziek.domain.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository {

    Optional<Album> findById(long id);
    List<Album> findAll();

}
