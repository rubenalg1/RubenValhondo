package es.hubiqus.inventario.controller.profesor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.hubiqus.inventario.model.Asignacion;

@Controller
public class EjercicioParaAsignacion {

	private static final String SUCCESS = "ejercicioasignacion";

	//Metodo que lleva a la pagina donde se modificara el ejercicio de la asignacion
	//que tiene dicho id.
	@RequestMapping(value = "/ejercicioasignacion", method = RequestMethod.GET)
	public String execute(@ModelAttribute Asignacion asignacion, @RequestParam int id, Model model) {

		model.addAttribute("id");

		return SUCCESS;

	}
}
