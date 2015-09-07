angular.module('tm-app').controller("issueController", function ($state, $scope, $rootScope, $timeout) {
	console.log("hii");
	$scope.module = $rootScope.selectedModule;
	console.log($scope.module);
	$scope.config = {
	    itemsPerPage: 10,
	    fillLastPage: true
    };
});