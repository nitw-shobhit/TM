var module = angular.module('bps-app', ['ui.router', 'ngDialog', 'ngDragDrop', 'pascalprecht.translate']);

//i18n & l10n
module.config(function ($translateProvider) {
	
	$translateProvider.translations('en', {
		"page" : {
			"header" : {
				"home" : "HOME"
			}
		}
	});
	$translateProvider.translations('es', {
		"page" : {
			"header" : {
				"home" : "CASA"
			}
		}
	});
	$translateProvider.translations('it', {
		"page" : {
			"header" : {
				"home" : "CASA"
			}
		}
	});
	$translateProvider.translations('fr', {
		"page" : {
			"header" : {
				"home" : "ACCUEIL"
			}
		}
	});
	
	$translateProvider.preferredLanguage('en');
});


// Custom Directives

module.directive('ngReallyClick', [function() {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            element.bind('click', function() {
                var message = attrs.ngReallyMessage;
                if (message && confirm(message)) {
                    scope.$apply(attrs.ngReallyClick);
                }
            });
        }
    }
}]);

// Routing
module.config(function ($stateProvider, $urlRouterProvider, $provide) {
	
				$stateProvider.state('app',
							{
								url: "/",
								views: {
									'logo' : {
										templateUrl : 'resources/dashboard/logo.jsp'
									},
									'content' : {
										templateUrl : 'resources/dashboard/login.jsp',
										controller : 'loginController'
									}
								}
							}
				  		)
				  .state('app.dboard',
							{
								url: "",
								views: {
									'userInfo@' : {
										templateUrl : 'resources/dashboard/userInfo.jsp',
										controller : 'userInfoController'
									},
									'menu@' : {
										templateUrl : 'resources/dashboard/menu.jsp',
										controller : 'menuController'
									},
									'content@' : {
										templateUrl : 'resources/home.jsp'
									}
								}
							}
					  	)
				  .state('app.dboard.home',
							{
								url: "",
								views: {
									'content@' : {
										templateUrl : 'resources/home.jsp'
									}
								}
							}
					  	)
				 .state('app.dboard.org',
							{
								url: "",
								views: {
									'content@' : {
										templateUrl : 'resources/organizations.jsp',
										controller : 'organizationController'
									}
								}
							}
					  	)
				  .state('app.dboard.org.orgs',
							{
								url: "",
								views: {
									 'orgs' : {
										templateUrl : 'resources/organization/organizationList.jsp',
										controller : 'organizationDataController'
									}
								}
							}
					  	)
				 .state('app.dboard.org.orgs.orgdata',
							{
								url: "",
								views: {
									 'orgData' : {
										templateUrl : 'resources/organization/organizationData.jsp',
										controller : 'organizationDataController'
									}
								}
							}
					  	)
				 .state('app.dboard.proc',
							{
								url: "",
								views: {
									'content@' : {
										templateUrl : 'resources/processes.jsp',
										controller : 'processController'
									}
								}
							}
					  	)
				 .state('app.dboard.proc.procs',
							{
								url: "",
								views: {
									 'procs' : {
										templateUrl : 'resources/process/processList.jsp',
										controller : 'processDataController'
									}
								}
							}
					  	)
				 .state('app.dboard.proc.procs.procdata',
							{
								url: "",
								views: {
									 'procData' : {
										templateUrl : 'resources/process/processVersions.jsp',
										controller : 'processDataController'
									}
								}
							}
					  	)
				 .state('app.dboard.log',
							{
								url: "",
								views: {
									'content@' : {
										templateUrl : 'resources/logs.jsp'
									}
								}
							}
					  	)
				 .state('app.dboard.sts',
							{
								url: "",
								views: {
									'content@' : {
										templateUrl : 'resources/settings.jsp'
									}
								}
							}
					  	)
				 .state('app.dboard.help',
							{
								url: "",
								views: {
									'content@' : {
										templateUrl : 'resources/help.jsp'
									}
								}
							}
					  	)				  	
	$urlRouterProvider.otherwise("/");
});

