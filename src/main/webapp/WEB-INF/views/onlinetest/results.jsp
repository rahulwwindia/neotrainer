<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/onlineTest.css"
	rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Candidate Result</title>
</head>
<body>
	<div class="div-result-container">
		<br>
		<!-- <div style="margin-left: 15%; width: 75%;"> -->
		<table
			style="margin-left: 10%; width: 80%; border: 3px solid #82CAFF;"
			cellspacing="7">

			<tr style="background-color: #82CAFF;">
				<td><h2>Marks:</h2></td>
				<td><h2>${marks }%</h2></td>
			</tr>
			<tr>
				<td>Total number of questions :</td>
				<td>${totQuest }</td>
			</tr>
			<tr>
				<td>Number of answered questions :</td>
				<td>${ans }</td>
			</tr>
			<tr>
				<td>Number of un-answered questions :</td>
				<td>${unans }</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href=".htm"
					class="button">Exit</a></td>
			</tr>
		</table>
		<!-- </div> -->
		<br>
		<table
			style="margin-left: 10%; width: 80%; border: 3px solid #B9FFE1;"
			cellspacing="7">
			<tr style="background-color: #B9FFE1;">
				<td colspan="2"><h3>Feedback</h3></td>

			</tr>
			<tr>
				<td>Quality of Test:</td>
				<td><select><option>--Select--</option>
						<option>Excellent</option>
						<option>Very Good</option>
						<option>Good</option>
						<option>Average</option>
						<option>Poor</option></select></td>
			</tr>
			<tr>
				<td>Difficulty of Test:</td>
				<td><select><option>--Select--</option>
						<option>5</option>
						<option>4</option>
						<option>3</option>
						<option>2</option>
						<option>1</option></select></td>
			</tr>
			<tr>
				<td>Comments :</td>
			</tr>
			<tr>
				<td colspan="2"><textarea rows=5 col="15" id="feedbackta"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><a href="#"
					class="button">Submit Feedback</a></td>
			</tr>
		</table>
	</div>
</body>
</html>