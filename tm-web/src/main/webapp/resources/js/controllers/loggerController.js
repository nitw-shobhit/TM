angular.module('tm-app').controller("loggerController", function($scope, $rootScope, $state, $timeout, ngDialog) {
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
	    	$scope.config = {
    		    itemsPerPage: 15,
    		    maxPages: 3,
    		    fillLastPage: false
    	    };
	    	$scope.logs = data;
	    }
	}).fail(function() {
    	$rootScope.panelMessage = "Could not retrieve the logs at this moment.";
    	$rootScope.errorBoxFlag = true;
    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	});
});