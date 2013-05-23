<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!--
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
-->

<head>
<meta charset="utf-8">
<!-- <title>API Usage &mdash; CKEditor Sample</title> -->
<script src="<%=request.getContextPath()%>/resources/js/ckeditor.js"></script>
 <link href="<%=request.getContextPath()%>/resources/css/sample.css"
	rel="stylesheet"> 
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
		var editor = CKEDITOR.instances.postContent;
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
		var editor = CKEDITOR.instances.postContent;
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
		var editor = CKEDITOR.instances.postContent;
		var value = document.getElementById('htmlArea').value;

		// Set editor contents (replace current contents).
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-setData
		editor.setData(value);
	}

	function GetContents() {
		// Get the editor instance that you want to interact with.
		var editor = CKEDITOR.instances.postContent;

		// Get editor contents
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-getData
		alert(editor.getData());
	}

	function ExecuteCommand(commandName) {
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.postContent;

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
		var editor = CKEDITOR.instances.postContent;
		// Checks whether the current editor contents present changes when compared
		// to the contents loaded into the editor at startup
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-checkDirty
		alert(editor.checkDirty());
	}

	function ResetDirty() {
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.postContent;
		// Resets the "dirty state" of the editor (see CheckDirty())
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-resetDirty
		editor.resetDirty();
		alert('The "IsDirty" status has been reset');
	}

	function Focus() {
		CKEDITOR.instances.postContent.focus();
	}

	function onFocus() {
		var title=$(".titleCls").val();
		var set=$(".titleCls").val();
		//alert("title: "+title);
		if(title==""){
			$(".titleCls").focus();
		}
		document.getElementById('eMessage').innerHTML = '<b>' + this.name
				+ ' is focused </b>';
	}

	function onBlur() {
		document.getElementById('eMessage').innerHTML = this.name
				+ ' lost focus';
	}
</script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/resources/js/jquery.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		
						});

</script>
</head>
<body>
	<!-- <a href="#" onclick="history.back()">back</a> -->
	<form:form action="postQuest.htm" method="post" commandName="posts" name="postForm">
		<table>
			<tr>
				<td style="color: blue;">${postMsg}</td>
			</tr>
			<tr><td>Group Name: </td></tr>
			<tr>
				<td><select name="groupName" id="groupName"
					style="background: skyblue;">
						<!-- <option value="">---Select Group----</option> -->
						<c:forEach items="${groupList}" var="groupList">
							<option value="${groupList.groupName}">${groupList.groupName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Post Title:</td>
			</tr>
			<tr>
				<td><form:textarea cols="100" path="postTitle" rows="2" class="titleCls" /></td>
			</tr>
			<tr>
				<td>Post Description:</td>
			</tr>
			<tr>
				<td><form:textarea cols="100" path="postContent" rows="10" /></td></tr>
				<tr><td style="color: #ff0000"><form:errors path="postContent" /></td></tr>

				<script>
					// Replace the <textarea id="postContent"> with an CKEditor instance.
					CKEDITOR.replace('postContent', {
						on : {
							focus : onFocus,
							blur : onBlur,

							// Check for availability of corresponding plugins.
							pluginsLoaded : function(evt) {
								var doc = CKEDITOR.document, ed = evt.editor;
								if (!ed.getCommand('bold'))
									doc.getById('exec-bold').hide();
								if (!ed.getCommand('link'))
									doc.getById('exec-link').hide();
							}
						}
					});
				</script>
			<!-- </tr> -->
		</table>
		<table>
			<tr></tr>

			<tr>
				<td colspan='2' align="center"><input type="submit"
					value="Save" class="button" style="width: 80px" ></input><input type="button"
					onclick="history.back()" class="button" value="Cancel" style="width: 80px"/></td>
			</tr>

		</table>
	</form:form>

</body>

