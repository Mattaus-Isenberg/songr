package com.echokinetic.songr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrackRepository extends JpaRepository<Track, Long>
{
    public List<Track> findByAlbum(Album album);
}
