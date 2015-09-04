<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<fieldset>
		<legend>
			<span class="header">PROJECT DATA</span>
		</legend>
		<section style="height: 445px;">
			<br>
			<ul class="tabHead" data-ng-init="tab = 1">
				<li class="tabList" data-ng-class="{active:tab===1}"> 
					<a data-ng-click="tab = 1" class="tabLink" >Details</a>	
				</li>
				<li class="tabList" data-ng-class="{active:tab===2}"> 
					<a data-ng-click="tab = 2" class="tabLink" >Modules</a> 
				</li>
				<li class="tabList" data-ng-class="{active:tab===3}"> 
					<a data-ng-click="tab = 3" class="tabLink" >Team</a> 
				</li>
				<li class="tabList" data-ng-class="{active:tab===4}"> 
					<a data-ng-click="tab = 4" class="tabLink" >Requests</a> 
				</li>
			</ul>
			<br><br>
			<div class="tabBox" data-ng-show="tab === 1">
				<div class="projectDetailsContentBox tabInnerBox">
					<table style="">
						<tr>
							<td class="projectDetailTableFields">
								NAME
							</td>
							<td class="projectDetailTableFieldLabels">
								{{projectData.projName}}
							</td>
						</tr>
						<tr>
							<td class="projectDetailTableFields">
								DESCRIPTION
							</td>
							<td class="projectDetailTableFieldLabels">
								{{projectData.projDesc}}
							</td>
						</tr>
						<tr>
							<td class="projectDetailTableFields">
								CREATED ON
							</td>
							<td class="projectDetailTableFieldLabels">
								{{projectData.dtCreated}}
							</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="tabBox" data-ng-show="tab === 2">
				<div class="tabInnerBox">
				</div>
			</div>
			<div class="tabBox" data-ng-show="tab === 3">
				<%@include file="projectTeam.jsp" %>
			</div>
			<div class="tabBox" data-ng-show="tab === 4">
				<%@include file="../taskList.jsp" %>
			</div>
		</section>
	</fieldset>
	<br>
</body>
</html>