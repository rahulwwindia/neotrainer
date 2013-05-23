<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/menu.css"
	rel="stylesheet" />
<link type="text/css"
	href="<%=request.getContextPath()%>/resources/css/questions.css"
	rel="stylesheet" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jstl/sql_rt"%>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="<%=request.getContextPath()%>/resources/js/ckeditor.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//alert("add quest document ready.");
		$('.entry').show();
		$("#upload").hide();
		$("#r2").prop('checked', true);

		$('.checkbox').click(function() {
			// save the original checked state of the one we're clicking:
			var checked = $(this).attr('checked');
			$('.checkbox').attr('checked', false); // uncheck all of the boxes
			$(this).attr('checked', checked); // invert the original state
		});

	});
	function checkFields() {
		var qDesc = document.getElementById("qDesc").value;
		var opt1 = document.getElementById("opt1").value;
		var opt2 = document.getElementById("opt2").value;
		var opt3 = document.getElementById("opt3").value;
		var opt4 = document.getElementById("opt4").value;
		var crop = document.getElementsByName("crop");
		//alert("crop: " + crop.length);

		$(".v").text("")
		/* alert("qDesc: " + qDesc + " opt1: " + opt1 + " opt2: " + opt2
				+ " opt3: " + opt3 + " opt4: " + opt4); */
		if (qDesc == "") {
			document.addForm.qDesc.focus();
			$("#q").text(" * Required")
			//alert("returning false");
			return false;
		} else if (opt1 == "") {
			document.addForm.opt1.focus();
			$("#oo1").text(" * Required")

			return false;
		} else if (opt2 == "") {
			document.addForm.opt2.focus();
			$("#oo2").text(" * Required")
			return false;
		} else if (opt3 == "") {
			document.addForm.opt3.focus();
			$("#oo3").text(" * Required")
			return false;
		} else if (opt4 == "") {
			document.addForm.opt4.focus();
			$("#oo4").text(" * Required")
			return false;
		}

		/* else {
			return true;
		} */
		var count = 0;
		for ( var i = 0; i < crop.length; i++) {
			if (crop[i].checked) {
				//alert("df" + crop[i].value);
				break;
			}
			count++;
		}
		if (count == 4) {
			//alert("count: "+count);
			document.getElementsByName("crop")[0].focus();
			return false;
		}
		return true;
	}
	function checkUpload(status) {
		if (status == true) {
			$(".entry").hide();
			$("#upload").show();
		}
	}
	function checkRadioQuest(status) {
		if (status == true) {
			$(".entry").show();
			$("#upload").hide();
		}
	}
	function checkFile() {
		var file = $("#file").val();
		//alert("file: "+file);
		if (file == "")
			return false;
		else
			return true;
	}
</script>

<script>
	// The instanceReady event is fired, when an instance of CKEditor has finished
	// its initialization.
	CKEDITOR.on('instanceReady', function(ev) {
		// Show the editor name and description in the browser status bar.
		document.getElementById('eMessage').innerHTML = 'Instance <code>'
				+ ev.editor.name + '<\/code> loaded.';

		// Show this sample buttons.
		document.getElementById('eButtons').style.display = 'block';
	});

	function InsertHTML() {
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.editor1;
		var value = document.getElementById('htmlArea').value;

		// Check the active editing mode.
		if (editor.mode == 'wysiwyg') {
			// Insert HTML code.
			// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-insertHtml
			editor.insertHtml(value);
		} else
			alert('You must be in WYSIWYG mode!');
	}

	function InsertText() {
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.editor1;
		var value = document.getElementById('txtArea').value;

		// Check the active editing mode.
		if (editor.mode == 'wysiwyg') {
			// Insert as plain text.
			// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-insertText
			editor.insertText(value);
		} else
			alert('You must be in WYSIWYG mode!');
	}

	function SetContents() {
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.editor1;
		var value = document.getElementById('htmlArea').value;

		// Set editor contents (replace current contents).
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-setData
		editor.setData(value);
	}

	function GetContents() {
		// Get the editor instance that you want to interact with.
		var editor = CKEDITOR.instances.editor1;

		// Get editor contents
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-getData
		alert(editor.getData());
	}

	function ExecuteCommand(commandName) {
		// Get the editor instance that wte want to interact with.
		var editor = CKEDITOR.instances.editor1;

		// Check the active editing mode.
		if (editor.mode == 'wysiwyg') {
			// Execute the command.
			// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-execCommand
			editor.execCommand(commandName);
		} else
			alert('You must be in WYSIWYG mode!');
	}

	function CheckDirty() {
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.editor1;
		// Checks whether the current editor contents present changes when compared
		// to the contents loaded into the editor at startup
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-checkDirty
		alert(editor.checkDirty());
	}

	function ResetDirty() {
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.editor1;
		// Resets the "dirty state" of the editor (see CheckDirty())
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-resetDirty
		editor.resetDirty();
		alert('The "IsDirty" status has been reset');
	}

	function Focus() {
		CKEDITOR.instances.editor1.focus();
	}

	function onFocus() {
		document.getElementById('eMessage').innerHTML = '<b>' + this.name
				+ ' is focused </b>';
	}
 
	function onBlur() {
		document.getElementById('eMessage').innerHTML = this.name
				+ ' lost focus';
	}
