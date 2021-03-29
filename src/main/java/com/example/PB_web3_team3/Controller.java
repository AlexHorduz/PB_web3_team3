package com.example.PB_web3_team3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Controller", value = "/formula")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numOfFormulaParam = request.getParameter("numOfFormula");
        if (numOfFormulaParam == null) {
            response.sendRedirect("index.jsp");
        } else {
            try {
                int numOfFormula = Integer.parseInt(numOfFormulaParam);

                if (numOfFormula < 7 || numOfFormula > 9) {
                    response.sendRedirect("index.jsp");
                } else {
                    double from_a, from_b, from_c, from_d,
                            to_a, to_b, to_c, to_d,
                            step_a, step_b, step_c, step_d;
                    if (numOfFormula == 7) {
                        from_a = Formula7Servlet.from_a;
                        from_b = Formula7Servlet.from_b;
                        from_c = Formula7Servlet.from_c;
                        from_d = Formula7Servlet.from_d;
                        to_a = Formula7Servlet.to_a;
                        to_b = Formula7Servlet.to_b;
                        to_c = Formula7Servlet.to_c;
                        to_d = Formula7Servlet.to_d;
                        step_a = Formula7Servlet.step_a;
                        step_b = Formula7Servlet.step_b;
                        step_c = Formula7Servlet.step_c;
                        step_d = Formula7Servlet.step_d;
                    } else if (numOfFormula == 8) {
                        from_a = Formula8Servlet.from_a;
                        from_b = Formula8Servlet.from_b;
                        from_c = Formula8Servlet.from_c;
                        from_d = Formula8Servlet.from_d;
                        to_a = Formula8Servlet.to_a;
                        to_b = Formula8Servlet.to_b;
                        to_c = Formula8Servlet.to_c;
                        to_d = Formula8Servlet.to_d;
                        step_a = Formula8Servlet.step_a;
                        step_b = Formula8Servlet.step_b;
                        step_c = Formula8Servlet.step_c;
                        step_d = Formula8Servlet.step_d;
                    } else {
                        from_a = Formula9Servlet.from_a;
                        from_b = Formula9Servlet.from_b;
                        from_c = Formula9Servlet.from_c;
                        from_d = Formula9Servlet.from_d;
                        to_a = Formula9Servlet.to_a;
                        to_b = Formula9Servlet.to_b;
                        to_c = Formula9Servlet.to_c;
                        to_d = Formula9Servlet.to_d;
                        step_a = Formula9Servlet.step_a;
                        step_b = Formula9Servlet.step_b;
                        step_c = Formula9Servlet.step_c;
                        step_d = Formula9Servlet.step_d;
                    }
                    request.setAttribute("from_a", from_a);
                    request.setAttribute("from_b", from_b);
                    request.setAttribute("from_c", from_c);
                    request.setAttribute("from_d", from_d);
                    request.setAttribute("to_a", to_a);
                    request.setAttribute("to_b", to_b);
                    request.setAttribute("to_c", to_c);
                    request.setAttribute("to_d", to_d);
                    request.setAttribute("step_a", step_a);
                    request.setAttribute("step_b", step_b);
                    request.setAttribute("step_c", step_c);
                    request.setAttribute("step_d", step_d);
                    request.setAttribute("numOfFormula", numOfFormula);
                    request.getRequestDispatcher("WEB-INF/formula.jsp").forward(request, response);
                }

            } catch (NumberFormatException e) {
                response.sendRedirect("index.jsp");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
