package id.ac.ui.cs.advprog.tutorial9.repository;

import id.ac.ui.cs.advprog.tutorial9.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findById(int id);
}
