angular.module('tm-app').controller("issueController", function ($state, $scope, $rootScope, $timeout, ngDialog) {
	$scope.moduleId = $rootScope.selectedModule;
	var statusArray = ["ACCEPTED", "REJECTED", "CANCELLED", "REOPENED", "FIXED", "COMPLETED"];
	
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
	
	$scope.openAddIssueBox = function() {
		var newIssueData = {
			"issOwnerString" : $rootScope.userBean.userId,
			"issPriority" : "Choose one"
		};
		ngDialog.open({
			template: 'addIssue',
			className: 'ngdialog-theme-default addIssue',
			scope: $scope,
			data: newIssueData,
			preCloseCallback: function(value) {
				return true;
			}
		});
	};
	
	$scope.addIssueToModule = function(issueBean) {
		issueBean.modId = $scope.moduleId;
		issueBean.issOwner = $rootScope.userBean.id;
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
		    	data.issSubscribed = true;
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
	
	$scope.viewIssueStatus = function(issueBean) {
		ngDialog.open({
			template: 'viewIssueStatus',
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
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	issueBean.issStatus=statusArray[0];
		    	issueBean.issHistory.push(data);
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
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	issueBean.issStatus=statusArray[1];
		    	issueBean.issHistory.push(data);
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
		    	issueBean.issStatus=statusArray[2];
		    	issueBean.issHistory.push(data);
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
		    	issueBean.issStatus=statusArray[3];
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
		    	issueBean.issStatus=statusArray[4];
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
		    	issueBean.issStatus=statusArray[5];
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not reject the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.removeIssueSubscription = function(issueBean) {
		var issueSubscribeId = null;
		var issueIndex = -1;
		for(var index = 0; index < issueBean.issSubscribe.length; index ++) {
			if(issueBean.issSubscribe[index].userId == $rootScope.userBean.id) {
				issueSubscribeId = issueBean.issSubscribe[index].id;
				issueIndex = index;
				break;
			}
		}
		
		$.ajax({
		    url: '/tm-web/tmSubscribeIssue/removeSubscription.do?issueSubscribeId='+issueSubscribeId,
		    type: 'POST',
		    async: false,
		    success: function(data) {
		    	issueBean.issSubscribe.splice(issueIndex, 1);
		    	issueBean.issSubscribed = !issueBean.issSubscribed;
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not reject the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.addIssueSubscription = function(issueBean) {
		$.ajax({
		    url: '/tm-web/tmSubscribeIssue/addSubscription.do?userId='+$rootScope.userBean.id + '&issueId='+issueBean.id,
		    type: 'POST',
		    async: false,
		    dataType: 'json',
		    success: function(data) {
		    	issueBean.issSubscribe.push(data);
		    	issueBean.issSubscribed = !issueBean.issSubscribed;
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not reject the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
});