package id.ac.ui.cs.tutorial6.repository;

import id.ac.ui.cs.tutorial6.model.song.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SongRepository extends JpaRepository<Song, String> {

}