module.directive('loading', function () {
      return {
        restrict: 'E',
        replace:true,
        template: '<div class="loading"><img src="http://www.jsclasses.org/browse/view/image/file/3815/name/loading.gif" width="20" height="20" /></div>',
        link: function (scope, element, attr) {
              scope.$watch('loading', function (val) {
                  if (val)
                      $(element).show();
                  else
                      $(element).hide();
              });
        }
      }
});

module.factory('transferService', function() {
	 var savedData = {}
	 function set(data) {
		 savedData = data;
	 }
	 function get() {
		 return savedData;
	 }

	 return {
		 set: set,
		 get: get
	 }
});

// Controllers
module.controller("loginController", function ($scope, $state, transferService) {
	$scope.login = function() {
		$scope.loading = true;
        $.ajax({
            url: '/bps-mng-web/mngLogin/validateLogin.do?userId=' + $scope.userId + '&password=' + $scope.userPass,
            type: 'POST',
            dataType: 'json',
            async: false,
            success: function(data) {
            	transferService.set(data);
                $state.go('app.dboard');
                $scope.loading = false;
            }
        }).fail(function() {
        	$scope.loading = false;
        });
	}
});

module.controller("userInfoController", function ($scope, transferService) {
	$scope.profileData = transferService.get();
});

module.controller("menuController", function ($scope, $state, transferService, $translate) {
	$scope.locale = "en";
	$scope.setLocale = function () {
		$translate.use($scope.locale);
	};
	$scope.home = function() {
        $state.go('app.dboard.home');
	}
	$scope.orgs = function() {
		 $.ajax({
	            url: '/bps-mng-web/mngOrg/getOrganizationData.do',
	            type: 'GET',
	            dataType: 'json',
	            async: false,
	            success: function(data) {
	            	transferService.set(data);
	            	$state.go('app.dboard.org');
	            }
	        }).fail(function() {
	    });
	}
	$scope.procs = function() {
		 $.ajax({
	            url: '/bps-mng-web/mngProcess/getProcessData.do',
	            type: 'GET',
	            dataType: 'json',
	            async: false,
	            success: function(data) {
	            	transferService.set(data);
	            	$state.go('app.dboard.proc');
	            }
	        }).fail(function() {
	    });
	}
	$scope.logs = function() {
        $state.go('app.dboard.log');
	}
	$scope.stngs = function() {
        $state.go('app.dboard.sts');
	}
	$scope.help = function() {
        $state.go('app.dboard.help');
	}
	$scope.lgot = function() {
        $state.go('app');
	}
});

module.controller("processController", function ($scope, $state, transferService) {
	$scope.processList = transferService.get();
	$state.go('app.dboard.proc.procs');
});

module.controller("processDataController", function ($scope, $state) {
	$scope.getProcVersions = function(procId) {
		 $.ajax({
	            url: '/bps-mng-web/mngProcess/getProcessVersions.do?procId='+procId,
	            type: 'GET',
	            dataType: 'json',
	            async: false,
	            success: function(data) {
	            	$scope.procVersions = data;
	            	$state.go('app.dboard.proc.procs.procdata');
	            }
	        }).fail(function() {
	    });
	}
});

module.controller("organizationController", function ($scope, $state, transferService) {
	$scope.organizationList = transferService.get();
	$state.go('app.dboard.org.orgs');
});

