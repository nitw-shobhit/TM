angular.module('tm-app').controller("issueController", function ($state, $scope, $rootScope, $timeout, ngDialog) {
	$scope.moduleId = $rootScope.selectedModule;
	var statusArray = [
			{id : "ACCEPTED", coordinates : {height : 33, width : 65, top : 148, left : 224}},
			{id : "REJECTED", coordinates : {height : 33, width : 72, top : 292, left : 395}},
			{id : "CANCELLED", coordinates : {height : 0, width : 0, top : 0, left : 0}},
			{id : "REOPENED", coordinates : {height : 33, width : 80, top : 220, left : 597}},
			{id : "FIXED", coordinates : {height : 33, width : 72, top : 148, left : 395}},
			{id : "COMPLETED", coordinates : {height : 33, width : 79, top : 148, left : 644}}
	];
	
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
		var btns = checkButtonAccess(issueBean);
		var data = {
			"issueBean" : issueBean,
			"btns" : btns
		}
		ngDialog.open({
			template: 'viewIssue',
			className: 'ngdialog-theme-default viewIssue',
			data: data,
			scope: $scope,
			preCloseCallback: function(value) {
				return true;
			}
		});
	};
	
	$scope.viewIssueStatus = function(issueBean) {
		issueBean.config = {
		    itemsPerPage: 6,
		    fillLastPage: false
	    };
		issueBean.statusList=[];
		var tempStatus = {};
		for(var index = 0; index < issueBean.issHistory.length; index ++ ) {
			tempStatus = {
				status : issueBean.issHistory[index].hisContent,
				date : issueBean.issHistory[index].hisCreated
			};
			issueBean.statusList.push(tempStatus);
		}
		ngDialog.open({
			template: 'viewIssueStatus',
			className: 'ngdialog-theme-default viewIssueStatus',
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
	
	$scope.acceptIssue = function(ngDialogData) {
		$.ajax({
		    url: '/tm-web/tmIssue/acceptIssue.do?id='+ngDialogData.issueBean.id,
		    type: 'POST',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	ngDialogData.issueBean.issStatus=statusArray[0].id;
		    	ngDialogData.issueBean.issStatusCoordinates = statusArray[0].coordinates;
		    	ngDialogData.issueBean.issHistory.push(data);
		    	ngDialogData.btns = checkButtonAccess(ngDialogData.issueBean);
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not accept the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.rejectIssue = function(ngDialogData) {
		$.ajax({
		    url: '/tm-web/tmIssue/rejectIssue.do?id='+ngDialogData.issueBean.id,
		    type: 'POST',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	ngDialogData.issueBean.issStatus=statusArray[1].id;
		    	ngDialogData.issueBean.issStatusCoordinates = statusArray[1].coordinates;
		    	ngDialogData.issueBean.issHistory.push(data);
		    	ngDialogData.btns = checkButtonAccess(ngDialogData.issueBean);
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not reject the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.openReassignIssueBox = function(ngDialogData) {
		
	};
	
	$scope.removeIssue = function(ngDialogData) {
		$.ajax({
		    url: '/tm-web/tmIssue/removeIssue.do?id='+ngDialogData.issueBean.id,
		    type: 'POST',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	ngDialogData.issueBean.issStatus=statusArray[2].id;
		    	ngDialogData.issueBean.issStatusCoordinates = statusArray[2].coordinates;
		    	ngDialogData.issueBean.issHistory.push(data);
		    	ngDialogData.btns = checkButtonAccess(ngDialogData.issueBean);
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not cancel the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.reOpenIssue = function(ngDialogData) {
		$.ajax({
		    url: '/tm-web/tmIssue/reOpenIssue.do?id='+ngDialogData.issueBean.id,
		    type: 'POST',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	ngDialogData.issueBean.issStatus=statusArray[3].id;
		    	ngDialogData.issueBean.issStatusCoordinates = statusArray[3].coordinates;
		    	ngDialogData.issueBean.issHistory.push(data);
		    	ngDialogData.btns = checkButtonAccess(ngDialogData.issueBean);
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not reopen the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.markIssueAsFixed = function(ngDialogData) {
		$.ajax({
		    url: '/tm-web/tmIssue/fixIssue.do?id='+ngDialogData.issueBean.id,
		    type: 'POST',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	ngDialogData.issueBean.issStatus=statusArray[4].id;
		    	ngDialogData.issueBean.issStatusCoordinates = statusArray[4].coordinates;
		    	ngDialogData.issueBean.issHistory.push(data);
		    	ngDialogData.btns = checkButtonAccess(ngDialogData.issueBean);
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not mark the issue as fixed, at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.completeIssue = function(ngDialogData) {
		$.ajax({
		    url: '/tm-web/tmIssue/completeIssue.do?id='+ngDialogData.issueBean.id,
		    type: 'POST',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	ngDialogData.issueBean.issStatus=statusArray[5].id;
		    	ngDialogData.issueBean.issStatusCoordinates = statusArray[5].coordinates;
		    	ngDialogData.issueBean.issHistory.push(data);
		    	ngDialogData.btns = checkButtonAccess(ngDialogData.issueBean);
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not complete the issue at this moment.";
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
	    	$rootScope.panelMessage = "Could not unsubscribe from the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	function checkButtonAccess(issueBean) {
		var status = issueBean.issStatus;
		var btns = {
			"btnAccept" : false,
			"btnReject" : false,
			"btnReassign" : false,
			"btnRemove" : false,
			"btnReopen" : false,
			"btnFixed" : false,
			"btnComplete" : false,
		};
		if(status === "OPEN") {
			btns.btnReopen = true;
		}
		else if(status === "ACCEPTED") {
			btns.btnAccept = true;
			btns.btnReopen = true;
		}
		else if(status === "REJECTED") {
			btns.btnReject = true;
		}
		else if(status === "CANCELLED") {
			btns.btnRemove = true;
			btns.btnAccept = true;
			btns.btnReject = true;
			btns.btnReassign = true;
			btns.btnFixed = true;
			btns.btnReopen = true;
			btns.btnComplete = true;
		}
		else if(status === "FIXED") {
			btns.btnFixed = true;
			btns.btnAccept = true;
			btns.btnReject = true;
			btns.btnReassign = true;
			btns.btnReopen = true;
			btns.btnRemove = true;
		}
		else if(status === "REOPENED") {
			btns.btnReopen = true;
		}
		else if(status === "COMPLETED") {
			btns.btnRemove = true;
			btns.btnAccept = true;
			btns.btnReject = true;
			btns.btnReassign = true;
			btns.btnFixed = true;
			btns.btnReopen = true;
			btns.btnComplete = true;
		}
		
		return btns;
	}
	
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
	    	$rootScope.panelMessage = "Could not subscribe to the issue at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
});