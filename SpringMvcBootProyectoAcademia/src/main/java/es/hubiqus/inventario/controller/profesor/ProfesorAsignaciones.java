package es.hubiqus.inventario.controller.profesor;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.hubiqus.inventario.model.Profesor;
import es.hubiqus.inventario.service.AsignacionSvc;

@Controller
public class ProfesorAsignaciones {

	private static final String ATT_LISTA = "lista";
	private static final String ATT_ERROR = "error";

	private static final String SUCCESS = "asignacionesprofesor";
	private static final String ERROR = "error";

	@Autowired
	private AsignacionSvc svc;

	@Autowired
	private HttpSession session;

	// Metodo con el que profesor ve sus asignaciones llevandolo
	// a una pagina donde salgan todas.

	@RequestMapping(value = "/profesorasignaciones", method = RequestMethod.GET)
	public String execute(Model model) {

		try {
			Profesor profesor = (Profesor) session.getAttribute("profesor");
			model.addAttribute(ATT_LISTA, svc.verAsignacionesPorProfesor(profesor));
			return SUCCESS;

		} catch (Exception e) {
			model.addAttribute(ATT_ERROR, e);
			return ERROR;
		}
	}
}
