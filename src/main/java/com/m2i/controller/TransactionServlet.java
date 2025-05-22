package com.m2i.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.m2i.dto.TransactionCreateDTO;
import com.m2i.dto.TransactionDTO;
import com.m2i.model.TransactionType;
import com.m2i.service.TransactionService;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/transactions")
public class TransactionServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
    private TransactionService transactionService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TransactionDTO> transactions = transactionService.getAllTransactions();
        req.setAttribute("transactions", transactions);
        req.getRequestDispatcher("/WEB-INF/views/transactionList.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> erreurs = new ArrayList<>();

        String sourceStr = req.getParameter("sourceAccountId");
        String targetStr = req.getParameter("targetAccountId");
        String montantStr = req.getParameter("montant");
        String typeStr = req.getParameter("type");

        Long sourceId = null;
        Long targetId = null;
        double montant = 0;
        TransactionType type = null;

        try {
            sourceId = Long.parseLong(sourceStr);
        } catch (Exception e) {
            erreurs.add("ID du compte source invalide.");
        }

        try {
            targetId = Long.parseLong(targetStr);
        } catch (Exception e) {
            erreurs.add("ID du compte cible invalide.");
        }

        try {
            montant = Double.parseDouble(montantStr);
            if (montant <= 0) {
                erreurs.add("Le montant doit être supérieur à zéro.");
            }
        } catch (Exception e) {
            erreurs.add("Montant invalide.");
        }

        try {
            type = TransactionType.valueOf(typeStr);
        } catch (Exception e) {
            erreurs.add("Type de transaction invalide.");
        }

        if (!erreurs.isEmpty()) {
            req.setAttribute("erreurs", erreurs);
            req.setAttribute("sourceAccountId", sourceStr);
            req.setAttribute("targetAccountId", targetStr);
            req.setAttribute("montant", montantStr);
            req.setAttribute("type", typeStr);
            req.getRequestDispatcher("/WEB-INF/views/transactionForm.jsp").forward(req, resp);
            return;
        }

        TransactionCreateDTO dto = new TransactionCreateDTO(sourceId, targetId, montant, type);
        transactionService.createTransaction(dto);
        resp.sendRedirect("transactions");
    }

}
