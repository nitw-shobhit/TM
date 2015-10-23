angular.module('tm-app').controller("rootController", function($scope, $rootScope, $state, $timeout, localStorageService) {

	$scope.closePanel = function() {
		$rootScope.successBoxFlag = false;
		$rootScope.errorBoxFlag = false;
		$rootScope.panelMessage = "";
	};
	
	$scope.redirectToProjects = function () {
		$state.go('app.dboard.project');
	};
	
	$scope.redirectToMyApps = function () {
		$state.go('app.dboard');
	};
	
});