
function LoadTestRunnerPage() {
	GeneralTestPageSpecificLoad();
	$('#divLoading').remove();
	$('#divStartTestInstruction').show();
}

var _timerHandler = 0;
var _txtTestStats = ''; /* Result Stats append with feedback text */

/* Added for CAT Test*/
function CheckForViewerMode() {
	var txtUrl = window.location.href;

	if (txtUrl.indexOf('sessionid') > 10
			&& txtUrl.split('sessionid=')[1].length > 1) {
		var objArrSelectedAnswer = $('#divTabContent input.jq-selected-answer');
		var txtAnswerKey = '';

		$("#divInitiator").remove();
		$("#divTestLegend").remove();

		$("#btnSubmitTest").replaceWith(
				'<input type="button" id="btnClose" value="Close" />');
		$("#btnClose ").click(function() {
			self.close();
		});

		txtAnswerKey = $.trim(txtUrl.split('sessionid=')[1].toString());
		txtAnswerKey = txtAnswerKey.toUpperCase();

		if (objArrSelectedAnswer.length == txtAnswerKey.length) {
			for ( var iCount = 0; iCount < txtAnswerKey.length; iCount++) {
				if (txtAnswerKey.charAt(iCount) != '0')
					objArrSelectedAnswer[iCount].value = txtAnswerKey
							.charAt(iCount);
			}

			PopulateResultStatics();
		} else {
			$('#lnkTestTitle_TD').hide();
			$('.div-tabs-container')
					.html(
							'<b style="color:#FF1111;">Error occured while generating result report.</b>');
		}

		$('#lnkTestTitle_TD').hide();
	}
}

function GeneralTestPageSpecificLoad() {
	$(".result-option").click(function() {
		OptionClickHandler(this);
	});

	$("a.jq-menu").click(function() {
		TestTabMenuClickHandler(this);
	});

	$('#btnStartTest').click(function() {
		StartTestButtonClickHandler(this);
	});

	$('#btnSubmitTest').click(function() {
		SubmitTestButtonClickHandler(this);
	});

	InitializeTestPage();

	CheckForViewerMode(); /* Added for CAT Test*/
}

function InitializeTestPage() {
	LoadOtherPageSpecificFunctions();
	$('#div' + 'TabContent').hide(); /* Initially hides the Test questions, Shows 'Start Test' button.*/
	$('#btnSubmitTest').attr('disabled', 'disabled');
}

function LoadOtherPageSpecificFunctions() {
	/* Invoke : Other Page Specific Functions  */
	var txtTestTitleID = $('#hdnTestTitleID').val();
	if (txtTestTitleID == '2')
		TechnicalCPageSpecificFunctionsLoad(); /* c-programming.js */
	if (txtTestTitleID == '13')
		TechnicalJavaPageSpecificFunctionsLoad(); /* java-programming.js */
	/*  
	    define( "IB_APTITUDE_ID"         , 1 );
	    define( "IB_C_PROGRAMMING_ID"    , 2 ); 
	    define( "IB_VERBAL_ABILITY_ID"   , 3 );  
	    define( "IB_VERBAL_RESONING_ID"  , 4 );  
	    define( "IB_LOGICAL_RESONING_ID" , 5 ); 
	    define( "IB_JAVA_PROGRAMMING_ID"    , 13 );  
	 */
}

function SubmitTestButtonClickHandler(thisObj) {
	var txtMsg = '';
	var intUAC = $("input.jq-selected-answer[value='']").length;
	if (intUAC > 0)
		txtMsg = "Total number of unanswered questions = " + intUAC + ".\n\n";

	if (confirm(txtMsg + 'Are you sure you want to submit the Test now?')) /* Check for Time limit also. */
	{
		$(thisObj).attr('disabled', 'disabled');
		PopulateResultStatics();
	}
}

function StartTestButtonClickHandler(thisObj) {
	/* 4 Lines - Firefox Combatability */
	$('#divResult').html('');
	$('.result-option').removeAttr('disabled');
	$('.result-option').removeAttr('checked');
	$('#hdnTimer').val($('#hdnInitialTimer').val());

	$('#divInitiator').remove();
	$('#btnSubmitTest').removeAttr('disabled');
	$('#divTabContent').show();
	$('#idTimerSpan').show();
	_timerHandler = setInterval("MyTimer()", 1000);
}

