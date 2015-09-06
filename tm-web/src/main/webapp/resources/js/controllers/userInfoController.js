angular.module('tm-app').controller("userInfoController", function ($scope, $state, ngDialog, $rootScope, $timeout) {

	$scope.logout = function() {
		$state.go('app');
	};
	
	$scope.openProfileBox = function() {
		ngDialog.open({
			template: 'userProfile',
			data: $rootScope.userBean,
			className: 'ngdialog-theme-default profileBox',
			controller: 'userInfoController',
			preCloseCallback: function(value) {
				return true;
			}
		});
	};
	
	$scope.updateProfile = function(userBean) {
		
		$.ajax({
		    url: '/tm-web/tmUser/updateUserProfile.do?userBean='+JSON.stringify(userBean),
		    type: 'POST',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	$rootScope.userBean = data;
		    	ngDialog.close();
				$rootScope.panelMessage = "User profile updated.";
				$rootScope.successBoxFlag = true;
				$timeout( function(){ $rootScope.autoHide(); }, 2000);
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not update user profile at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.changePassword = function() {
		
		$.ajax({
		    url: '/tm-web/tmUser/changePassword.do?password='+$scope.ngDialogData.confirmNewPassword+'&id='+$rootScope.userBean.id,
		    type: 'POST',
		    dataType: 'text',
		    async: false,
		    success: function(data) {
		    	ngDialog.close();
		    	$rootScope.userBean.userPass = data;
		    	console.log($rootScope.userBean.userPass);
		    	$rootScope.panelMessage = "Password updated.";
				$rootScope.successBoxFlag = true;
				$timeout( function(){ $rootScope.autoHide(); }, 2000);
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not update user password at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.requestAdminPrivilege = function() {
		
		$.ajax({
		    url: '/tm-web/tmUser/requestAdminPrivilege.do?id='+$rootScope.userBean.id,
		    type: 'POST',
		    dataType: 'text',
		    async: false,
		    success: function(data) {
		    	$scope.requestMessage = "Raised a privilege request with id : "+data;
		    	$scope.requestSuccess=true;
		    }
		}).fail(function() {
	    	$scope.requestMessage = "Could not send your request at this moment.";
	    	$scope.requestSuccess=true;
		});
	};
});