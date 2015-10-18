angular.module('tm-app').controller("releaseController", function ($scope, $state, $rootScope, $timeout) {
	$scope.moduleId = $rootScope.selectedModule;
	getReleasesByModuleId($scope.moduleId);
	
	$scope.getReleasesByModule = function(moduleId) {
		getReleasesByModuleId(moduleId);
	};
	
	$scope.openAddReleaseBox = function() {
		ngDialog.open({
			template: 'addRelease',
			className: 'ngdialog-theme-default addIssue',
			preCloseCallback: function(value) {
				return true;
			}
		});
	};
	
	$scope.exportReleases = function(moduleId) {
		
	};
	
	$scope.getReleasesByModule = function(moduleId) {
		
	};
	
	$scope.viewRelease = function(releaseBean) {
		
	};
	
	function getReleasesByModuleId(moduleId) {
		$.ajax({
		    url: '/tm-web/tmRelease/getReleasesByModule.do?moduleId='+moduleId,
		    type: 'GET',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	$scope.releases = data;
		    	$scope.config = {
	    		    itemsPerPage: 10,
	    		    fillLastPage: false
	    	    };
		    }
		}).fail(function() {
	    	$rootScope.panelMessage = "Could not retrieve the releases at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
});