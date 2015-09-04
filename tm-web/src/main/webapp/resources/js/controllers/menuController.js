angular.module('tm-app').controller("menuController", function ($scope, $state) {
	$scope.home = function() {
        $state.go('app.dboard');
	};
	$scope.projects = function() {
        $state.go('app.dboard.project');
	};
	$scope.database = function() {
        $state.go('app.dboard.database');
	};
	$scope.worklist = function() {
        $state.go('app.dboard.worklist');
	};
});