function OptionClickHandler(thisObj) {
	var objID = thisObj.id; //option_A_25     1 - A ; 2 - 25
	var optAns = objID.split('_')[1];
	var quesID = objID.split('_')[2];
	var preVal = $("#optionSelAns_" + quesID).val();

	if (preVal == "") {
		$("#optionSelAns_" + quesID).val(optAns); // set current option as answer.
		$(thisObj).attr("checked", "checked");
		$('.jq-qno-' + quesID).addClass('ib-answered');
	} else if (preVal == optAns) {
		$("#optionSelAns_" + quesID).val("");
		$(thisObj).removeAttr("checked"); //remove cur. object option check mark. 
		$('.jq-qno-' + quesID).removeClass('ib-answered');
	} else {
		$("#optionSelAns_" + quesID).val(optAns);
		$(".cls_" + quesID).removeAttr("checked"); // remove all check mark
		$(thisObj).attr("checked", "checked"); // set check mark to current one.
		$('.jq-qno-' + quesID).addClass('ib-answered');
	}
}

function TestTabMenuClickHandler(objMenu) {
	var txtID = objMenu.id;

	if (txtID == "lnkResultStatus" || txtID == "#lnkResultStatus") {
		if ($('#lnkResultStatus_TD').hasClass('normal')) {
			$('#lnkResultStatus_TD').removeClass('normal');
			$('#lnkResultStatus_TD').addClass('current');

			$('#lnkTestTitle_TD').removeClass('current');
			$('#lnkTestTitle_TD').addClass('normal');

			$('#divTabContent').hide();
			$('#divTestLegend').hide();
			$('#divResult').show();
			$('#divResultStatistics').show();
		}
	} else if (txtID == "lnkTestTitle" || txtID == "#lnkTestTitle") {
		if ($('#lnkTestTitle_TD').hasClass('normal')) {
			$('#lnkTestTitle_TD').removeClass('normal');
			$('#lnkTestTitle_TD').addClass('current');

			$('#lnkResultStatus_TD').removeClass('current');
			$('#lnkResultStatus_TD').addClass('normal');

			$('#divResult').hide();
			$('#divResultStatistics').hide();
			$('#divTabContent').show();
			$('#divTestLegend').show();
		}
	}
}

function MyTimer() {
	var valueTimer = $('#hdnTimer').val();

	if (valueTimer > 0) {
		valueTimer = valueTimer - 1;

		hours = (valueTimer / 3600).toString().split('.')[0];
		mins = ((valueTimer % 3600) / 60).toString().split('.')[0];
		secs = ((valueTimer % 3600) % 60).toString();

		if (hours.length == 1)
			hours = '0' + hours;
		if (mins.length == 1)
			mins = '0' + mins;
		if (secs.length == 1)
			secs = '0' + secs;

		$('#idTimerLCD').text(hours + ':' + mins + ':' + secs);
		$('#hdnTimer').val(valueTimer);
	} else {
		$('#btnSubmitTest').attr('disabled', 'disabled');
		//alert(" Your time is up ! \n\n Let's see the Result & Statistics of the Test.");
		PopulateResultStatics();
	}
}

