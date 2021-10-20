package com.gizlo.ms.usuario.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// REDIRECCIONAMOS AL INDEX DEL CONTRATO
@Controller
public class HomeController {

	@RequestMapping("/")
	public String Index() {
		return "redirect:swagger-ui.html";
	}

}
