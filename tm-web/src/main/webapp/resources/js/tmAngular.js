/**
 * Angular file
 */
var module = angular.module('tm-app', ['ui.router', 'ngDialog', 'pascalprecht.translate', 'ui.bootstrap', 'angular-table', 'angularTreeview', 'ngAnimate', 'cgBusy']);

//ROOT SCOPE ELEMENTS
module.run(function($rootScope) {
	$rootScope.successBoxFlag = false;
    $rootScope.errorBoxFlag = false;
    $rootScope.panelMessage = "";
    $rootScope.delay = 0;
    $rootScope.minDuration = 0;
    $rootScope.message = 'Loading...';
    $rootScope.backdrop = true;
    $rootScope.promise = null;
	$rootScope.userBean = null;
	
	$rootScope.autoHide = function() {
	    $rootScope.successBoxFlag = false;
	    $rootScope.errorBoxFlag = false;
	    $rootScope.panelMessage = "";
	}
})

//STATE ROUTES
module.config(function ($stateProvider, $urlRouterProvider, $provide) {
	$stateProvider.state('dboard',
		{
			url: "",
			views: {
				'menu' : {
					templateUrl : '../resources/pages/dashboard/menu.jsp',
					controller : 'menuController'
				},
				'content' : {
					templateUrl : '../resources/pages/home.jsp',
						controller : 'homeController'
				}
			}
		}
	)
  	.state('dboard.project',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : '../resources/pages/projects.jsp',
					controller : 'projectController'
				}
			}
		}
  	)
  	.state('dboard.project.schema',
  		{
	  		url: "",
			views: {
				'schema' : {
					templateUrl : '../resources/pages/schema.jsp',
					controller : 'projectController'
				}
			}
  		}
  	)
  	.state('dboard.settings',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : '../resources/pages/settings.jsp'
				}
			}
		}
  	)
	.state('dboard.help',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : '../resources/pages/help.jsp'
				}
			}
		}
  	);
	$urlRouterProvider.otherwise("");
});

//SERVICES



//DIRECTIVES



//CONTROLLERS
module.controller("rootController", function ($scope, $rootScope) {
	
	$scope.closePanel = function() {
    	$rootScope.successBoxFlag = false;
        $rootScope.errorBoxFlag = false;
        $rootScope.panelMessage = "";
    };
});

module.controller("menuController", function ($scope, $state) {
	$scope.home = function() {
        $state.go('dboard');
	};
	$scope.projects = function() {
        $state.go('dboard.project');
	};
	$scope.database = function() {
        $state.go('dboard.database');
	};
	$scope.worklist = function() {
        $state.go('dboard.worklist');
	};
});

module.controller("userInfoController", function ($scope, $state, ngDialog, $rootScope, $timeout) {

	$.ajax({
	    url: '/tm-web/tmLogin/getUserDetails.do',
	    type: 'GET',
	    dataType: 'json',
	    async: false,
	    success: function(data) {
	    	$rootScope.userBean = data;
	    }
	}).fail(function() {
		ngDialog.close();
		
    	$rootScope.panelMessage = "Could not retrieve user information at this moment."
    	$rootScope.errorBoxFlag = true;
    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	});
	
	$scope.logout = function() {
		window.location.href="/tm-web/login.jsp";
	};
	
	$scope.openProfileBox = function() {
		ngDialog.open({
			template: 'userProfile',
			data: $rootScope.userBean,
			className: 'ngdialog-theme-default profileBox',
			controller: 'userInfoController',
			preCloseCallback: function(value) {
				return true;
			}
		});
	}
	
	$scope.updateProfile = function(userBean) {
		
		$.ajax({
		    url: '/tm-web/tmUser/updateUserProfile.do?userBean='+JSON.stringify(userBean),
		    type: 'POST',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	$rootScope.userBean = data;
		    	ngDialog.close();
				$rootScope.panelMessage = "User profile updated."
				$rootScope.successBoxFlag = true;
				$timeout( function(){ $rootScope.autoHide(); }, 2000);
		    }
		}).fail(function() {
			ngDialog.close();
			
	    	$rootScope.panelMessage = "Could not update user profile at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.changePassword = function() {
		
		$.ajax({
		    url: '/tm-web/tmUser/changePassword.do?password='+$scope.ngDialogData.confirmNewPassword,
		    type: 'POST',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	ngDialog.close();
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not update user profile at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
});

module.controller("homeController", function ($scope, $state) {
});

module.controller("projectController", function ($scope, $state, $rootScope, $timeout, ngDialog) {
	$.ajax({
	    url: '/tm-web/tmProject/getAllUserProjects.do?id='+ $rootScope.userBean.id,
	    type: 'GET',
	    dataType: 'json',
	    async: false,
	    success: function(data) {
	        $scope.projectList = data;
	    }
	}).fail(function() {
		$scope.loading = false;
    	$rootScope.panelMessage = "Could not add the project at this moment."
    	$rootScope.errorBoxFlag = true;
    	$timeout( function(){ $rootScope.autoHide(); }, 4000);
	});
	
	$scope.addProject = function(projectBean) {
		projectBean.projOwner = $rootScope.userBean.id;
		$.ajax({
	        url: '/tm-web/tmProject/addProject.do?projectBean='+JSON.stringify(projectBean),
	        type: 'POST',
	        dataType: 'json',
	        async: false,
	        success: function(data) {
	        	$scope.projectList.push(data);
	            $state.reload('dboard.project');
	        	ngDialog.close();
		    	$rootScope.panelMessage = "New project added successfully."
				$rootScope.successBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 4000);
	        }
	    }).fail(function() {
	    	$scope.loading = false;
	    	$rootScope.panelMessage = "Could not add the project at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 4000);
	    });
	};
	
	$scope.disableProject = function(id) {
		$.ajax({
	        url: '/tm-web/tmProject/disableProject.do?id='+id,
	        type: 'POST',
	        dataType: 'json',
	        async: false,
	        success: function(data) {
	        	$scope.projectList.push(data);
	        	$state.reload('dboard.project');
	        	$scope.$apply();
	        	ngDialog.close();
		    	$rootScope.panelMessage = "Project disabled successfully."
				$rootScope.successBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 4000);
	        }
	    }).fail(function() {
	    	$scope.loading = false;
	    	$rootScope.panelMessage = "Could not disable the project at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 4000);
	    });
	};
	
	$scope.deleteProject = function(id) {
		$.ajax({
	        url: '/tm-web/tmProject/deleteProject.do?id='+id,
	        type: 'POST',
	        dataType: 'json',
	        async: false,
	        success: function(data) {
	        	$scope.projectList.push(data);
	        	$state.reload('dboard.project');
	        	$scope.$apply();
	        	ngDialog.close();
		    	$rootScope.panelMessage = "Project removed successfully."
				$rootScope.successBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 4000);
	        }
	    }).fail(function() {
	    	$scope.loading = false;
	    	$rootScope.panelMessage = "Could not delete the project at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 4000);
	    });
	};
});
