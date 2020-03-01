package pu.fmi.web.hangman;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "/WEB-INF/jsp/index.jsp";
	}

}
