angular.module('tm-app').controller("moduleController", function ($scope, $rootScope, $state) {
	$.ajax({
        url: '/tm-web/tmModule/getProjectModules.do?id='+$rootScope.projectId,
        type: 'GET',
        dataType: 'json',
        async: false,
        success: function(data) {
        	$scope.projectModules = data;
        	if(data.length == 0) {
        		$scope.emptyListMessage = "This project does not contain any modules. Lets add some?";
        	} else {
        		$scope.emptyListMessage = "";
        	}
        }
    }).fail(function() {
    	$rootScope.panelMessage = "Could not retrieve the project modules at this moment.";
    	$rootScope.errorBoxFlag = true;
    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
    });
	
	$scope.redirectToProjects = function () {
		$state.go('app.dboard.project');
	};
	
	$scope.addModuleToProject = function(moduleBean) {
		$.ajax({
	        url: '/tm-web/tmModule/addModuleToProject.do?moduleBean='+JSON.stringify(moduleBean),
	        type: 'POST',
	        dataType: 'text',
	        async: false,
	        success: function(data) {
	        	ngDialog.close();
	        	$scope.getProjectModules(moduleBean.projId);
	        }
	    }).fail(function() {
	    	ngDialog.close();
	    	$rootScope.panelMessage = "Could not retrieve the project modules at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
	};
});