package open.source.demo.service.imp;


import open.source.demo.entity.Rubro;
import open.source.demo.repository.i_RubroRepository;
import open.source.demo.service.i_RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RubroEmpresa implements i_RubroService {

    @Autowired
    i_RubroRepository repository;

    @Override
    public List<Rubro> listado() {
        return repository.findAll();
    }

    @Override
    public boolean agregar(Rubro obj) {

        Rubro rubro = repository.save(obj);

        if(rubro == null){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean eliminar(int id) {
        return false;
    }

    @Override
    public Rubro buscarPorID(int id) {
        return null;
    }
}
