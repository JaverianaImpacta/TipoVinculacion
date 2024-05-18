package edu.javeriana.ingenieria.social.tipo_vinculacion.repositorio;

import edu.javeriana.ingenieria.social.tipo_vinculacion.dominio.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioTipo extends JpaRepository<Tipo, Integer> {
    List<Tipo> findAllByAsignatura(Integer asignatura);

    boolean existsByCodigo(Integer codigo);

    Tipo findOneByCodigo(Integer codigo);

    List<Tipo> findAllByDescripcion(String descripcion);
}
