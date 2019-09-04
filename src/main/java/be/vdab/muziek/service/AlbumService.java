package be.vdab.muziek.service;

import be.vdab.muziek.domain.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {

    Optional<Album> findById(long id);
    List<Album> findAll();

}
