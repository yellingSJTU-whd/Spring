package com.example.web;

import com.example.exception.InsufficientMoneyException;
import com.example.exception.UnknownException;
import com.example.service.AccountService;
import com.example.service.impl.AccountServiceImpl;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet("/transfer")
public class AccountServlet extends HttpServlet {

    private AccountService accountService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fromActno = req.getParameter("fromActno");
        String toActno = req.getParameter("toActno");
        double money = Double.parseDouble(req.getParameter("money"));

        checkAccountService();
        try {
            accountService.transfer(fromActno, toActno, money);
            resp.sendRedirect(req.getContextPath() + "/success.html");
        } catch (InsufficientMoneyException e) {
            resp.sendRedirect(req.getContextPath() + "/insufficientMoney.html");
        } catch (UnknownException e) {
            resp.sendRedirect(req.getContextPath() + "/unknownError.html");
        }
    }

    private void checkAccountService() {
        if (accountService == null) {
            accountService = new AccountServiceImpl();
        }
    }
}
