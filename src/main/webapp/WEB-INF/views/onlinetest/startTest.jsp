<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/onlineTest.css" />
<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/onlineTest.js"></script>

<script type="text/javascript">
	$(document).ready(function() {
		var tot = '${fn:length(questhm)}';
		$("#total").val(tot);
	});
	function checkAll() {
		$(".v").text("");
		var map = {};
		//alert("map: "+map);
		var no = '${fn:length(questhm)}';
		//var count = 0;
		var flag = 0;
		for ( var i = 1; i <= no; i++) {
			//count++;
			var length = $('input[name=optionAns' + i + ']:radio:checked').length;
			if (length == 0) {
				$("#q" + i).text(" * Please select answer!");
				flag++;
				//return false;
			}
			//var answer = document.getElementById("optionAns" + i).value;
			var question = document.getElementById("questId" + i).value;
			var answer = $('input[name=optionAns' + i + ']:radio:checked')
					.val();
			//alert("yashvi" + answer + " question: " + question);

			map[question] = answer;

		}

		//alert("map: "+map);
		console.log("map : " + JSON.stringify(map));
		$("#testMap").val(JSON.stringify(map));
		if (flag != 0) {
			var r = confirm("You have answered ->" + (no - flag)
					+ " questions!\n Woud you like to submit!");
			if (r == false)
				return false;
		}
		return true;
	}
	function autoSubmit() {
		alert("Your time is up ! Let's see the Result & Statistics of the Test.");
		var map = {};
		var no = '${fn:length(questhm)}';

		//alert("auto submit : "+no);
		for ( var i = 1; i <= no; i++) {
			var question = document.getElementById("questId" + i).value;
			var answer = $('input[name=optionAns' + i + ']:radio:checked')
					.val();
			//alert("yashvi" + answer + " question: " + question);
			map[question] = answer;
		}
		console.log("map : " + JSON.stringify(map));
		$("#testMap").val(JSON.stringify(map));
		document.testForm.submit();
	}
</script>
</head>
<body>
	<div name="logoImg" style="float: left; width: 236px; margin-left: 12%;">
		<img src="<%=request.getContextPath()%>/resources/images/logo.png"
			width="213px">
	</div>

	<div id="countdown" style="width:220px">Timer: &nbsp;&nbsp;</div>
	<form action="submitTest.htm" method="post" name="testForm">
		<table width="100%" cellspacing="0" cellpadding="0" border="0">
			<tbody>
				<tr>
					<td width="50%" valign="middle">
						<h1 style="margin-left: 0;"></h1>
					</td>
					<td align="right" width="50%" valign="middle">
						<!-- <span
						style="color: rgb(128, 128, 128);" id="idTimerSpan">Time
							Left: <b id="idTimerLCD">00:19:13</b>
					</span> -->
					</td>
				</tr>
			</tbody> 
		</table>
		<div class="div-tabs-container">
			<table cellspacing="0" cellpadding="0" border="0">
				<tbody>
					<tr>
						<td width="60%" valign="top">
							<div style="width: 910px; display: block;"
								class="div-tab-container" id="divTabContent">
								<div class="bix-div-container">

									<c:forEach items="${questhm}" var="hmquest" varStatus="i">

										<table width="100%" cellspacing="0" cellpadding="0" border="0"
											class="bix-tbl-container">
											<tbody>

												<tr>
													<td align="left" valign="top" rowspan="2"
														class="bix-td-qno jq-qno-645">${i.count}.</td>
													<td class="bix-td-qtxt"><p style="margin-top: 0px;">
															${hmquest.key.questDesc}<span style="color: red;"
																id="q${i.count}" class="v">&nbsp;</span>
														</p> <input type="hidden" name="questId${i.count}"
														id="questId${i.count}" value="${hmquest.key.questId}" /></td>
												</tr>

												<tr>
													<td valign="top" class="bix-td-miscell"><table
															width="100%" cellspacing="0" cellpadding="0" border="0"
															id="tblOption_645" class="bix-tbl-options">
															<tbody>

																<c:forEach items="${hmquest.value}" var="opt"
																	varStatus="j">
																	<c:if test="${!j.last}">
																		<tr>
																			<td width="1%" nowrap="nowrap" id="tdOptionNo_A_645"
																				class="bix-td-option bix-td-radio"><input
																				type="radio" name="optionAns${i.count}"
																				id="optionAns${i.count}"
																				class="result-option cls_645"
																				value="${opt.optionId}"></td>
																			<td width="1%" class="bix-td-option" valign="top">${j.count}.</td>
																			<td width="-moz-fit-content;" id="tdOptionDt_A_645"
																				class="bix-td-option" valign="top"><table
																					cellspacing="0" cellpadding="0" border="0">
																					<tbody>
																						<tr>
																							<td class="bix-inner-td-option">
																								<table cellspacing="0" cellpadding="0"
																									class="ga-tbl-answer">
																									<tbody>
																										<tr align="center" class="ga-tr-divident">
																											<td>${opt.optionDesc}</td>
																									</tbody>
																								</table>
																							</td>
																							<td valign="middle"
																								style="display: none; padding-left: 10px;"
																								class="jq-img-answer" id="tdAnswerIMG_A_645"><img
																								alt="" src="/_files/images/website/wrong.gif">
																							</td>
																						</tr>
																					</tbody>
																				</table></td>
																		</tr>
																	</c:if>
																</c:forEach>

															</tbody>
														</table></td>
												</tr>
											</tbody>
										</table>
									</c:forEach>

								</div>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<input type="hidden" id="testMap" name="testMap" /> <input
			type="hidden" id="total" name="total" />
		<div align="center" class="tp-div-submit">
			<input align="middle" type="submit" id="btnSubmitTest"
				value="Submit Test" class="button" onclick="return checkAll();" />
		</div>
	</form>
</body>
</html>



