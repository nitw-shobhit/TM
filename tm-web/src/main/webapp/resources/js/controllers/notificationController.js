angular.module('tm-app').controller("notificationController", function ($state, $scope, $rootScope, $timeout, ngDialog, $interval) {
	 getUserNotifications($rootScope.userBean.id);
	 $scope.rand = 0;

	 //Refresh notifications every 2 minutes.
	 //Currently turned off.
//	 function autoUpdateNotifications() {
//		 getUserNotifications($rootScope.userBean.id);
//	 }
//	 
//	 $interval(autoUpdateNotifications, 120000);
	
	$scope.loadNotifications = function() {
		$state.go('app.dboard.notification');
	};
	
	$scope.getUserNotifications = function() {
		getUserNotifications($rootScope.userBean.id);
	};
	
	$scope.viewNotification = function(notificationBean) {
		var notificationIds = [];
		notificationIds.push(notificationBean.id);
		if(notificationBean.notIsUnread) {
			$.ajax({
			    url: '/tm-web/tmNotification/markNotificationsAsRead.do?notificationIds='+JSON.stringify(notificationIds),
			    type: 'POST',
			    async: false,
			    success: function(data) {
			    	$rootScope.countUnreadNotifications = $rootScope.countUnreadNotifications - 1;
			    	notificationBean.notIsUnread = false;
			    }
			}).fail(function() {
		    	$rootScope.panelMessage = "Could not mark the notification as read at this moment.";
		    	$rootScope.errorBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
			});
		}
		
		ngDialog.open({
			template: 'notificationInfo',
			data: notificationBean,
			className: 'ngdialog-theme-default notificationInfo',
			scope: $scope,
			preCloseCallback: function(value) {
				return true;
			}
		});
	};
	
	$scope.toggleNoficationSelection = function(selected, notificationBean) {
		if(selected) {
			$scope.selectedNotifications.push(notificationBean.id);
		} else {
			for(var index = 0; index < $scope.selectedNotifications.length; index ++) {
				if(notificationBean.id == $scope.selectedNotifications[index]) {
					$scope.selectedNotifications.splice(index, 1);
					break;
				}
			}
		}
	};
	
	$scope.deleteSelectedNotifications = function() {
		if($scope.archivedNotifications.length == 0) {
			$rootScope.panelMessage = "There are no notifications to delete.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		}
		else if($scope.selectedNotifications.length == 0) {
			$rootScope.panelMessage = "No notifications selected.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		} else {
			$.ajax({
			    url: '/tm-web/tmNotification/deleteUserNotifications.do?notificationIds='+JSON.stringify($scope.selectedNotifications),
			    type: 'POST',
			    async: false,
			    success: function(data) {
			    	var tempNotifications = $scope.archivedNotifications;
			    	for(var index = 0; index < tempNotifications.length; index ++) {
			    		if($.inArray(tempNotifications[index].id, $scope.selectedNotifications) != -1) {
			    			$scope.archivedNotifications.splice(index, 1);
			    			index --;
			    		}
			    	}
			    	$scope.selectedNotifications = [];
			    	$rootScope.panelMessage = "Selected notifications deleted successfully.";
			    	$rootScope.successBoxFlag = true;
			    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
			    }
			}).fail(function() {
		    	$rootScope.panelMessage = "Could not delete the notifications at this moment.";
		    	$rootScope.errorBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
			});
		}
	};
	
	$scope.archiveSelectedNotifications = function() {
		if($scope.notifications.length == 0) {
			$rootScope.panelMessage = "There are no notifications to archive.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		}
		else if($scope.selectedNotifications.length == 0) {
			$rootScope.panelMessage = "No notifications selected.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		} else {
			$.ajax({
			    url: '/tm-web/tmNotification/archiveUserNotifications.do?notificationIds='+JSON.stringify($scope.selectedNotifications),
			    type: 'POST',
			    async: false,
			    success: function(data) {
			    	$rootScope.countUnreadNotifications = 0;
			    	var tempNotifications = $scope.notifications;
			    	for(var index = 0; index < tempNotifications.length; index ++) {
			    		if($.inArray(tempNotifications[index].id, $scope.selectedNotifications) != -1) {
			    			$scope.notifications.splice(index, 1);
			    			index --;
			    		} else {
			    			if(tempNotifications[index].notIsUnread) {
				    			$rootScope.countUnreadNotifications = $rootScope.countUnreadNotifications + 1;
				    		}
			    		}
			    	}
			    	$scope.selectedNotifications = [];
			    	$rootScope.panelMessage = "Selected notifications archived successfully.";
			    	$rootScope.successBoxFlag = true;
			    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
			    }
			}).fail(function() {
		    	$rootScope.panelMessage = "Could not archive the notifications at this moment.";
		    	$rootScope.errorBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
			});
		}
	};
	
	$scope.unArchiveSelectedNotifications = function() {
		if($scope.archivedNotifications.length == 0) {
			$rootScope.panelMessage = "There are no notifications to un-archive.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		}
		else if($scope.selectedNotifications.length == 0) {
			$rootScope.panelMessage = "No notifications selected.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		} else {
			$.ajax({
			    url: '/tm-web/tmNotification/unArchiveUserNotifications.do?notificationIds='+JSON.stringify($scope.selectedNotifications),
			    type: 'POST',
			    async: false,
			    success: function(data) {
			    	var tempNotifications = $scope.archivedNotifications;
			    	for(var index = 0; index < tempNotifications.length; index ++) {
			    		if($.inArray(tempNotifications[index].id, $scope.selectedNotifications) != -1) {
			    			if(tempNotifications[index].notIsUnread) {
				    			$rootScope.countUnreadNotifications = $rootScope.countUnreadNotifications + 1;
				    		}
			    			$scope.archivedNotifications.splice(index, 1);
			    			index --;
			    		}
			    	}
			    	$scope.selectedNotifications = [];
			    	$rootScope.panelMessage = "Selected notifications un-archived successfully.";
			    	$rootScope.successBoxFlag = true;
			    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
			    }
			}).fail(function() {
		    	$rootScope.panelMessage = "Could not un-archive the notifications at this moment.";
		    	$rootScope.errorBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
			});
		}
	};
	
	$scope.markAsReadSelectedNotifications = function(flag) {
		if(flag == 'inbox') {
			var tempNotifications = $scope.notifications;
		} else {
			var tempNotifications = $scope.archivedNotifications;
		}
		if(tempNotifications.length == 0) {
			$rootScope.panelMessage = "There are no notifications to mark.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		}
		else if($scope.selectedNotifications.length == 0) {
			$rootScope.panelMessage = "No notifications selected.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		} else {			
			$.ajax({
			    url: '/tm-web/tmNotification/markNotificationsAsRead.do?notificationIds='+JSON.stringify($scope.selectedNotifications),
			    type: 'POST',
			    async: false,
			    datatype: 'text',
			    success: function(data) {
			    	if(data == 'Success') {
			    		for(var index = 0; index < tempNotifications.length; index ++) {
				    		if($.inArray(tempNotifications[index].id, $scope.selectedNotifications) != -1 &&
				    				tempNotifications[index].notIsUnread) {
				    			tempNotifications[index].notIsUnread = false;
				    			if(flag == 'inbox') {
				    				$rootScope.countUnreadNotifications = $rootScope.countUnreadNotifications - 1;
				    			}
				    		}
				    	}
				    	$scope.selectedNotifications = [];
				    	$rootScope.panelMessage = "Selected notifications marked as read successfully.";
				    	$rootScope.successBoxFlag = true;
				    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
			    	} else {
			    		$rootScope.panelMessage = "Selected notifications have already been read.";
				    	$rootScope.errorBoxFlag = true;
				    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
			    	}
			    }
			}).fail(function() {
		    	$rootScope.panelMessage = "Could not mark the notifications as read at this moment.";
		    	$rootScope.errorBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
			});
			
			if(flag == 'inbox') {
				$scope.notifications = tempNotifications;
			} else {
				$scope.archivedNotifications = tempNotifications;
			}
			$scope.selected = false;
		}
	};
	
	$scope.showArchivedNotifications = function () {
		$state.go('app.dboard.notification.archived');
	};
	
	function getUserNotifications(userId) {
		$scope.selectedNotifications = [];
		$scope.notifications = [];
		$scope.archivedNotifications = [];
		$.ajax({
		    url: '/tm-web/tmNotification/getUserNotifications.do?userId='+userId,
		    type: 'GET',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	$rootScope.countUnreadNotifications = 0;
		    	for(var index = 0; index < data.length; index ++) {
		    		if(data[index].visible) {
		    			if(data[index].notIsUnread) {
			    			$rootScope.countUnreadNotifications = $rootScope.countUnreadNotifications + 1;
			    		}
		    			$scope.notifications.push(data[index]);
		    		} else {
		    			$scope.archivedNotifications.push(data[index]);
		    		}
		    	}
		    	$scope.config = {
	    		    itemsPerPage: 10,
	    		    fillLastPage: false
	    	    };
		    }
		}).fail(function() {
	    	$rootScope.panelMessage = "Could not retrieve the notifications at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	}
});