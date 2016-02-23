/**
 * New JS file
 */
function redirectTo(location) {
	window.location.href = location;
}

function windowSetup() {
	window.open("index.jsp", "TM_APP", "width=1100, height=1200, toolbar=no, scrollbars=yes");
	window.opener.close();
}