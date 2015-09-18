angular.module('tm-app').controller("issueController", function ($state, $scope, $rootScope, $timeout, ngDialog) {
	console.log("issueController");
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
		issueBean.issOwner = $rootScope.userBean.id;
		issueBean.issOwnerString = $rootScope.userBean.userId;
		var tempCommentList = [];
		var tempComment = {
			"comContent" : issueBean.issComment,
			"userId" : $rootScope.userBean.id
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
	
	$scope.viewIssue = function(issueBean) {
		ngDialog.open({
			template: 'viewIssue',
			className: 'ngdialog-theme-default viewIssue',
			data: issueBean,
			scope: $scope,
			preCloseCallback: function(value) {
				return true;
			}
		});
	};
	
	$scope.addCommentToIssue = function(issueBean) {
		var newComment = {
			"comContent" : issueBean.newComment,
			"issId" : issueBean.id,
			"userId" : $rootScope.userBean.id
		};
		
		$.ajax({
		    url: '/tm-web/tmCommentIssue/addCommentToIssue.do?issueCommentBean='+JSON.stringify(newComment),
		    type: 'POST',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	issueBean.newComment="";
		    	issueBean.issComments.push(data);
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not add the comment at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.acceptIssue = function(issueBean) {
		
		$.ajax({
		    url: '/tm-web/tmIssue/acceptIssue.do?id='+issueBean.id,
		    type: 'POST',
		    async: false,
		    success: function(data) {
		    	issueBean.issStatus="ACCEPTED";
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not accept the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.rejectIssue = function(issueBean) {
		
		$.ajax({
		    url: '/tm-web/tmIssue/rejectIssue.do?id='+issueBean.id,
		    type: 'POST',
		    async: false,
		    success: function(data) {
		    	issueBean.issStatus="REJECTED";
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not reject the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.openReassignIssueBox = function(issueId) {
		
	};
	
	$scope.removeIssue = function(issueBean) {
		
		$.ajax({
		    url: '/tm-web/tmIssue/removeIssue.do?id='+issueBean.id,
		    type: 'POST',
		    async: false,
		    success: function(data) {
		    	issueBean.issStatus="CANCELLED";
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not cancel the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.reOpenIssue = function(issueBean) {
		
		$.ajax({
		    url: '/tm-web/tmIssue/reOpenIssue.do?id='+issueBean.id,
		    type: 'POST',
		    async: false,
		    success: function(data) {
		    	issueBean.issStatus="REOPENED";
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not reopen the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.markIssueAsFixed = function(issueBean) {
		
		$.ajax({
		    url: '/tm-web/tmIssue/rejectIssue.do?id='+issueBean.id,
		    type: 'POST',
		    async: false,
		    success: function(data) {
		    	issueBean.issStatus="REJECTED";
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not reject the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.completeIssue = function(issueBean) {
		
		$.ajax({
		    url: '/tm-web/tmIssue/completeIssue.do?id='+issueBean.id,
		    type: 'POST',
		    async: false,
		    success: function(data) {
		    	issueBean.issStatus="COMPLETED";
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not reject the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
});