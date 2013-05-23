<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
Questions:
<input type="checkbox" id="selectAll"
	onclick="toggleChecked(this.checked)" />
Select all

<div id="scrollbar1">
	<div class="scrollbar" style="height: 371px;">
		<div class="track">
			<div class="thumb" style="margin-left: -6px;">
				<div class="end"></div>
			</div>
		</div>
	</div>
	<div class="viewport" style="background: none repeat scroll 0 0 white;">
		<div class="overview">
			<table cellpadding="7" id="questDiv">

				<c:forEach items="${questhm}" var="hmquest">
					<tr>
						<td><b><input type="checkbox" class="checkbox"
								name="questId" onclick="checkSelected(this.checked)"
								value="${hmquest.key.questId}" />${hmquest.key.questDesc}</b></td>
						<td></td>
						<td></td>
						<td></td>

					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<c:forEach items="${hmquest.value}" var="opt1" begin="0" end="5"
						varStatus="i">
						<c:if test="${i.last}">
							<c:set var="correct" value="${opt1.optionDesc}" scope="application">
							</c:set>
						</c:if>
					</c:forEach>
					<tr>
						<c:forEach items="${hmquest.value}" var="opt" varStatus="i">
							<c:if test="${!i.last}">
								<tr>
									<td>${i.count}. ${opt.optionDesc}</td>
								</tr>
								<c:if test="${correct==opt.optionDesc}">
								<c:set var="corr" value="${i.count}">
							</c:set>
								</c:if>
							</c:if>

							<c:if test="${i.last}">

								<tr>
									<td>Correct Option: ${corr }</td>
								</tr>
							</c:if>

						</c:forEach>
						<%-- <c:forEach items="${hmquest.value}" var="opt" varStatus="i" >

				<tr><td>${i.count}. ${opt.value.getOptionDesc() }</td></tr>
				<c:if test="${i.last}"><tr><td>yashvi</td></tr></c:if>
			
			</c:forEach> --%>
					</tr>
					<tr>
						<%-- <td>Correct Option:</td>
			<td>${hmquest.key.getCorrectOption()}</td> --%>
						<td></td>
						<td></td>
					</tr>
				</c:forEach>

			</table>
		</div>
	</div>
</div>
<div>
	<input type="submit" id="Edit Question" name="submit"
		value="Edit Question" class="button" style="margin-left: 373px;" /> <input
		type="submit" name="submit" value="Delete Question"
		id="Delete Question" class="button" />
</div>




