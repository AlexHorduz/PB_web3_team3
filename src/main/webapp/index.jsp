<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulas</title>
</head>
<body>
<h1>Choose the formula to calculate </h1>
<form action="formula" method="GET">
    <input name="numOfFormula" type="hidden" value="7">
    <input type="image" src="formula7.png" alt="7th formula image" border="2" height="150">
</form>
<br/>
<br/>
<form action="formula" method="GET">
    <input name="numOfFormula" type="hidden" value="8">
    <input type="image" src="formula8.png" alt="8th formula image" border="2" height="150">
</form>
<br/>
<br/>
<form action="formula" method="GET">
    <input name="numOfFormula" type="hidden" value="9">
    <input type="image" src="formula9.png" alt="9th formula image" border="2" height="150">
</form>
</body>
</html>