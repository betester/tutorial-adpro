package id.ac.ui.cs.tutorial6.repository;

import id.ac.ui.cs.tutorial6.model.playlist.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, String> {
}
