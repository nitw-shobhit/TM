angular.module('tm-app').controller("internalController", function ($state, $scope, $translate) {
	
	$scope.locale = "en";
	
	$scope.setLocale = function (locale) {
		$scope.locale = locale;
		console.log(locale);
		$translate.use(locale);
	};
	
	$scope.showAboutMe = function() {
		$state.go('app.dboard.about');
	};
});