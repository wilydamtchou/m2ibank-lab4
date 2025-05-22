package com.m2i.controller;

import java.io.IOException;
import java.util.List;

import com.m2i.dto.AccountCreateDTO;
import com.m2i.dto.AccountDTO;
import com.m2i.model.AccountType;
import com.m2i.service.AccountService;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/accounts")
public class AccountServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
    private AccountService accountService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<AccountDTO> accounts = accountService.getAllAccounts();
        req.setAttribute("accounts", accounts);
        req.getRequestDispatcher("/WEB-INF/views/accountList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long clientId = Long.parseLong(req.getParameter("clientId"));
        AccountType type = AccountType.valueOf(req.getParameter("type"));

        AccountCreateDTO dto = new AccountCreateDTO(clientId, type);
        accountService.createAccount(dto);

        resp.sendRedirect("accounts");
    }
}
