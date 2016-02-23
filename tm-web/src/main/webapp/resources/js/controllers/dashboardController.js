angular.module('tm-app').controller("dashboardController", function($scope, $rootScope, $state, $timeout) {

	$scope.openApplication = function(appType) {
		if(appType == 'Projects') {
			$state.go('app.dboard.project');
		} else if(appType == 'Calendar') {
			$state.go('app.dboard.calendar');
		} else if(appType == 'Reports') {
			$state.go('app.dboard.report');
		} else if(appType == 'Notifications') {
			$state.go('app.dboard.notification');
		} else if(appType == 'Logs') {
			$state.go('app.dboard.log');
		} else {
			$rootScope.panelMessage = "This feature is currently not supported";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		}
	};
	
	$scope.test = function() {
		console.log("ACTION CALLED!!");
	}
});