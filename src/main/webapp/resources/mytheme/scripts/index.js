var flag = 0;	/*Flag for Analysis Page Show/Hide */
var dash = 0;	/*Flag for Dashboard Page Show/Hide */

$(document).ready(function() {
	$('#bodyDiv, #projectDiv, #dashboardDiv').css('height',(window.innerHeight));
	$('#rightDiv h6, #rightDiv button').css('visibility','hidden');
	
	$('#leftDiv, #projectDiv, #homeImage, #dashboardImage').hide();			
	$('#homeImage').fadeIn(1000);	
	
	$("#homeImage").click(function() {
		$(this).fadeOut(500,function() {
			//$('#wrapper').css("opacity","1");
			$('#bodyDiv').css("opacity","0.9");
			$('#rightDiv').css("opacity","1");
			$('#floatingDiv').remove();
			$('#leftDiv').fadeIn(400);									
			$('#leftDiv').click();
			$('#dashboardImage').fadeIn(1000);
			$('#homeImage').remove();
		});
	});
	
	$("#leftDiv").click(function() {
		$("#projectDiv").toggle('slide',{direction: 'left'},500);
	});
	
	$("#dashboardDiv h2").click(function() {
		$('#dashboardDiv').remove();
		$('#wrapper').css("opacity","1");
	});
	
	$("#projectDiv ul li").click(function() {
		$("#projectDiv").toggle('slide',{direction: 'left'}, 500, function() {
			$('#dashboardDiv h1, #dashboardDiv h2, #rightDiv h6, #rightDiv button').css('visibility','visible');	/* Dashboard Visible after clicking project name.*/
			$("#analysisDivControlButton").click();																	/* Hiding Analysis Page initially. */
			$('#dashboardImage').fadeOut(500,function() {
				$('#dashboardImage').remove();																			/* Removing the dashboard image. Not the entire dashboard div. */
			});
		});

	});
	
	// Analysis Page Show/Hide.
	$("#analysisDivControlButton").click(function() {
		flag = !flag;
		var expandBuildDiv = function() {
			$("#buildDiv").animate({height:'+=500'});
		};
		var contractBuildDiv = function() {
			$("#buildDiv").animate({height:'-=500'});
		};
		if (flag) 
		{
			$("#analysisDiv").animate( { height: '0px', top:'+=500' }, "slow", expandBuildDiv() );
			this.innerHTML = 'Show';
		}
		else
		{
			$("#analysisDiv").animate( { height: '100%', top:'-=500' }, "slow", contractBuildDiv() );
			this.innerHTML = 'Hide';
		}
	});	
	
	// Dashboard Show/Hide.
	$("#dashboardDivControlButton").click(function() {
		dash = !dash;
		if (dash) 
		{
			$('#dashboardDiv').css('z-index','-10');
			$('#dashboardDiv').css('opacity','0');
			$('#wrapper').css("opacity","1");
			this.innerHTML = 'Show';
		}
		else
		{
			$("#dashboardFrame").attr('src','DashboardServlet?projectName=Verizon');		/*GET call to fetch fresh details*/
			$('#wrapper').css("opacity","0");
			$('#dashboardDiv').css('opacity','1');
			$('#dashboardDiv').css('z-index','10');	
			this.innerHTML = 'Hide';
		}
	});	
	
	$('#analysisSelectorAsBuild').click(function() {
		$(this).addClass("active").addClass("btn-success").removeClass("gray");
		$('#analysisSelectorAsTest').removeClass("active").removeClass("btn-success").addClass("gray");
		$("#analysisFrame").attr('src','SuiteAnalysisServlet?projectname=Verizon');
	});
	
	$('#analysisSelectorAsTest').click(function() {
		$(this).addClass("active").addClass("btn-success").removeClass("gray");
		$('#analysisSelectorAsBuild').removeClass("active").removeClass("btn-success").addClass("gray");
		$("#analysisFrame").attr('src','TestAnalysisServlet?projectname=Verizon');
	});
	
	$('#projectDiv, #rightDiv').click(function() {
		$("#projectDiv").hide('slide',{direction: 'left'}, 500);
	});
});

var transit = function (projectName) {
	// Rendering required servlet to the iFrame.	With only Project Name as parameter.
	/*document.getElementById("buildFrame").src = 'SuiteServlet?projectname='+projectName+'&suite=all&test=all&teststatus=all';
	document.getElementById("analysisFrame").src = 'SuiteAnalysisServlet?projectname='+projectName+'&suite=all&test=all&teststatus=all';*/
	document.getElementById("dashboardFrame").src = '/build.html';
};
