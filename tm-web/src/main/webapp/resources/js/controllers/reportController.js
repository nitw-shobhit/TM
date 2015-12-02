angular.module('tm-app').controller("reportController", function($scope, $rootScope, $state, $timeout, ngDialog) {
	
	$scope.openSelectProjectBox = function() {
		$.ajax({
			url: '/tm-web/tmProject/getAllUserProjects.do?id='+ $rootScope.userBean.id,
    	    type: 'GET',
    	    dataType: 'json',
    	    async: false,
	        success: function(data) {
	        	var popupData = {"project" : data};
	        	ngDialog.open({
        			template: 'selectProject',
        			className: 'ngdialog-theme-default selectProject',
        			scope: $scope,
        			data: popupData,
        			preCloseCallback: function(value) {
        				return true;
        			}
        		});
	        }
	    }).fail(function() {
	    	ngDialog.close();
	    	$rootScope.panelMessage = "Could not retrieve the project list at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
		
	};
	
	$scope.closeSelectProjectBox = function() {
		ngDialog.close();
	};
});