angular.module('tm-app').controller("loggerController", function($scope, $rootScope, $state, $timeout, ngDialog, ngTableParams, $filter) {
	$scope.config = {
		    itemsPerPage: 15,
		    maxPages: 3,
		    fillLastPage: false
    };
	$scope.logs = {};
	$.ajax({
	    url: '/tm-web/tmLogger/getLogs.do',
	    type: 'GET',
	    dataType: 'json',
	    async: false,
	    success: function(data) {
	    	if(data.length == 0) {
	    		$rootScope.panelMessage = "Logging is currently turned off!!";
	        	$rootScope.errorBoxFlag = true;
	        	$timeout( function(){ $rootScope.autoHide(); }, 5000);
	    	} else {
		    	$scope.logs = data;
		    	$scope.tableParams = new ngTableParams({
	                page: 1,
	                count: 12
	            }, {
	                total: $scope.logs.length,
	                counts:[],
	                getData: function ($defer, params) {
	            	   $scope.data = params.sorting() ? $filter('orderBy')($scope.logs, params.orderBy()) : $scope.logs;
	            	   $scope.data = params.filter() ? $filter('filter')($scope.data, params.filter()) : $scope.data;
	            	   $scope.data = $scope.data.slice((params.page() - 1) * params.count(), params.page() * params.count());
	            	   $defer.resolve($scope.data);
	            	}
	            });
	    	}
	    }
	}).fail(function() {
    	$rootScope.panelMessage = "Could not retrieve the logs at this moment.";
    	$rootScope.errorBoxFlag = true;
    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	});
});