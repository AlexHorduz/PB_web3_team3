<%@ page import="com.example.PB_web3_team3.Formula7Servlet" %>
<%@ page import="com.example.PB_web3_team3.Controller" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    int numOfFormula = (int)request.getAttribute("numOfFormula");
    double from_a = (double)request.getAttribute("from_a");
    double from_b = (double)request.getAttribute("from_b");
    double from_c = (double)request.getAttribute("from_c");
    double from_d = (double)request.getAttribute("from_d");
    double to_a = (double)request.getAttribute("to_a");
    double to_b = (double)request.getAttribute("to_b");
    double to_c = (double)request.getAttribute("to_c");
    double to_d = (double)request.getAttribute("to_d");
    double step_a = (double)request.getAttribute("step_a");
    double step_b = (double)request.getAttribute("step_b");
    double step_c = (double)request.getAttribute("step_c");
    double step_d = (double)request.getAttribute("step_d");

%>

<!DOCTYPE html>
<html>
<head>
    <title>Formula <%=numOfFormula%></title>
</head>
<body>
<h1>Enter the numbers to calculate the following formula</h1>
<img src="../../formula<%=numOfFormula%>.png" alt="<%=numOfFormula%>th formula image" border="2" height="150"/>
<br/>
<br/>
<form action="formula<%=numOfFormula%>" method="POST">
    <%@ include file="jspf/inputs.jspf"%>
    <input name="numOfFormula" type="hidden" value="<%=numOfFormula%>"/>
    <input type="submit" value="Calculate"/>
</form> <br> <br>
<form action="index.jsp" method="GET">
    <input type="submit" value="Main menu"/>
</form>
</body>
</html>