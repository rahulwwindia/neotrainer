<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<!--
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
-->
<html>
<head>
<meta charset="utf-8">
<title>API Usage &mdash; CKEditor Sample</title>
<script src="<%=request.getContextPath()%>/resources/js/ckeditor.js"></script>
<link href="<%=request.getContextPath()%>/resources/js/sample.css"
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
		var editor = CKEDITOR.instances.editorText;
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
		var editor = CKEDITOR.instances.editorText;
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
		var editor = CKEDITOR.instances.editorText;
		var value = document.getElementById('htmlArea').value;

		// Set editor contents (replace current contents).
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-setData
		editor.setData(value);
	}

	function GetContents() {
		// Get the editor instance that you want to interact with.
		var editor = CKEDITOR.instances.editorText;

		// Get editor contents
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-getData
		alert(editor.getData());
	}

	function ExecuteCommand(commandName) {
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.editorText;

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
		var editor = CKEDITOR.instances.editorText;
		// Checks whether the current editor contents present changes when compared
		// to the contents loaded into the editor at startup
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-checkDirty
		alert(editor.checkDirty());
	}

	function ResetDirty() {
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.editorText;
		// Resets the "dirty state" of the editor (see CheckDirty())
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-resetDirty
		editor.resetDirty();
		alert('The "IsDirty" status has been reset');
	}

	function Focus() {
		CKEDITOR.instances.editorText.focus();
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
<style type="text/css">
body {
	background-color: olivedrab;
}
</style>
</head>
<body>
<a href="#" onclick="history.back()">back</a>
	<form:form action="editor.htm" method="post" commandName="editor">
		<table>
			<tr>
				<td><form:textarea cols="100" path="editorText" rows="10" /></td>
				<td style="color: #ff0000"><form:errors path="editorText" /></td>

				<script>
					// Replace the <textarea id="editorText"> with an CKEditor instance.
					CKEDITOR.replace('editorText', {
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
			</tr>
		</table>
		<table>
			<tr></tr>
			<tr>
				<td><form:label path="name" style="color:blue">Name</form:label></td>
				<td><form:input path="name" /></td>
				<td style="color: #ff0000"><form:errors path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="emailId" style="color:blue">Email</form:label></td>
				<td><form:input path="emailId" /></td>
				<td style="color: #ff0000"><form:errors path="emailId" /></td>
			</tr>
			<tr>
				<td colspan='2'><input type="submit" class="button"></input></td>
			</tr>
			<tr>
				<td><a href="signInPage.htm" style="color: blue">Sign In</a></td>
			</tr>
			<tr></tr>
			<tr>
				<td colspan="2"
					style="font-family: arial; color: red; font-size: 20px;">${successMsg}</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
