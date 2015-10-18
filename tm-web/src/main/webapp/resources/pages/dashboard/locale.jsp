<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TM</title>
</head>
<body>
	<div style="float: left;" data-ng-controller="internalController">
		<div class="btn-group" role="group" aria-label="...">
			<div class="btn-group" role="group">
			    <a class="dropdown-toggle" style="margin-left: 10px;" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" ><span style="font-size:25px; color: #0000A0;" class="glyphicon glyphicon-globe"></span></a>
			    <div class="dropdown-menu" style="font-size: 11px;">
					<table style="margin: 5px;">
						<tr>
							<td>
								<span data-ng-show="locale == 'en'" class="glyphicon glyphicon-ok" style="font-size:10px; color: green;"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<span class="flag-icon flag-icon-gb"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<a data-ng-click="setLocale('en')">English</a>
							</td>
						</tr>
						<tr>
							<td>
								<span data-ng-show="locale == 'es'" class="glyphicon glyphicon-ok" style="font-size:10px; color: green;"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<span class="flag-icon flag-icon-es"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<a data-ng-click="setLocale('es')">Spanish</a>
							</td>
						</tr>
						<tr>
							<td>
								<span data-ng-show="locale == 'fr'" class="glyphicon glyphicon-ok" style="font-size:10px; color: green;"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<span class="flag-icon flag-icon-fr"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<a data-ng-click="setLocale('fr')">French</a>
							</td>
						</tr>
						<tr>
							<td>
								<span data-ng-show="locale == 'it'" class="glyphicon glyphicon-ok" style="font-size:10px; color: green;"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<span class="flag-icon flag-icon-it"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<a data-ng-click="setLocale('it')">Italian</a>
							</td>
						</tr>
						<tr>
							<td>
								<span data-ng-show="locale == 'cs'" class="glyphicon glyphicon-ok" style="font-size:10px; color: green;"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<span class="flag-icon flag-icon-cz"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<a data-ng-click="setLocale('cs')">Czech</a>
							</td>
						</tr>
						<tr>
							<td>
								<span data-ng-show="locale == 'hi'" class="glyphicon glyphicon-ok" style="font-size:10px; color: green;"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<span class="flag-icon flag-icon-in"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<a data-ng-click="setLocale('hi')">Hindi</a>
							</td>
						</tr>
						<tr>
							<td>
								<span data-ng-show="locale == 'ja'" class="glyphicon glyphicon-ok" style="font-size:10px; color: green;"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<span class="flag-icon flag-icon-jp"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<a data-ng-click="setLocale('ja')">Japanese</a>
							</td>
						</tr>
						<tr>
							<td>
								<span data-ng-show="locale == 'ko'" class="glyphicon glyphicon-ok" style="font-size:10px; color: green;"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<span class="flag-icon flag-icon-kr"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<a data-ng-click="setLocale('ko')">Korean</a>
							</td>
						</tr>
						<tr>
							<td>
								<span data-ng-show="locale == 'ru'" class="glyphicon glyphicon-ok" style="font-size:10px; color: green;"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<span class="flag-icon flag-icon-ru"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<a data-ng-click="setLocale('ru')">Russian</a>
							</td>
						</tr>
						<tr>
							<td>
								<span data-ng-show="locale == 'cn'" class="glyphicon glyphicon-ok" style="font-size:10px; color: green;"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<span class="flag-icon flag-icon-cn"></span>
							</td>
							<td style="text-align: left; padding-left:5px;">
								<a data-ng-click="setLocale('cn')">Chinese</a>
							</td>
						</tr>
					</table>
			    </div>
			</div>
		</div>
	</div>
</body>
</html>