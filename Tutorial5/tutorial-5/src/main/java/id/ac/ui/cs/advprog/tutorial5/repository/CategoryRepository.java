package id.ac.ui.cs.advprog.tutorial5.repository;

import id.ac.ui.cs.advprog.tutorial5.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Category findById(int id);
    Category findByName(String name);
}
