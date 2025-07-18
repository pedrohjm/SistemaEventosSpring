package web.eventos361.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.FragmentsRendering;

import io.github.wimdeblauwe.htmx.spring.boot.mvc.HxRequest;

@Controller
public class IndexController {

	@GetMapping(value = {"/", "/index.html"} )
	public String index() {
		return "index";
	}

	@HxRequest
	@GetMapping(value = { "/", "/index.html" })
	public View indexHTMX() {
		return FragmentsRendering
				.with("index :: conteudo")
				.fragment("/layout/fragments/header :: usuariologinlogout")
				.build();
	}

	@HxRequest
	@GetMapping("/login")
	public String login() {
		return "login :: formulario";
	}
	
	@HxRequest
	@GetMapping("/menu-lateral")
	public String menuLateralHTMX() {
		return "layout/fragments/sidebar :: sidebar";
	}
}