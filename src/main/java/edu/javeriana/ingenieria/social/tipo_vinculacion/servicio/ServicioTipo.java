package edu.javeriana.ingenieria.social.tipo_vinculacion.servicio;

import edu.javeriana.ingenieria.social.tipo_vinculacion.dominio.Tipo;
import edu.javeriana.ingenieria.social.tipo_vinculacion.repositorio.RepositorioTipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ServicioTipo {
    @Autowired
    private RepositorioTipo repositorio;

    public List<Tipo> obtenerTipos(){
        return repositorio.findAll();
    }

    public List<Tipo> obtenerTipos(Integer asignatura){
        return repositorio.findAllByAsignatura(asignatura);
    }

    public List<Tipo> obtenerTipos(String descripcion){
        return repositorio.findAllByDescripcion(descripcion);
    }

    public Tipo obtenerTipo(Integer id){
        return repositorio.findById(id).orElse(null);
    }

    public Tipo obtenerTipoPorCodigo(Integer codigo){
        return repositorio.findOneByCodigo(codigo);
    }

    public Tipo crearTipo(Tipo tipo){
        return repositorio.save(tipo);
    }

    public Tipo actualizarTipo(Integer id, Tipo tipo){
        if(repositorio.findById(id).orElse(null) == null){
            return null;
        }
        tipo.setId(id);
        return repositorio.save(tipo);
    }

    public Tipo borrarTipo(Integer id){
        Tipo aux = repositorio.findById(id).orElse(null);
        if(aux == null){
            return aux;
        }
        repositorio.delete(aux);
        return aux;
    }

    public boolean tipoExiste(Integer id){
        return repositorio.existsById(id);
    }

    public boolean tipoExistePorCodigo(Integer codigo){
        return repositorio.existsByCodigo(codigo);
    }

    public boolean tipoExiste(Tipo tipo){
        List<Tipo> tipos = obtenerTipos(tipo.getAsignatura());
        for(Tipo t : tipos){
            if(Objects.equals(t.getDescripcion(), tipo.getDescripcion())){
                return true;
            }
        }
        return false;
    }
}
