package es.hubiqus.inventario.controller.alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.hubiqus.inventario.model.Asignacion;
import es.hubiqus.inventario.model.Profesor;
import es.hubiqus.inventario.service.ProfesorSvc;
import es.hubiqus.inventario.service.SvcException;

@Controller
public class QuedarConProfesor {

	@Autowired
	private ProfesorSvc svc;

	private static final String SUCCESS = "quedarconprofe";

	//Metodo que lleva al formulario para poner la fecha con el profesor
	//que ha seleccionado el alumno.
	@RequestMapping(value = "/quedar", method = RequestMethod.GET)
	public String execute(@ModelAttribute Asignacion asignacion, @ModelAttribute Profesor profesor, Model model) {

		// Se recupera el id del profesor que eligio el alumno.

		Integer id = profesor.getId();
		model.addAttribute("id", id);

		try {

			// Se busca dicho profesor por su id.
			profesor = svc.buscarPorId(id);
			model.addAttribute("profesor", profesor);

		} catch (SvcException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;

	}

}
