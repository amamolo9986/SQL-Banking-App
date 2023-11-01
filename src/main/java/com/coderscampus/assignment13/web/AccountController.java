package com.coderscampus.assignment13.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.coderscampus.assignment13.domain.Account;
import com.coderscampus.assignment13.domain.User;
import com.coderscampus.assignment13.service.AccountService;
import com.coderscampus.assignment13.service.UserService;

@Controller
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	@Autowired
	private UserService userService;
	
	@PostMapping("/users/{userId}/accounts")
	public String postAccount(@PathVariable Long userId, User user) {
		Long accountId = accountService.addAccount(user);
		userService.saveUser(user);
		return "redirect:/users/" + userId + "/accounts/" + accountId;
	}

	@GetMapping("/users/{userId}/accounts/{accountId}")
	public String getOneAccount(ModelMap model, @PathVariable Long accountId) {
		Account account = accountService.findById(accountId);
		model.put("account", account);
		return "account";
	}
	
	@PostMapping("/users/{userId}/accounts/{accountId}")
	public String saveAccount(Account account) {
		accountService.saveAccount(account);
		return "redirect:/users/{userId}/accounts/{accountId}";
	}

}
