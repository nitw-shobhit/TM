angular.module('tm-app').controller("rootController", function($scope, $rootScope) {
	$scope.closePanel = function() {
		$rootScope.successBoxFlag = false;
		$rootScope.errorBoxFlag = false;
		$rootScope.panelMessage = "";
	};
});