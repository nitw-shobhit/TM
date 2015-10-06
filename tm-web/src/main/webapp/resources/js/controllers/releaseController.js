angular.module('tm-app').controller("releaseController", function ($scope, $state, $rootScope) {
	getReleasesByModuleId($scope.moduleId);
	
	$scope.getReleasesByModule = function(moduleId) {
		getReleasesByModuleId(moduleId);
	};
	
	function getReleasesByModuleId(moduleId) {
		$.ajax({
		    url: '/tm-web/tmIssue/getIssuesByModule.do?moduleId='+moduleId,
		    type: 'GET',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	$scope.issues = data;
		    	for(var index1 = 0; index1 < $scope.issues.length; index1 ++) {
		    		var isSubscribed = false;
		    		for(var index2 = 0; index2 < $scope.issues[index1].issSubscribe.length; index2 ++) {
		    			if($scope.issues[index1].issSubscribe[index2].userId == $rootScope.userBean.id) {
		    				isSubscribed = true;
		    				break;
		    			}
		    		}
		    		$scope.issues[index1].issSubscribed = isSubscribed;
		    	}
		    	
		    	$scope.config = {
	    		    itemsPerPage: 10,
	    		    fillLastPage: false
	    	    };
		    }
		}).fail(function() {
	    	$rootScope.panelMessage = "Could not retrieve the issues at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
});