function PopulateResultStatics() {
	clearInterval(_timerHandler);
	$('#idTimerSpan').remove();
	$('.result-option').attr('disabled', 'disabled');

	/* Populate result tab.   */
	var txtHtml = $('#divTabContent').html();
	$('#divTabContent .jq-img-answer').remove(); /* Remove operation to avoid duplicate ID names - IE 6.0 compatible*/
	$('#divResult').html(txtHtml);
	$('#divResult input.jq-actual-answer').remove(); /* 2 - Remove won't work properly in IE 6 as it has same ID in divTabContent & divResult */
	$('#divResult input.jq-selected-answer').remove(); /* anyway no serious problem found.  */
	$('#divResult .jq-workspace').remove(); /* Removes correctly in IE 6 as it has no ID.*/

	var objArrActualAnswer = $('#divTabContent input.jq-actual-answer');
	var objArrSelectedAnswer = $('#divTabContent input.jq-selected-answer');

	var intTotalQuestions = objArrActualAnswer.length;
	var intAnsweredCount = 0;
	var intUnAnsweredCount = 0;
	var intCorrectAnswerCount = 0;
	var intWrongAnswerCount = 0;

	/* Iteration for All Ques Answers - Populates Result Info. */
	jQuery.each(objArrActualAnswer, function(i, obj) {

		var optionActual = $(obj).val();
		var optionSelected = $(objArrSelectedAnswer[i]).val();
		var quesID = obj.id.split('_')[1]; // optionAnswer_45 (hidden)  

		if (optionSelected != '') {
			//Radio Option ID :  optionAns_C_741
			$('#divResult #optionAns_' + optionSelected + '_' + quesID).attr(
					'checked', 'checked');
			$('#divResult #tdAnswerIMG_' + optionSelected + '_' + quesID)
					.show();
			intAnsweredCount++;
			if (optionSelected == optionActual)
				intCorrectAnswerCount++;
			else
				intWrongAnswerCount++;
		}

	});

	intUnAnsweredCount = intTotalQuestions - intAnsweredCount;

	/* Sets results Statistics info.  */
	var tmpResStat = $('#divResultStatistics').html();
	tmpResStat = tmpResStat.replace('[XX/XX]', intCorrectAnswerCount + '/'
			+ intTotalQuestions);
	tmpResStat = tmpResStat.replace('[TQ]', intTotalQuestions);
	tmpResStat = tmpResStat.replace('[AQ]', intAnsweredCount);
	tmpResStat = tmpResStat.replace('[UQ]', intUnAnsweredCount);
	$('#divResultStatistics').html(tmpResStat);

	$('#divResult .bix-div-answer').show(); /* Makes visible all AnsDesc. divs.  */

	$('#lnkTestTitle_TD').removeClass('current'); /* Makes Menu to normal type         */
	$('#lnkTestTitle_TD').addClass('normal');

	$('#lnkResultStatus_TD').show(); /* Already in Active but Hidden     */

	/* Initial Swap to Result Stat. Tab */
	$('#divTabContent').hide();
	$('#divTestLegend').hide();
	$('#divResult').show();
	$('#divResultStatistics').show();

	window.scroll(0, 0); /* Scrolls up the window. */

	AddGeneralTestViewCount(); /* Ajax call to server. */

	var totalTime = parseInt($('#hdnInitialTimer').val()) / 60;
	var timeTaken = (totalTime * 60) - parseInt($('#hdnTimer').val());

	_txtTestStats = " [ TotQ=" + intTotalQuestions + ", AnsQ="
			+ intAnsweredCount + ", UnAnsQ=" + intUnAnsweredCount + ", CorAns="
			+ intCorrectAnswerCount + ", WrongAns=" + intWrongAnswerCount
			+ ", TotTime=" + totalTime + "min, TimeTaken=" + timeTaken + "sec]";

}

function AddGeneralTestViewCount() {
	var intTestID = $('#hdnTestID').val();

	var _paramData = "TestID=" + intTestID;

	$.ajax({
		type : "POST",
		url : "/_ajax/add-test-viewcount.php",
		data : _paramData,
		cache : false,
		success : function(msg) { /* DONE */
		}
	});
}

function SendTestFeedback() {
	var txtFeedbackURL = window.location.href;
	var txtFeedbackText = escape($('#txtComments').val());
	var txtTestID = $('#hdnTestID').val();
	var txtQuality = $('#idQualityLevel').val();
	var txtDifficulty = $('#idDifficultyLevel').val();

	if (txtQuality == '0') {
		alert('Kindly select a Test Quality Level.');
		$('#idQualityLevel').focus();
		return false;
	}

	if (txtDifficulty == '0') {
		alert('Kindly select a Test Difficulty Level.');
		$('#idDifficultyLevel').focus();
		return false;
	}

	$('#btnSubmitFeedback').attr('disabled', 'disabled');
	$('#idQualityLevel').attr('disabled', 'disabled');
	$('#idDifficultyLevel').attr('disabled', 'disabled');
	$('#txtComments').attr('readonly', 'readonly');

	txtFeedbackText = txtFeedbackText.replace(/\+/g, '%2B');

	txtFeedbackText = txtFeedbackText + _txtTestStats;

	var _paramData = "FeedbackURL=" + txtFeedbackURL + "&FeedbackText="
			+ txtFeedbackText + "&TestID=" + txtTestID + "&QualityLevel="
			+ txtQuality + "&DifficultyLevel=" + txtDifficulty;

	$.ajax({
		type : "POST",
		url : "/_ajax/add-test-feedback.php",
		data : _paramData,
		cache : false,
		success : function(msg) {
			$('#btnSubmitFeedback').replaceWith(msg);
		}
	});

}

