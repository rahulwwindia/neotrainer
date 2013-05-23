<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="neo" uri="/WEB-INF/neo.tld"%>
<script src="<%=request.getContextPath()%>/resources/js/ckeditor.js"></script>
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



<div class="viewport">
	<div class="overview">

		<form:form action="article.htm" method="post" commandName="article">
			<h1 align="center">${articleGroup}</h1>
			<table>

				<tr>
					<td colspan="2">${successMsg}</td>
				</tr>

				<!-- 	<c:if test="${not empty ArticleList}">
				<tr>
					<th style="color: blue; font-family: sans-serif;" align="left">Previous
						Articles Posted:</th>
				</tr>
			</c:if>

			<c:forEach var="article" items="${ArticleList}">

				<tr>
					<td colspan="2" class="download" width=100%;><a
						href="viewArticle.htm?articleTitle=${article.title}"
						style="color: blue">${article.title}</a></td>

				</tr>

			</c:forEach>
 -->
				<neo:dataTable id="dTable" name="dTable"
					labels="S.No.,Title,Posted by, Email Id , posted Date"
					tableId="example" dtBorder="2" dtWidth="400"
					dataList="${ArticleList}"
					formBean="com.neo.trainer.model.article.Article"
					formBeanColumn="id,title,name,emailId,date" isDisplayLength="true" />




				<tr>
					<td><br /></td>
				</tr>

				<tr>
					<b><th style="color: blue; font-family: sans-serif;" align="left">
						Post Your Article:</th></b>
				</tr>

				<tr>
				
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
				</tr>  
				<tr>
					<b><td><form:label path="title" >Title</form:label></td></b>
					<td><form:input path="title" /></td>
					<td style="color: #ff0000"><form:errors path="title" /></td>
				</tr>
 
			</table>

			<table style="width: 100%;">
				<tr>
					<td><form:textarea cols="100" path="editorText" rows="10" /></td>
					<td style="color: #ff0000"><form:errors path="editorText" /></td>

					<script>
						// Replace the <textarea id="editorText"> with an CKEditor instance.
						CKEDITOR
								.replace(
										'editorText',
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
			</table>
			<form:hidden path="articleType" value="${articleOf}" />
				<form:hidden path="name" value="${userSessionName.userName}" />
				<form:hidden path="emailId" value="${userSessionName.email}" /> 
			<table>
				<tr></tr>
 
					 
 
				<tr>
					<td colspan='2' align="center"><input type="submit"
						value="Post" class="button" style="width: 80px" /><input
						type="button" onclick="history.back()" class="button"
						value="Cancel" style="width: 80px" /></td>
				</tr>

				<tr></tr>

			</table>

		</form:form>
	</div>
</div>




