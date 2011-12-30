<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>活動列表</title>
<!--Make sure page contains valid doctype at the very top!-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/jquery-1.3.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/stepcarousel.js">
	/***********************************************
	 * Step Carousel Viewer script- (c) Dynamic Drive DHTML code library (www.dynamicdrive.com)
	 * Visit http://www.dynamicDrive.com for hundreds of DHTML scripts
	 * This notice must stay intact for legal use
	 ***********************************************/
</script>

<style type="text/css">
.stepcarousel {
	position: relative; /*leave this value alone*/
	border: 10px solid LightCyan;
	overflow: scroll; /*leave this value alone*/
	width: 480px; /*Width of Carousel Viewer itself*/
	height: 360px; /*Height should enough to fit largest content's height*/
	margin-left: auto;
	margin-right: auto;
}

.stepcarousel .belt {
	position: absolute; /*leave this value alone*/
	left: 0;
	top: 0;
}

.stepcarousel .panel {
	float: left; /*leave this value alone*/
	overflow: hidden;
	/*clip content that go outside dimensions of holding panel DIV*/
	margin: 10px; /*margin around each panel*/
	width: 460px;
	/*Width of each panel holding each content. If removed, widths should be individually defined on each content DIV then. */
}

.heading {
	margin-left: auto;
	margin-right: auto;
	text-align: center;
}

</style>

<script type="text/javascript">
	stepcarousel.setup({
		galleryid : 'mygallery', //id of carousel DIV
		beltclass : 'belt', //class of inner "belt" DIV containing all the panel DIVs
		panelclass : 'panel', //class of panel DIVs each holding content
		autostep : {
			enable : true,
			moveby : 1,
			pause : 3000
		},
		panelbehavior : {
			speed : 500,
			wraparound : false,
			wrapbehavior : 'slide',
			persist : true
		},
		defaultbuttons : {
			enable : true,
			moveby : 1,
			leftnav : [ '${pageContext.request.contextPath}/images/leftnav.gif', -5, 80 ],
			rightnav : [ '${pageContext.request.contextPath}/images/rightnav.gif', -20, 80 ]
		},
		statusvars : [ 'statusA', 'statusB', 'statusC' ], //register 3 variables that contain current panel (start), current panel (last), and total panels
		contenttype : [ 'inline' ]
	//content setting ['inline'] or ['ajax', 'path_to_external_file']
	});
</script>

</head>
<body>
	<div class="heading"><big><b>線上活動報名</b></big></div>
	<div id="mygallery" class="stepcarousel">
		<div class="belt">
            <c:forEach var="actvt" items="${activities}">
			<div class="panel" >
				<a href="${pageContext.request.contextPath}/Activity?cmd=registrate&actid=${actvt.activityid}">
				<img src="${pageContext.request.contextPath}/images/activity/${actvt.activityid}.jpg" 
				 alt="${actvt.activityname}" />
				</a>
			</div>
			</c:forEach>
		</div>
	</div>

	<p id="mygallery-paginate" style="width: 250px;margin-left:auto; margin-right:auto; text-align: center">
		<img src="${pageContext.request.contextPath}/images/opencircle.png" 
		     data-over="${pageContext.request.contextPath}/images/graycircle.png"
			 data-select="${pageContext.request.contextPath}/images/closedcircle.png" 
			 data-moveby="1" />
	</p>

</body>
</html>