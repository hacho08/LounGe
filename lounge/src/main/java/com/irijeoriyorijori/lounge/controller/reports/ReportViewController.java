package com.irijeoriyorijori.lounge.controller.reports;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReportViewController {

	@GetMapping("/report")
	public String report(@RequestParam(name="device") String device) {
		return "reports/reports";
	}

}
