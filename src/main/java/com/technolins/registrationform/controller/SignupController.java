package com.technolins.registrationform.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.technolins.registrationform.dto.Gender;
import com.technolins.registrationform.dto.SignupForm;
import com.technolins.registrationform.entity.User;
import com.technolins.registrationform.repository.UserRepository;
import com.technolins.registrationform.service.SignupService;
import com.technolins.registrationform.util.Ajax;
import com.technolins.registrationform.util.MessageHelper;

@Controller
public class SignupController {
	private static final String SIGNUP_VIEW_NAME = "signup";

	@Autowired
	SignupService signUpService;
	@Autowired
	UserRepository userRepository;

	@ModelAttribute(name = "module")
	String module() {
		return "signup";
	}

	@ModelAttribute("listgender")
	public List<Gender> listGender() {

		return Arrays.asList(new Gender(0, "Female"), new Gender(1, "Male"));
	}

	@GetMapping("signup")
	String signup(Model model, @RequestHeader(value = "X-Requested-With", required = false) String requestedWith) {
		SignupForm form = new SignupForm();
		model.addAttribute(form);
		if (Ajax.isAjaxRequest(requestedWith)) {
			System.out.println("ajax");
			return SIGNUP_VIEW_NAME.concat(" :: signupForm");
		}
		model.addAttribute("enableSignup", false);
		model.addAttribute("enableLogin", true);
		return SIGNUP_VIEW_NAME;
	}

	@PostMapping("signup")
	public String save( @Valid @ModelAttribute SignupForm userDto, Errors errors, RedirectAttributes ra, Model model) throws Exception {
		System.out.println("userDto : "+userDto.toString());
		if (errors.hasErrors()) {
			System.out.println("error");
			MessageHelper.addErrorAttribute(ra, "error");
			return SIGNUP_VIEW_NAME;
		}
		try {
			if (signUpService.isExistByMobileNumber(userDto.getMobileNumber())) {
				System.out.println("phone");
				MessageHelper.addErrorAttribute(ra, "Mobile number is exist in database. Change another one!");
			}else if(signUpService.isExistByEmail(userDto.getEmail())) {
				System.out.println("phone");
				MessageHelper.addErrorAttribute(ra, "Email is exist in database. Try another one!");
			}else {
				User user = new User();
				BeanUtils.copyProperties(userDto, user);
				Date now = new Date();
				user.setId(1L);
				user.setDateOfBirth(now);
				user.setCreatedDate(now);
				user.setCreatedBy("SYSTEM");
				user.setCreatedTerminal("127.0.0.1");
				User saveNewUser=null;
				try {
					//					saveNewUser = signUpService.save(user);
					saveNewUser = userRepository.save(user);
				}catch (Exception e) {
					e.getStackTrace();
				}

				model.addAttribute("enableSignup", false);
				model.addAttribute("enableLogin", true);
				MessageHelper.addSuccessAttribute(ra, "success");
				System.out.println("saved: " + saveNewUser);
			}
		}
		catch (Exception e) {
			MessageHelper.addErrorAttribute(ra, "Error");
		}

		return "redirect:signup/";
	}

}
