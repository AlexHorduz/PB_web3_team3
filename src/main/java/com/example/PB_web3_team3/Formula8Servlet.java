package com.example.PB_web3_team3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import static java.lang.Math.*;

@WebServlet(name = "formula8Servlet", value = "/formula8")
public class Formula8Servlet extends HttpServlet {
    public static double from_a = 0, to_a = 0, step_a = 1,
                         from_b = 0, to_b = 0, step_b = 1,
                         from_c = 0, to_c = 0, step_c = 1,
                         from_d = 0, to_d = 0, step_d = 1;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private double calculate(double a, double b, double c, double d) {
        double answer = (5 * a / sin(a)) + sqrt(tanh(abs(b) * c) / Math.log(d));
        return answer;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String from_a_param = request.getParameter("from_a");
        String from_b_param = request.getParameter("from_b");
        String from_c_param = request.getParameter("from_c");
        String from_d_param = request.getParameter("from_d");
        String to_a_param = request.getParameter("to_a");
        String to_b_param = request.getParameter("to_b");
        String to_c_param = request.getParameter("to_c");
        String to_d_param = request.getParameter("to_d");
        String step_a_param = request.getParameter("step_a");
        String step_b_param = request.getParameter("step_b");
        String step_c_param = request.getParameter("step_c");
        String step_d_param = request.getParameter("step_d");

        try {
            double from_a = Double.parseDouble(from_a_param);
            double from_b = Double.parseDouble(from_b_param);
            double from_c = Double.parseDouble(from_c_param);
            double from_d = Double.parseDouble(from_d_param);
            double to_a = Double.parseDouble(to_a_param);
            double to_b = Double.parseDouble(to_b_param);
            double to_c = Double.parseDouble(to_c_param);
            double to_d = Double.parseDouble(to_d_param);
            double step_a = Double.parseDouble(step_a_param);
            double step_b = Double.parseDouble(step_b_param);
            double step_c = Double.parseDouble(step_c_param);
            double step_d = Double.parseDouble(step_d_param);
            if (step_a == 0 || step_b == 0 || step_c == 0 || step_d == 0) {
                throw new IllegalArgumentException();
            }

            Formula8Servlet.from_a = from_a;
            Formula8Servlet.from_b = from_b;
            Formula8Servlet.from_c = from_c;
            Formula8Servlet.from_d = from_d;
            Formula8Servlet.to_a = to_a;
            Formula8Servlet.to_b = to_b;
            Formula8Servlet.to_c = to_c;
            Formula8Servlet.to_d = to_d;
            Formula8Servlet.step_a = step_a;
            Formula8Servlet.step_b = step_b;
            Formula8Servlet.step_c = step_c;
            Formula8Servlet.step_d = step_d;


            ArrayList<Double> results = new ArrayList<>();
            for (double a = from_a; a <= to_a; a += step_a) {
                for (double b = from_b; b <= to_b; b += step_b) {
                    for (double c = from_c; c <= to_c; c += step_c) {
                        for (double d = from_d; d <= to_d; d += step_d) {
                            results.add(calculate(a, b, c, d));
                        }
                    }
                }
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
            request.setAttribute("results", results);
            request.setAttribute("numOfFormula", 8);
            request.getRequestDispatcher("WEB-INF/result.jsp").forward(request, response);

        } catch (NumberFormatException e) {
            try(PrintWriter out = response.getWriter()) {
                out.println("<html><body>");
                out.println("<h1>Error! Please, enter only numbers</h1>");
                out.println("<form action=\"formula\" method=\"GET\">");
                out.println("<input name=\"numOfFormula\" type=\"hidden\" value=\"8\">");
                out.println("<input type=\"submit\" value=\"Back\">");
                out.println("</form>");
                out.println("</body></html>");
            }
        } catch (IllegalArgumentException e) {
            try(PrintWriter out = response.getWriter()) {
                out.println("<html><body>");
                out.println("<h1>Step can not be equal to 0</h1>");
                out.println("<form action=\"formula\" method=\"GET\">");
                out.println("<input name=\"numOfFormula\" type=\"hidden\" value=\"8\">");
                out.println("<input type=\"submit\" value=\"Back\">");
                out.println("</form>");
                out.println("</body></html>");
            }
        }
    }
}