</script>
<body onload='document.addForm.questDesc.focus();'>
	<div id="modal">
		<div id="heading">
			<h3 align="center">Add Question</h3>
			<br>
		</div>
		<div id="content">
			<input type="radio" onclick="checkUpload(this.checked);"
				name="bulkRadio" id="r1" /> Bulk Upload <input type="radio"
				onclick="checkRadioQuest(this.checked);" name="bulkRadio" id="r2" />
			Enter Question
			<div class="entry">
				<form action="addQuestion.htm" method="post" name="addForm"
					onsubmit="return checkFields();">
					<table border="0" cellspacing="5">
						<br />
						<tr>
							<td>Question:</td>
							<td><textarea rows="2" cols="70" name="questDesc" id="qDesc"
									class="questTextArea"></textarea><span style="color: red;"
								id="q" class="v">&nbsp;</span></td>
							<script>
						// Replace the <textarea id="editorText"> with an CKEditor instance.
						CKEDITOR 
								.replace(
										'questDesc',
										{
											on : {
												focus : onFocus,
												blur : onBlur,

												// Check for availability of corresponding plugins.
												pluginsLoaded : function(evt) {
													var doc = CKEDITOR.document, ed = evt.editor;
													if (!ed.getCommand('bold'))
														doc
																.getById(
																		'exec-bold')
																.hide();
													if (!ed.getCommand('link'))
														doc
																.getById(
																		'exec-link')
																.hide();
												}
											}
										});
					</script>
						</tr>
						<tr>  
							<td>Option 1:</td>
