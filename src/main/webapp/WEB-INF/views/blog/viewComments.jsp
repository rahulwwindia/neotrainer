<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!--
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
-->
<head>
<meta charset="utf-8">
<title>API Usage &mdash; CKEditor Sample</title>
<script src="<%=request.getContextPath()%>/resources/js/ckeditor.js"></script>
<link href="<%=request.getContextPath()%>/resources/css/sample.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resourcescss/style.css">

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
		var editor = CKEDITOR.instances.commContent;
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
		var editor = CKEDITOR.instances.commContent;
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
		var editor = CKEDITOR.instances.commContent;
		var value = document.getElementById('htmlArea').value;

		// Set editor contents (replace current contents).
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-setData
		editor.setData(value);
	}

	function GetContents() {
		// Get the editor instance that you want to interact with.
		var editor = CKEDITOR.instances.commContent;

		// Get editor contents
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-getData
		alert(editor.getData());
	}

	function ExecuteCommand(commandName) {
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.commContent;

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
		var editor = CKEDITOR.instances.commContent;
		// Checks whether the current editor contents present changes when compared
		// to the contents loaded into the editor at startup
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-checkDirty
		alert(editor.checkDirty());
	}

	function ResetDirty() {
		// Get the editor instance that we want to interact with.
		var editor = CKEDITOR.instances.commContent;
		// Resets the "dirty state" of the editor (see CheckDirty())
		// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-resetDirty
		editor.resetDirty();
		alert('The "IsDirty" status has been reset');
	}

	function Focus() {
		CKEDITOR.instances.commContent.focus();

	}

	function onFocus() {
		/* var userName = '${userSessionName}';
		if (userName == "") {
			window.location = 'loginPopup.htm?source=comment&&postID=' + $
			{
				post.getPostId()
			}
			;
		} */
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/css/website.css"
	type="text/css" media="screen" />
<script type="text/javascript">
	$(document).ready(function() {});
	function fillEditor(comContent){
		var comCont="commContent"+comContent;
		var content=document.getElementById(comCont).innerHTML;
		$("#cID").val(comContent);
		var editor = CKEDITOR.instances.commContent;
		
		// Check the active editing mode.
		if (editor.mode == 'wysiwyg') {
			// Insert HTML code.
			// http://docs.ckeditor.com/#!/api/CKEDITOR.editor-method-insertHtml
			editor.insertHtml(content);
		} else
			alert('You must be in WYSIWYG mode!');
	} 
</script>

<style type="text/css">
#content {
	background-color: white;
}
</style>
</head>
<body onload="init()">

		<div class="viewport">
			<div class="overview">
				
				<div>
					<table border="0" cellspacing="4">
						<tr>
							<td colspan="2"><h3>Post:</h3></td>
						</tr>
						<tr>
							<td colspan="2">${post.postTitle}</td>
						</tr>
						<tr>
							<td colspan="2">${post.postContent}</td>
						</tr>
						<tr><td></td></tr>
						<tr><td></td></tr>
						<tr><td></td></tr>
						<tr><td></td></tr>
						<tr><td></td></tr> 
						<tr>
							<td>Posted By:</td>
							<td>${post.user.userName}</td>
						</tr>
						<tr>
							<td>Posted Date:</td>
							<td>${post.postDate}</td>
						</tr>
						<tr><td></td></tr>
						<tr><td></td></tr>
						<tr><td></td></tr>
						
						<c:if test="${post.user.userName==userSessionName}">
							<tr>
								<td><a href="deletePosts.htm?postID=${post.postId}" class="button">Delete
										Post</a></td>
							</tr>
						</c:if>
					</table> 

					<div class="comment">
						<c:forEach items="${hmComm}" var="comm" >
						<div  class="bix-tbl-container">
							<table border="0" cellspacing="4" class="${i.index % 2 == 0 ? 'even' : 'odd'}">
								<tr><td></td></tr>
								<tr>
								<td><div id="commContent${comm.key.commId}">${comm.key.commContent}</div></td>
								</tr>
								<tr><td></td></tr>
						<tr><td></td></tr>
						<tr><td></td></tr>
								
								
								<tr>
									<td><b>Posted By</b>:${comm.value}</td>
								</tr> 
								<tr>
									<td><b>Posted Date</b>:${comm.key.commDate}</td>
								</tr>
								<c:if test="${comm.value==userSessionName}">
									<tr> 
										<td><a href="#edit"
											onclick="fillEditor(${comm.key.commId})" class="button" >Edit
												Comment</a>&nbsp;&nbsp;<a
											href="deleteComm.htm?commId=${comm.key.commId}&&postID=${post.postId}" class="button" >Delete
												Comment</a></td>
									</tr>
								</c:if>
								</table>
								</div>
							</c:forEach>
						
					</div>

			</div>
			
	</div>

	<div class="clearing"></div>
	<div id="edit">
	<form:form name="commentForm" method="post" commandName="blogComment"
		action="saveComment.htm">
		<table style="width: 101%">
			<tr>
				<td style="color: blue;">${commMsg}</td>
			</tr>
			<tr>

				<td><form:textarea cols="100" path="commContent" rows="10" /></td>
				<td style="color: #ff0000"><form:errors path="commContent" /></td>

				<script>
					// Replace the <textarea id="commContent"> with an CKEditor instance.
					CKEDITOR.replace('commContent', {
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
				<td colspan='2' align="center"><input type="submit"
					value="Post Your Answer" id="commSubmit" class="button"
					style="width: 120px"></input><input type="button"
					onclick="history.back()" class="button" value="Cancel"
					style="width: 120px" /></td>
				<td><div id="editBtn"></div></td>
			</tr>
		</table>
		<input type="hidden" name="postID" value="${post.postId}" />
		<input type="hidden" id="cID" name="cID" value="" />
	</form:form>
	</div> 
	</div>
</body>

