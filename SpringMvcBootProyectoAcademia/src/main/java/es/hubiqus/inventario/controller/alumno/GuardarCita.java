package es.hubiqus.inventario.controller.alumno;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.hubiqus.inventario.model.Asignacion;
import es.hubiqus.inventario.service.AsignacionSvc;

@Controller
public class GuardarCita {

	public static final String ATT_EXITO = "msg";

	public static final String SUCCESS = "menualumno";
	public static final String ERROR = "index";

	@Autowired
	private AsignacionSvc svc;

	@Autowired
	private MessageSource messageSource;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		// Se encarga de parsear las fechas correctamente cuando vienen de formulario
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	//Metodo que recibe una asignacion (cita) de una jsp y la guarda en las
	//asignaciones del alumno.
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String execute(@Valid Asignacion asignacion, BindingResult result, Model model, Locale locale) {
		try {
			// Comprobar si hay errores de entrada
			if (result.hasErrors()) {
				return ERROR;

			} else {

				// Se guarda la cita entre el alumno y el profesor que eligio
				svc.guardarAsignacion(asignacion);

				// Mensaje de éxito
				model.addAttribute(ATT_EXITO, messageSource.getMessage("mensaje.exito", null, locale));

				return SUCCESS;
			}
		} catch (Exception ex) {
			// Error
			result.reject("mensaje.error");
			return ERROR;
		}
	}

}
