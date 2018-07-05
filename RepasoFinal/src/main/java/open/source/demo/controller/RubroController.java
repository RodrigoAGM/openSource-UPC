package open.source.demo.controller;

import open.source.demo.entity.Empresa;
import open.source.demo.entity.Rubro;
import open.source.demo.service.i_EmpresaService;
import open.source.demo.service.i_RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class RubroController {

    @Autowired
    i_RubroService service;

    @RequestMapping(value="/admin/rubro/listar", method=RequestMethod.GET)
    public String Listado(Model model) {
        model.addAttribute("rubros", service.listado());

        return "admin/rubro/rubro_listar";
    }

    @RequestMapping(value="/admin/rubros/agregar", method=RequestMethod.GET)
    public String agregar(Model model) {
        Rubro objRubro = new Rubro();
        model.addAttribute("rubro", objRubro);

        return "admin/rubro/rubro_agregar";
    }

    @RequestMapping(value="/admin/rubro/guardar", method=RequestMethod.POST)
    public String guardar(@ModelAttribute Rubro objRubro, Model model, RedirectAttributes redirAtt) {
        boolean flag;
        flag = service.agregar(objRubro);
        if(flag) {
            redirAtt.addFlashAttribute("mensaje", "Rubro Agregada!");
        }else {
            redirAtt.addFlashAttribute("error", "Rubro no agregada");
        }

        return "redirect:/admin/rubro/listar";
    }

    @RequestMapping(value="/admin/rubro/eliminar/{id}", method=RequestMethod.GET)
    public String eliminar(@PathVariable int id, RedirectAttributes redirAtt) {
        boolean flag = service.eliminar(id);
        if(flag) {
            redirAtt.addFlashAttribute("mensaje", "Rubro eliminada");
        }else {
            redirAtt.addFlashAttribute("error", "Ocurrió un error");
        }
        return "redirect:/admin/rubro/listar";
    }

    @RequestMapping(value="/admin/rubro/editar/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable int id, Model model, RedirectAttributes redirAtt) {
        Optional<Rubro> obj = service.buscarPorID(id);

        if(!obj.isPresent()) {
            redirAtt.addFlashAttribute("error", "Rubro no existe");
            return "redirect:/admin/rubro/listar";
        }else {
            model.addAttribute("estudiante", obj);
            return "admin/rubro/rubro_editar";
        }
    }
}
