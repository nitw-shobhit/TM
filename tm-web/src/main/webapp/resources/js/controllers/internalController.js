angular.module('tm-app').controller("internalController", function ($state, $scope) {
	$scope.showAboutMe = function() {
		$state.go('app.dboard.about');
	}
});