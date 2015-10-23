angular.module('tm-app').controller("dashboardController", function($scope, $rootScope, $state, $timeout) {

	$scope.openApplication = function(appType) {
		if(appType == 'Projects') {
			$state.go('app.dboard.project');
		} else if(appType == 'Calendar') {
			$state.go('app.dboard.calendar');
		} else {
			$rootScope.panelMessage = "This feature is currently not supported";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		}
	};
});