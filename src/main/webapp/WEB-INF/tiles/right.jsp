<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<div class="content-right">
	<div class="mainmenu">

		<sec:authorize access="hasRole('ROLE_ADMIN')">
			<h2 class="sidebar1">Admin menu</h2>
			<ul>   
				<li><a href="testHome.htm" style="color: grey">Set Test
						Questions</a></li>
				<li><a href="viewResult.htm" style="color: grey">View
						Candidate Results</a></li>
				<li><a href="addNewTutorial.htm" style="color: grey">Add
						Technology Tutorial</a></li>
				<li><a href="dash.htm" style="color: grey">DashBoard
						Settings</a></li>
				<li><a href="register.htm" style="color: grey">Add New User</a></li>
								<li><a href="uploadDemoAppForm.htm" style="color: grey">Upload
						Demo App</a></li>

			</ul>
		</sec:authorize>

		<%-- <sec:authorize access="hasRole('ROLE_USER')">
		<h2 class="sidebar2">Main menu</h2>
			<ul>
				<li>Link1</li>
				<li>Link2</li>
				<li>Link3</li>
			</ul></sec:authorize> --%>
	</div>
	<div class="contact">
		<h2 class="sidebar2">Contact</h2>
		<div class="contact-detail">
			<table>
				<tr>
					<td class="grey"><strong> Mumbai (Head Office)</strong></td>
					</td>
				</tr>
			</table>
			<table>
				<tr>
					<td width="30%"><strong>Address :</strong></td>
					<td width="70%" align="left">NeoSOFT Technologies</td>
				</tr>
				<tr>
					<td width="30%"></td>
					<td width="70%" align="left">4th Floor, The Ruby,</td>
				</tr>
				<tr>
					<td width="30%"></td>
					<td width="70%" align="left">Senapati Bapat Marg,Dadar(West)</td>
				</tr>
				<tr>
					<td width="30%"></td>
					<td width="70%" align="left">Mumbai-400-028</td>
				</tr>
			</table>




			</p>
			<p>
				<strong>E-mail :</strong> &nbsp;&nbsp;&nbsp;india@neosofttech.com
			</p>
			<p>
				<strong>Phone :</strong> &nbsp;&nbsp;&nbsp;+91 22 40500600 <br>
		</div>
	</div>

	<div id="1" class="contact">

		<h2 class="sidebar2">Why Neosoft ?</h2>
		
		<div>

			<div class="mainmenu">

				<ul>
					<li>450+ Employee Strength</li>
					<li>16+ Years of Experience in IT</li>
					<li>5500+ Projects Developed Successfully</li>
					<li>CMMI Level 3</li>
					<li>Offices in USA and India</li>
					<li>Microsoft Certified Partner</li>
				</ul>
			</div>
		</div>








	</div>
</div>





