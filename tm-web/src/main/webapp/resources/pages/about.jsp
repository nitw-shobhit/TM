<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<ol class="breadcrumb">
		<li><a data-ng-click="redirectToMyApps()" data-ng-controller="rootController"><span class="glyphicon glyphicon-th"></span> {{'breadcrumb.applications' | translate}}</a></li>
		<li class="active"><span class="glyphicon glyphicon-info-sign"></span> {{'breadcrumb.about' | translate}}</li>
	</ol>
	<br>
	<div
		style="background-color: #FFF; text-align: center; height: 40px; font-size: 18px; line-height: 2.3;">
		<img
			src="<%=request.getContextPath()%>/resources/images/logo_head.png"
			style="margin-right: 30px;" />WHAT, WHO, WHY and HOW of <b><font class="underline">Test
				Manager</font></b>.
	</div>
	<br>
	<div>
		<div style="font-size: 12px; background-color: #FFF;">
			<b>WHAT?</b>
			<p>Functional testing can be a real pain in the ***. Recording
				bugs is essential for any software development. What if a bug
				reappears and you cant seem to recall what went wrong the last time.
				Or you wanna follow the conversation during the fixing process for
				that ticket. While some people may still want to record all this in
				a spreadsheet and keep all the screenshots they captured arranged
				carefully in various directories, I believe browsing through all
				that would require quite a bit of effort. Why not let TEST MANAGER
				help you.</p>
			<p>
				Test Manager provides a comfortable and user friendly interface to
				help you manage your software development project. It allows you to
				create your virtual project with various modules as required in
				different phases of testing. <br>- Create an issue. <br>-
				Provide description. <br>- Attach screenshots. <br>- Put
				your comments. <br>- Subscribe to receive activity
				notifications. <br>- Prioritize it with pre loaded levels. <br>-
				Follow the issue history. <br>- Accept, Reject, Cancel, Reopen,
				Fix, Complete the issue. <br>- Archive to keep it safe.
			</p>
		</div>
		<br>
		<div style="font-size: 12px; background-color: #FFF;">
			<b>WHO?</b>
			<p>The developer, Shobhit Tyagi, is a Java backend engineer, who
				has been about 5 years in this industry. He is 27 years old, born
				and raised in New Delhi, India. He currently works with Avantica
				Technologies in Peru. He is passionate about programming and music.
				And he loves to travel.</p>
		</div>
		<br>
		<div style="font-size: 12px; background-color: #FFF;">
			<b>WHY?</b>
			<p>
				Shobhit is crazy to learn new technologies. And this application is
				an attempt to get familiar with some of the booming tools and
				technologies. Technical stack for this application is : <br>-
				Java, Spring MVC, Spring-Social, AspectJ <br>- AngularJS,
				Bootstrap, JQuery, AJAX, JSP <br>- MySql, Elastic Search <br>-
				WildFly <br>- Maven, SONAR, Jenkins, Github
			</p>
		</div>
		<br>
		<div style="font-size: 12px; background-color: #FFF;">
			<b>HOW?</b>
			<p>
				Why dont you <a class="underlinedLink">Take a Tour</a>.
			</p>
		</div>
	</div>
</body>
</html>