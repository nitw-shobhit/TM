angular.module('tm-app').controller("issueController", function ($state, $scope, $rootScope, $timeout, ngDialog) {
	
	$scope.moduleId = $rootScope.selectedModule;
	getIssuesByModuleId($scope.moduleId);
	
	$scope.getIssuesByModule = function(moduleId) {
		getIssuesByModuleId(moduleId);
	};
	
	function getIssuesByModuleId(moduleId) {
		$.ajax({
		    url: '/tm-web/tmIssue/getIssuesByModule.do?moduleId='+moduleId,
		    type: 'GET',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	$scope.issues = data;
		    	console.log($scope.issues);
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
	
	$scope.openAddIssueBox = function() {
		ngDialog.open({
			template: 'addIssue',
			className: 'ngdialog-theme-default addIssue',
			scope: $scope,
			preCloseCallback: function(value) {
				return true;
			}
		});
	};
	
	$scope.addIssueToModule = function(issueBean) {
		issueBean.modId = $scope.moduleId;
		issueBean.issDueDate = new Date();
		var tempCommentList = [];
		var tempComment = {
			"content" : issueBean.issComment,
			"author" : $rootScope.userBean.userId
		};
		tempCommentList.push(tempComment);
		issueBean.issComments = tempCommentList;
		$.ajax({
		    url: '/tm-web/tmIssue/addIssueToModule.do?issueBean='+JSON.stringify(issueBean),
		    type: 'POST',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	$scope.issues.push(data);
		    	ngDialog.close();
		    	$rootScope.panelMessage = "New issue added successfully.";
				$rootScope.successBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		    }
		}).fail(function() {
	    	$rootScope.panelMessage = "Could not retrieve the issues at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
});