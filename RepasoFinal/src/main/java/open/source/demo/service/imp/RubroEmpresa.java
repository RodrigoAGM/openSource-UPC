package open.source.demo.service.imp;


import open.source.demo.entity.Rubro;
import open.source.demo.repository.i_RubroRepository;
import open.source.demo.service.i_RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean eliminar(int id) {
        boolean flag = false;

        try {
            repository.deleteById(id);
            flag = true;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return flag;
    }

    @Override
    public Optional<Rubro> buscarPorID(int id) {

        Optional<Rubro> objRubro = null;
        try {
            objRubro = repository.findById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return objRubro;
    }
}