$(function() {

	$('#countdown').countup();

});

/**
 * @name jQuery Count-UP Plugin
 * @author Martin Angelov
 * @version 1.0
 * @url http://tutorialzine.com/2012/09/count-up-jquery/
 * @license MIT License
 */

(function($) {

	// Number of seconds in every time division
	var days = 24 * 60 * 60, hours = 60 * 60, minutes = 60;

	// Creating the plugin
	$.fn.countup = function(prop) {

		var options = $.extend({
			callback : function() {
			},
			start : new Date()
		}, prop);

		var passed = 0, d, h, m, s, positions;

		// Initialize the plugin
		init(this, options);

		positions = this.find('.position');

		(function tick() {

			passed = Math.floor((new Date() - options.start) / 1000);

			// Number of days passed
			d = Math.floor(passed / days);
			updateDuo(0, 1, d);
			passed -= d * days;

			// Number of hours left
			h = Math.floor(passed / hours);
			updateDuo(2, 3, h);
			passed -= h * hours;

			// Number of minutes left
			m = Math.floor(passed / minutes);
			updateDuo(4, 5, m);
			passed -= m * minutes;

			// Number of seconds left
			//Sets test time for all questions-------------------------------------********
			s = passed;
			updateDuo(6, 7, s);
			if (m == 1 && s == 0) {
				alert("You have "+m+":"+s+" minutes Remaining...");
			}
			if (m >= 2 && s >= 0 ) {
				//alert("Your time is up ! Let's see the Result & Statistics of the Test.");
				//window.location.href = "/testSubmit.htm";
				autoSubmit();
				
			}
			// Calling an optional user supplied callback
			options.callback(d, h, m, s);

			// Scheduling another call of this function in 1s
			setTimeout(tick, 1000);
		})();

		// This function updates two digit positions at once
		function updateDuo(minor, major, value) {
			switchDigit(positions.eq(minor), Math.floor(value / 10) % 10);
			switchDigit(positions.eq(major), value % 10);
		}

		return this;
	};

	function init(elem, options) {
		elem.addClass('countdownHolder');

		// Creating the markup inside the container
		$
				.each(
						[ 'Days', 'Hours', 'Minutes', 'Seconds' ],
						function(i) {
							$('<span class="count' + this + '">')
									.html(
											'<span class="position">\
					<span class="digit static">0</span>\
				</span>\
				<span class="position">\
					<span class="digit static">0</span>\
				</span>')
									.appendTo(elem);

							if (this != "Seconds") {
								elem.append('<span class="countDiv countDiv'
										+ i + '"></span>');
							}
						});

	}

	// Creates an animated transition between the two numbers
	function switchDigit(position, number) {

		var digit = position.find('.digit');

		if (digit.is(':animated')) {
			return false;
		}

		if (position.data('digit') == number) {
			// We are already showing this number
			return false;
		}

		position.data('digit', number);

		var replacement = $('<span>', {
			'class' : 'digit',
			css : {
				top : '-2.1em',
				opacity : 0
			},
			html : number
		});

		// The .static class is added when the animation
		// completes. This makes it run smoother.

		digit.before(replacement).removeClass('static').animate({
			top : '2.5em',
			opacity : 0
		}, 'fast', function() {
			digit.remove();
		});

		replacement.delay(100).animate({
			top : 0,
			opacity : 1
		}, 'fast', function() {
			replacement.addClass('static');
		});
	}
})(jQuery);
