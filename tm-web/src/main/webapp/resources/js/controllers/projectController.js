angular.module('tm-app').controller("projectController", function ($scope, $state, $rootScope, $timeout, ngDialog) {
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
	
	$scope.getProjectTeam = function(projectBean) {
		$.ajax({
	        url: '/tm-web/tmUserProject/getProjectTeam.do?id='+projectBean.id,
	        type: 'GET',
	        dataType: 'json',
	        async: false,
	        success: function(data) {
	        	$.ajax({
	    	        url: '/tm-web/tmUser/getAllUsers.do',
	    	        type: 'GET',
	    	        dataType: 'json',
	    	        async: false,
	    	        success: function(data1) {
	    	        	$scope.allusers = [];
	    	        	for(var index1 = 0; index1 < data1.length; index1 ++) {
	    	        		var flag = true;
	    	        		for(var index2 = 0; index2 < data.length; index2 ++) {
	    	        			if(data1[index1].id == data[index2].id) {
	    	        				flag = false;
	    	        				break;
	    	        			}
	    	        		}
	    	        		if(flag) {
	    	        			$scope.allusers.push(data1[index1]);
	    	        		}
	    	        	}
	    	        }
	    	    });
	        	var popupData = {"team" : data, "allUsers" : $scope.allusers, "projectId" : projectBean.id};
	        	ngDialog.open({
	    			template: 'projectTeam',
	    			data: popupData,
	    			className: 'ngdialog-theme-default projectTeam',
	    			controller: 'projectController',
	    			preCloseCallback: function(value) {
	    				return true;
	    			}
	    		});
	        }
	    }).fail(function() {
	    	$rootScope.panelMessage = "Could not retrieve the project team details at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
		
	};
	
	$scope.addUserToProject = function(selectedUser) {
		$.ajax({
	        url: '/tm-web/tmUserProject/addUserToProject.do?userId='+selectedUser.id + '&projectId=' + $scope.selectedProject.id,
	        type: 'POST',
	        dataType: 'text',
	        async: false,
	        success: function(data) {
	        	console.log(ngDialog);
	        }
	    }).fail(function() {
	    	$rootScope.panelMessage = "Could not delete the project at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
	};
	
	$scope.getProjectModules = function(projectId) {
		$.ajax({
	        url: '/tm-web/tmModule/getProjectModules.do?id='+projectId,
	        type: 'GET',
	        dataType: 'json',
	        async: false,
	        success: function(data) {
	        	if(data.length == 0) {
	        		var popupData = {"data" : data, "emptyListMessage" : "This project does not contain any modules. Lets add some?", "projectId" : projectBean.id};
	        	} else {
	        		var popupData = {"data" : data, "emptyListMessage" : "", "projectId" : projectId};
	        	}
	        	
	        	ngDialog.open({
	    			template: 'projectModules',
	    			data: popupData,
	    			className: 'ngdialog-theme-default projectModules',
	    			controller: 'projectController',
	    			preCloseCallback: function(value) {
	    				return true;
	    			}
	    		});
	        }
	    }).fail(function() {
	    	$rootScope.panelMessage = "Could not retrieve the project modules at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
		
	};
	
	$scope.addModuleToProject = function(moduleBean) {
		$.ajax({
	        url: '/tm-web/tmModule/addModuleToProject.do?moduleBean='+JSON.stringify(moduleBean),
	        type: 'POST',
	        dataType: 'text',
	        async: false,
	        success: function(data) {
	        	ngDialog.close();
	        	$scope.getProjectModules(moduleBean.projId);
	        }
	    }).fail(function() {
	    	ngDialog.close();
	    	$rootScope.panelMessage = "Could not retrieve the project modules at this moment."
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
	    });
	};
	
	$scope.getModuleIssues = function(moduleId) {
		
	}
});
