package open.source.demo.controller;

import open.source.demo.entity.Rubro;
import open.source.demo.entity.Software;
import open.source.demo.service.i_SoftwareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

public class SoftwareController {

    @Autowired
    i_SoftwareService service;

    @RequestMapping(value="/admin/software/listar", method=RequestMethod.GET)
    public String Listado(Model model) {
        model.addAttribute("software", service.listado());

        return "admin/software/software_listar";
    }

    @RequestMapping(value="/admin/software/agregar", method=RequestMethod.GET)
    public String agregar(Model model) {
        Software objRubro = new Software();
        model.addAttribute("software", objRubro);

        return "admin/software/software_agregar";
    }

    @RequestMapping(value="/admin/rubro/guardar", method=RequestMethod.POST)
    public String guardar(@ModelAttribute Software objSoftware, Model model, RedirectAttributes redirAtt) {
        boolean flag;
        flag = service.agregar(objSoftware);
        if(flag) {
            redirAtt.addFlashAttribute("mensaje", "Software Agregada!");
        }else {
            redirAtt.addFlashAttribute("error", "Software no agregada");
        }

        return "redirect:/admin/software/listar";
    }

    @RequestMapping(value="/admin/software/eliminar/{id}", method=RequestMethod.GET)
    public String eliminar(@PathVariable int id, RedirectAttributes redirAtt) {
        boolean flag = service.eliminar(id);
        if(flag) {
            redirAtt.addFlashAttribute("mensaje", "Software eliminada");
        }else {
            redirAtt.addFlashAttribute("error", "Ocurrió un error");
        }
        return "redirect:/admin/software/listar";
    }

    @RequestMapping(value="/admin/rubro/editar/{id}", method=RequestMethod.GET)
    public String editar(@PathVariable int id, Model model, RedirectAttributes redirAtt) {
        Optional<Software> obj = service.buscarPorID(id);

        if(!obj.isPresent()) {
            redirAtt.addFlashAttribute("error", "Rubro no existe");
            return "redirect:/admin/software/listar";
        }else {
            model.addAttribute("estudiante", obj);
            return "admin/software/rubro_editar";
        }
    }
}