module.controller("organizationDataController", function ($rootScope, $scope, $state, ngDialog, transferService) {
	$scope.selectOrganization = function () {
		ngDialog.open({
			template: 'selectOrgPopup',
			data: {'styleCl' : 'background-color: #EFB3B3; text-align: center;'},
			className: 'ngdialog-theme-default selectOrganization',
			preCloseCallback: function(value) {
				return true;
			}
		});
    };
	$scope.getOrgData = function(org) {
		 $.ajax({
	            url: '/bps-mng-web/mngOrg/getOrganizationProcesses.do?orgId='+org.id,
	            type: 'GET',
	            dataType: 'json',
	            async: false,
	            success: function(data) {
	            	$scope.selectedOrg = org;
	            	$scope.orgProcs = data;
	            	$state.go('app.dboard.org.orgs.orgdata');
	            }
	        }).fail(function() {
	    });
	}
	$scope.addOrganization = function() {
		 $.ajax({
	            url: '/bps-mng-web/mngOrg/addOrganization.do?org='+JSON.stringify($scope.ngDialogData),
	            type: 'GET',
	            dataType: 'json',
	            async: false,
	            success: function(data) {
	            	transferService.set(data);
	            	ngDialog.close();
	            	$state.reload();
	            }
	        }).fail(function() {
	    });
	}
	$scope.openEditOrganization = function(org) {
		if(org.orgType == 'S') {
			org.styleClass = 'schColorScheme';
			org.message = 'School';
		} else if(org.orgType == 'U') {
			org.styleClass = 'uniColorScheme';
			org.message = 'University';
		} else if(org.orgType == 'C') {
			org.styleClass = 'comColorScheme';
			org.message = 'Company';
		}
		ngDialog.open({
				template: 'editOrgPopup',
				data: org,
				className: 'ngdialog-theme-default addOrganization',
				controller: 'organizationDataController',
				preCloseCallback: function(value) {
					return true;
				}
		});
	}
	$scope.editOrganization = function() {
		 $.ajax({
	            url: '/bps-mng-web/mngOrg/editOrganization.do?org='+JSON.stringify($scope.ngDialogData),
	            type: 'GET',
	            dataType: 'json',
	            async: false,
	            success: function(data) {
	            	transferService.set(data);
	            	ngDialog.close();
	            	$state.reload();
	            }
	        }).fail(function() {
	    });
	}
	$scope.removeOrganization = function(orgId) {
		 $.ajax({
	            url: '/bps-mng-web/mngOrg/deleteOrganization.do?orgId='+orgId,
	            type: 'GET',
	            dataType: 'json',
	            async: false,
	            success: function(data) {
	            	transferService.set(data);
	            	$state.reload();
	            }
	        }).fail(function() {
	    });
	}
	$scope.openAttachProcess = function(org) {
		var inputData={};
		inputData.id = org.id;
		if(org.orgType == 'S') {
			inputData.styleClass = 'schColorScheme';
			inputData.message = 'School';
		} else if(org.orgType == 'U') {
			inputData.styleClass = 'uniColorScheme';
			inputData.message = 'University';
		} else if(org.orgType == 'C') {
			inputData.styleClass = 'comColorScheme';
			inputData.message = 'Company';
		}
		 $.ajax({
	            url: '/bps-mng-web/mngProcess/getProcessData.do',
	            type: 'GET',
	            dataType: 'json',
	            async: false,
	            success: function(data) {
	            	inputData.data2 = data;
	            }
	        }).fail(function() {
	    });
		 $.ajax({
			 	url: '/bps-mng-web/mngOrg/getOrganizationProcesses.do?orgId='+org.id,
	            type: 'GET',
	            dataType: 'json',
	            async: false,
	            success: function(data) {
	            	inputData.data1 = data;
	        		ngDialog.open({
		    				template: 'attachProcPopup',
		    				data: inputData,
		    				className: 'ngdialog-theme-default attachProcToOrganization',
		    				controller: 'organizationDataController',
		    				preCloseCallback: function(value) {
		    					return true;
		    				}
		    		});
	            }
	        }).fail(function() {
	    });
	}
    $scope.dropSuccessHandler = function($event, index, array){
        array.splice(index,1);
    }
    $scope.onDrop = function($event, $data, array){
        array.push($data);
    }
	$scope.attachProcessesToOrganization = function() {
		 $.ajax({
	            url: '/bps-mng-web/mngOrg/addProcessToOrganization.do?orgId='+$scope.org.id + 'procIds'+JSON.stringify($scope.ngDialogData),
	            type: 'GET',
	            dataType: 'json',
	            async: false,
	            success: function(data) {
	            	transferService.set(data);
	            	ngDialog.close();
	            	$state.reload();
	            }
	        }).fail(function() {
	    });
	}
});
