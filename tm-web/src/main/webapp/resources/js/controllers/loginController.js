angular.module('tm-app').controller("loginController", function ($scope, $state, $rootScope, $timeout) {
	$scope.userId = "A10000";
	$scope.userPass = "A10000";
	$scope.login = function() {
		var userBean = {
			"userId" : $scope.userId,
			"userPass" : $scope.userPass
		};
		$.ajax({
		    url: '/tm-web/tmLogin/validateLogin.do?userBean='+JSON.stringify(userBean),
		    type: 'GET',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	$rootScope.userBean = data;
		    	$rootScope.panelMessage = "Welcome back " + data.userName + ". Nice to see you again!!";
		    	$rootScope.successBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		    	$state.go('app.dboard');
		    }
		}).fail(function() {
	    	$rootScope.panelMessage = "Could not validate the user.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.loginFacebook = function() {
		$rootScope.panelMessage = "This feature is currently not supported";
    	$rootScope.errorBoxFlag = true;
    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	};
	
	$scope.register = function() {
		$rootScope.panelMessage = "This feature is currently not supported";
    	$rootScope.errorBoxFlag = true;
    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	};
});