<td><textarea rows="2" cols="70" name="option1" id="opt1"
									class="questTextArea"></textarea><span style="color: red;"
								id="q" class="v">&nbsp;</span></td>
							<script>
						// Replace the <textarea id="editorText"> with an CKEditor instance.
						CKEDITOR 
								.replace(
										'option1',
										{
											on : {
												focus : onFocus,
												blur : onBlur,

												// Check for availability of corresponding plugins.
												pluginsLoaded : function(evt) {
													var doc = CKEDITOR.document, ed = evt.editor;
													if (!ed.getCommand('bold'))
														doc
																.getById(
																		'exec-bold')
																.hide();
													if (!ed.getCommand('link'))
														doc
																.getById(
																		'exec-link')
																.hide();
												}
											}
										});
					</script>			<td><input type="checkbox" class="checkbox" name="crop"
								value="1" /></td>
						</tr>
						<tr>
							<td>Option 2:</td>
							<td><textarea rows="2" cols="70" name="option2" id="opt2"
									class="questTextArea"></textarea><span style="color: red;"
								id="q" class="v">&nbsp;</span></td>
							<script>
						// Replace the <textarea id="editorText"> with an CKEditor instance.
						CKEDITOR 
								.replace(
										'option2',
										{
											on : {
												focus : onFocus,
												blur : onBlur,

												// Check for availability of corresponding plugins.
												pluginsLoaded : function(evt) {
													var doc = CKEDITOR.document, ed = evt.editor;
													if (!ed.getCommand('bold'))
														doc
																.getById(
																		'exec-bold')
																.hide();
													if (!ed.getCommand('link'))
														doc
																.getById(
																		'exec-link')
																.hide();
												}
											}
										});
					</script><span style="color: red;" id="oo2"
								class="v">&nbsp;</span></td>
							<td><input type="checkbox" class="checkbox" name="crop"
								value="2" /></td>
						</tr>
						<tr> 
							<td>Option 3:</td>
							<td><textarea rows="2" cols="70" name="option3" id="opt3"
									class="questTextArea"></textarea><span style="color: red;"
								id="q" class="v">&nbsp;</span></td>
							<script>
						// Replace the <textarea id="editorText"> with an CKEditor instance.
						CKEDITOR 
								.replace(
										'option3',
										{
											on : {
												focus : onFocus,
												blur : onBlur,

												// Check for availability of corresponding plugins.
												pluginsLoaded : function(evt) {
													var doc = CKEDITOR.document, ed = evt.editor;
													if (!ed.getCommand('bold'))
														doc
																.getById(
																		'exec-bold')
																.hide();
													if (!ed.getCommand('link'))
														doc
																.getById(
																		'exec-link')
																.hide();
												}
											}
										});
					</script><span style="color: red;" id="oo3"
								class="v">&nbsp;</span></td>
							<td><input type="checkbox" class="checkbox" name="crop"
								value="3" /></td>
						</tr>
						<tr>
							<td>Option 4:</td>
							<td><textarea rows="2" cols="70" name="option4" id="opt4"
									class="questTextArea"></textarea><span style="color: red;"
								id="q" class="v">&nbsp;</span></td>
							<script>
						// Replace the <textarea id="editorText"> with an CKEditor instance.
						CKEDITOR 
								.replace(
										'option4',
										{
											on : {
												focus : onFocus,
												blur : onBlur,

												// Check for availability of corresponding plugins.
												pluginsLoaded : function(evt) {
													var doc = CKEDITOR.document, ed = evt.editor;
													if (!ed.getCommand('bold'))
														doc
																.getById(
																		'exec-bold')
																.hide();
													if (!ed.getCommand('link'))
														doc
																.getById(
																		'exec-link')
																.hide();
												}
											}
										});
					</script><span style="color: red;" id="oo4"
								class="v">&nbsp;</span></td>
							<td><input type="checkbox" class="checkbox" name="crop"
								value="4" /></td>
						</tr>
						<tr>
							<td colspan="2">Note: Check correct option!</td>
						</tr>

						<tr>
							<td><input type="hidden" name="setEntries"
								value="${setEntries}" /></td>
						</tr>
						<tr>
							<td><input type="submit" class="button green close"
								value="Add"></td>
							<td><input type="button" onclick="history.back()"
								class="button" value="Cancel" /></td>
						</tr>
					</table>
				</form>

			</div>
			<div id="upload">
				<table border="0" cellspacing="5">
					<br />
					<br />
					<br />
					<tr>
						<td colspan="2" align="center">
							<h2>Upload File</h2>
						</td>
					</tr>

					<form:form action="fileForm.htm" method="POST"
						commandName="fileUploadForm" enctype="multipart/form-data">

						<%-- <form:errors path="*" cssClass="errorblock" element="div" /> --%>

						<tr>
							<td>Select file :</td>
							<td><input type="file" name="fileData" id="file" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center"><input type="submit"
								class="button" value="upload" onclick="return checkFile();" /><input
								type="button" onclick="history.back()" class="button"
								value="Cancel" /></td>
						</tr>
						<span> <%-- <form:errors path="file" cssClass="error" /> --%>
						</span>

					</form:form>
				</table>
			</div>
		</div>
	</div>

	<%-- 	<!--jQuery-->
	<script src="<%=request.getContextPath()%>/resources/js/popupbox.js"></script>

	<script type="text/javascript">
		$(document).ready(function(e) {
			//$('#postQuest').click(function(e) { // Button which will activate our modal
			$('#modal').reveal({ // The item which will be opened with reveal
				animation : 'fade', // fade, fadeAndPop, none
				animationspeed : 600, // how fast animtions are
				closeonbackgroundclick : false
			// if you click background will modal close?
			//dismissmodalclass : 'close' // the class of a button or element that will close an open modal
			});
			return false;
			//});
		});
	</script> --%>
</body>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>