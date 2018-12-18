package es.hubiqus.inventario.controller.alumno;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.hubiqus.inventario.model.Alumno;
import es.hubiqus.inventario.service.AlumnoSvc;

@Controller
public class AlumnoLogin {

	private static final String SUCCESS = "alumnologin";
	private static final String MSG_ERROR = "usuario.login.error";

	@Autowired
	private AlumnoSvc svc;

	@Autowired
	private HttpSession session;

	// Metodo que manda a la jsp de login para el alumno
	@RequestMapping(value = "/alumnoidentificar", method = RequestMethod.GET)
	public String identificar(@ModelAttribute Alumno alumno, Model model) {

		return SUCCESS;

	}

	//Metodo que comprueba si el login es correcto y en ese caso, de acceso al
	//menu de alumno.
	@RequestMapping(value = "/alumnologin", method = RequestMethod.POST)
	public String execute(@Valid Alumno alumno, BindingResult result, Model model) {
		try {
			// No tiene en cuenta validación del resto de campos (registro)
			if (result.getFieldError("user") != null || result.getFieldError("pass") != null) {
				return "alumnologin";
			} else {
				// Buscamos el alumno por su usuario y contrasena.
				Alumno res = svc.buscarPorUsuarioyContrasena(alumno.getUser(), alumno.getPass());
				if (res == null) {
					// Asignamos el error al id para filtrado en formulario
					result.rejectValue("id", MSG_ERROR);
					return "alumnologin";
				} else {

					// Si no hay errores, se le lleva al menu de alumnos.
					session.setAttribute("alumno", res);
					return "menualumno";
				}
			}
		} catch (Exception ex) {
			// Asignamos el error al id para filtrado en formulario
			result.rejectValue("id", MSG_ERROR);
			return "alumnologin";
		}
	}

	@RequestMapping(value = "/alumnomenu", method = RequestMethod.GET)
	public String irmenu(@ModelAttribute Alumno alumno, Model model) {

		// Nos manda a la jsp de menu para el alumno
		return "menualumno";

	}

}
