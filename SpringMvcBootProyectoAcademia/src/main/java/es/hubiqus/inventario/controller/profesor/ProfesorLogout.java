package es.hubiqus.inventario.controller.profesor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.hubiqus.inventario.model.Profesor;

@Controller
public class ProfesorLogout {

	@Autowired
	private HttpSession session;

	//Metodo que cierra la sesion como alumno y nos manda a la pagina index.jsp.
	@RequestMapping(value = "/profesorcerrarsesion", method = RequestMethod.GET)
	public String identificar(@ModelAttribute Profesor profesor, Model model) {

		// Invalidamos la sesion.
		session.invalidate();

		// Nos manda a la jsp de inicio del portal.
		return "index";

	}

}
