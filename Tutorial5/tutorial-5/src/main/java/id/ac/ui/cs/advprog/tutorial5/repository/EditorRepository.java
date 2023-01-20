package id.ac.ui.cs.advprog.tutorial5.repository;

import id.ac.ui.cs.advprog.tutorial5.model.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Integer> {
    Editor findById(int id);
}
