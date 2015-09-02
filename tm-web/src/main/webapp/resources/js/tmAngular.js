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
	$stateProvider.state('app',
		{
			url: "/",
			views: {
				'content' : {
					templateUrl : 'resources/pages/dashboard/login.jsp',
					controller : 'loginController'
				},
				'userInfo' : {
					templateUrl : 'resources/pages/dashboard/blankUserInfo.jsp',
					controller : 'userInfoController'
				}			
			}
		}
	)
	.state('app.dboard',
		{
			url: "",
			views: {
				'userInfo@' : {
					templateUrl : 'resources/pages/dashboard/userInfo.jsp',
					controller : 'userInfoController'
				},
				'menu@' : {
					templateUrl : 'resources/pages/dashboard/menu.jsp',
					controller : 'menuController'
				},
				'content@' : {
					templateUrl : 'resources/pages/home.jsp',
					controller : 'homeController'
				}
			}
		}
	)
  	.state('app.dboard.project',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : 'resources/pages/projects.jsp',
					controller : 'projectController'
				}
			}
		}
  	)
  	.state('app.dboard.project.data',
  		{
	  		url: "",
			views: {
				'projectData' : {
					templateUrl : 'resources/pages/project/projectData.jsp',
					controller : 'projectController'
				}
			}
  		}
  	)
  	.state('app.dboard.settings',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : 'resources/pages/settings.jsp'
				}
			}
		}
  	)
	.state('app.dboard.help',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : 'resources/pages/help.jsp'
				}
			}
		}
  	);
	$urlRouterProvider.otherwise("/");
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

