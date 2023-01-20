package id.ac.ui.cs.advprog.asdos.asdos.repository;

import id.ac.ui.cs.advprog.asdos.asdos.model.Asdos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsdosRepository extends JpaRepository<Asdos, Integer> {

    Asdos getByCode(String code);
    List<Asdos> getByAsdosClass(String asdosClass);
}
