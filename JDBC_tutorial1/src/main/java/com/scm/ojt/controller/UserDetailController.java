package com.scm.ojt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.ojt.model.UserDetail;
import com.scm.ojt.service.UserDetailService;

public class UserDetailController {
	@Autowired
	private UserDetailService userDetailService;

	@RequestMapping(value = "user/{id}", method = RequestMethod.GET)
	public String getuserDetail(@PathVariable int id, ModelMap userModel) {
		userModel.addAttribute("userDetail", userDetailService.getUserDetail(id));
		return "user";
	}

	@RequestMapping(value = "users", method = RequestMethod.GET)
	public String getusersDetails(ModelMap userModel) {
		userModel.addAttribute("userDetail", userDetailService.getAllUserDetail());
		return "users";
	}

	@RequestMapping(value = "addUser")
	public String addPage() {
		return "add";
	}

	@RequestMapping(value = "add/user", method = RequestMethod.POST)
	public String addUser(@RequestParam(value = "fname", required = true) String fname,
			@RequestParam(value = "lname", required = true) String lname,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "dob", required = true) String dob, ModelMap userModel) {
		UserDetail userDetail = new UserDetail();
		userDetail.setFirstName(fname);
		userDetail.setLastName(lname);
		userDetail.setEmail(email);
		userDetail.setDob(dob);
		int resp = userDetailService.addUserDetail(userDetail);
		if (resp > 0) {
			userModel.addAttribute("msg", "User with id: " + resp + " added successfully.");
			userModel.addAttribute("userDetail", userDetailService.getAllUserDetail());
			return "users";
		} else {
			userModel.addAttribute("msg", "User addition failed");
			return "add";
		}
	}

	@RequestMapping(value="delete/user/{id}", method=RequestMethod.GET)
	public String deleteUser(@PathVariable("id") int id, ModelMap userModel) {
		int resp=userDetailService.deleteUserDetail(id);
		if(resp>0) {
			userModel.addAttribute("msg", "User with id: " + resp + " deleted successfully.");
		}else {
			userModel.addAttribute("msg", "User deletion failed");
		}
		return "users";
	}

	@RequestMapping(value = "update/user/{id}", method = RequestMethod.GET)
	public String updatePage(@PathVariable("id") int id, ModelMap userModel) {
		userModel.addAttribute("id", id);
		userModel.addAttribute("userDetail", userDetailService.getUserDetail(id));
		return "update";
	}

	@RequestMapping(value = "update/user", method = RequestMethod.POST)
	public String updateUser(@RequestParam int id, @RequestParam(value = "fname", required = true) String fname,
			@RequestParam(value = "lname", required = true) String lname,
			@RequestParam(value = "email", required = true) String email,
			@RequestParam(value = "dob", required = true) String dob, ModelMap userModel) {
		UserDetail userDetail = new UserDetail();
		userDetail.setId(id);
		userDetail.setFirstName(fname);
		userDetail.setLastName(lname);
		userDetail.setEmail(email);
		userDetail.setDob(dob);
		int resp = userDetailService.updateUserDetail(userDetail);
		userModel.addAttribute("id", id);
		if (resp > 0) {
			userModel.addAttribute("msg", "User with id: " + resp + " updated successfully.");
			userModel.addAttribute("userDetail", userDetailService.getAllUserDetail());
			return "users";
		} else {
			userModel.addAttribute("msg", "User updation failed");
			userModel.addAttribute("userDetail", userDetailService.getUserDetail(id));
			return "update";
		}
	}
}
