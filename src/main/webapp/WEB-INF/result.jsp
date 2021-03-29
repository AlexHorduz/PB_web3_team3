<%@ page import="com.example.PB_web3_team3.Formula7Servlet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% int numOfFormula = (int)request.getAttribute("numOfFormula");
    ArrayList<Double> results = (ArrayList<Double>)request.getAttribute("results");
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

<html>
<head>
    <title>Results</title>
</head>
<body>
<img src="../../formula<%=numOfFormula%>.png" alt="<%=numOfFormula%>th formula image" border="2" height="150"/> <br> <br>

<table border="1" bordercolor="D2006B">

    <tr>
        <th>a</th>
        <th>b</th>
        <th>c</th>
        <th>d</th>
        <th>result</th>
    </tr>
<% int i = 0;
for (double a = from_a; a <= to_a; a += step_a) {
    for (double b = from_b; b <= to_b; b += step_b) {
        for (double c = from_c; c <= to_c; c += step_c) {
            for (double d = from_d; d <= to_d; d += step_d) {%>
    <tr>
        <td><%=a%></td>
        <td><%=b%></td>
        <td><%=c%></td>
        <td><%=d%></td>
        <td><%=results.get(i)%></td>
    </tr>
<%i++;}}}}%>
</table> <br>



<form action="formula" method="GET">
    <input name="numOfFormula" type="hidden" value="<%=numOfFormula%>">
    <input type="submit" value="Enter new values">
</form>

</body>
</html>