module.controller("loginController", function ($scope, $state, $rootScope, $timeout) {
	$scope.login = function() {
		var userBean = {
			"userId" : $scope.userId,
			"userPass" : $scope.userPass
		};
		$.ajax({
		    url: '/tm-web/tmLogin/validateLogin.do?userBean='+JSON.stringify(userBean),
		    type: 'GET',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	$rootScope.userBean = data;
		    	$rootScope.panelMessage = "Welcome back " + data.userName + ". Nice to see you again!!"
		    	$rootScope.successBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		    	$state.go('app.dboard');
		    }
		}).fail(function() {
	    	$rootScope.panelMessage = "Could not validate the user."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.loginFacebook = function() {
		$rootScope.panelMessage = "This feature is currently not supported"
    	$rootScope.errorBoxFlag = true;
    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	};
	
	$scope.register = function() {
		$rootScope.panelMessage = "This feature is currently not supported"
    	$rootScope.errorBoxFlag = true;
    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	};
});

module.controller("menuController", function ($scope, $state) {
	$scope.home = function() {
        $state.go('app.dboard');
	};
	$scope.projects = function() {
        $state.go('app.dboard.project');
	};
	$scope.database = function() {
        $state.go('app.dboard.database');
	};
	$scope.worklist = function() {
        $state.go('app.dboard.worklist');
	};
});

module.controller("userInfoController", function ($scope, $state, ngDialog, $rootScope, $timeout) {

	$scope.logout = function() {
		$state.go('app');
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
		    url: '/tm-web/tmUser/changePassword.do?password='+$scope.ngDialogData.confirmNewPassword+'&id='+$rootScope.userBean.id,
		    type: 'POST',
		    dataType: 'text',
		    async: false,
		    success: function(data) {
		    	ngDialog.close();
		    	$rootScope.userBean.userPass = data;
		    	console.log($rootScope.userBean.userPass);
		    	$rootScope.panelMessage = "Password updated."
				$rootScope.successBoxFlag = true;
				$timeout( function(){ $rootScope.autoHide(); }, 2000);
		    }
		}).fail(function() {
			ngDialog.close();
	    	$rootScope.panelMessage = "Could not update user password at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	};
	
	$scope.requestAdminPrivilege = function() {
		
		$.ajax({
		    url: '/tm-web/tmUser/requestAdminPrivilege.do?id='+$rootScope.userBean.id,
		    type: 'POST',
		    dataType: 'text',
		    async: false,
		    success: function(data) {
		    	$scope.requestMessage = "Raised a privilege request with id : "+data;
		    	$scope.requestSuccess=true;
		    }
		}).fail(function() {
	    	$scope.requestMessage = "Could not send your request at this moment.";
	    	$scope.requestSuccess=true;
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
	    	$scope.projectList = [];
	    	$scope.archivedProjectList = [];
	    	for(var index = 0; index < data.length; index ++) {
	    		if(data[index].projName.length > 12) {
	    			data[index].projNameTooltip = data[index].projName.substr(0, 9) + "...";
	    		} else {
	    			data[index].projNameTooltip = data[index].projName;
	    		}
	    		if(data[index].visible == 0) {
	    			$scope.archivedProjectList.push(data[index]);
	    		} else {
	    			$scope.projectList.push(data[index]);
	    		}
	    	}
	    }
	}).fail(function() {
    	$rootScope.panelMessage = "Could not add the project at this moment."
    	$rootScope.errorBoxFlag = true;
    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
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
	            $state.reload('app.dboard.project');
	        	ngDialog.close();
		    	$rootScope.panelMessage = "New project added successfully."
				$rootScope.successBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	        }
	    }).fail(function() {
	    	ngDialog.close();
	    	$rootScope.panelMessage = "Could not add the project at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
	};
	
	$scope.editProject = function(projectBean) {
		$.ajax({
	        url: '/tm-web/tmProject/editProject.do?projectBean='+JSON.stringify(projectBean),
	        type: 'POST',
	        dataType: 'text',
	        async: false,
	        success: function(data) {
	        	$state.reload('app.dboard.project');
	        	ngDialog.close();
		    	$rootScope.panelMessage = "Project updated successfully."
				$rootScope.successBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	        }
	    }).fail(function() {
	    	ngDialog.close();
	    	$rootScope.panelMessage = "Could not delete the project at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
	};
	
	$scope.disableProject = function(id) {
		$.ajax({
	        url: '/tm-web/tmProject/disableProject.do?id='+id,
	        type: 'POST',
	        dataType: 'text',
	        async: false,
	        success: function(data) {
	        	for(var index = 0; index < $scope.projectList.length; index ++) {
	        		if($scope.projectList[index].id == id) {
	        			$scope.projectList[index].visible = 0;
	        			$scope.archivedProjectList.push($scope.projectList[index]);
	        			$scope.projectList.splice(index, 1);
	        			break;
	        		}
	        	}
		    	$rootScope.panelMessage = "Project disabled successfully."
				$rootScope.successBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	        }
	    }).fail(function() {
	    	$rootScope.panelMessage = "Could not disable the project at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
	};
	
	$scope.enableProject = function(id) {
		$.ajax({
	        url: '/tm-web/tmProject/enableProject.do?id='+id,
	        type: 'POST',
	        dataType: 'text',
	        async: false,
	        success: function(data) {
	        	for(var index = 0; index < $scope.archivedProjectList.length; index ++) {
	        		if($scope.archivedProjectList[index].id == id) {
	        			$scope.archivedProjectList[index].visible = 1;
	        			$scope.projectList.push($scope.archivedProjectList[index]);
	        			$scope.archivedProjectList.splice(index, 1);
	        			break;
	        		}
	        	}
		    	$rootScope.panelMessage = "Project enabled successfully."
				$rootScope.successBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	        }
	    }).fail(function() {
	    	$rootScope.panelMessage = "Could not enable the project at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
	};
	
	$scope.deleteProject = function(id) {
		$.ajax({
	        url: '/tm-web/tmProject/deleteProject.do?id='+id,
	        type: 'POST',
	        dataType: 'text',
	        async: false,
	        success: function(data) {
	        	for(var index = 0; index < $scope.archivedProjectList.length; index ++) {
	        		if($scope.archivedProjectList[index].id == id) {
	        			$scope.archivedProjectList.splice(index, 1);
	        			break;
	        		}
	        	}
		    	$rootScope.panelMessage = "Project removed successfully."
				$rootScope.successBoxFlag = true;
		    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	        }
	    }).fail(function() {
	    	$rootScope.panelMessage = "Could not delete the project at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
	};
	
	$scope.getProjectData = function(projectBean) {
		//Details
		$scope.projectData = projectBean;
		//Team
		$.ajax({
	        url: '/tm-web/tmUserProject/getProjectTeam.do?id='+projectBean.id,
	        type: 'GET',
	        dataType: 'json',
	        async: false,
	        success: function(data) {
	        	$scope.projectTeam = data;
	        }
	    }).fail(function() {
	    	$rootScope.panelMessage = "Could not retrieve the project data at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
		//Modules
		
		//Requests
		
		$state.go('app.dboard.project.data');
	};
	
	$scope.searchUser = function() {
		$.ajax({
	        url: '/tm-web/tmUser/searchUser.do?query='+$scope.userSearchQuery,
	        type: 'POST',
	        dataType: 'json',
	        async: false,
	        success: function(data) {
	        	ngDialog.open({
	    			template: 'userSearchBox',
	    			data: data,
	    			className: 'ngdialog-theme-default userSearchBox',
	    			controller: 'projectController',
	    			preCloseCallback: function(value) {
	    				return true;
	    			}
	    		});
	        }
	    }).fail(function() {
	    	$rootScope.panelMessage = "Could not delete the project at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
	};
});
