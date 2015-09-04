var module = angular.module('tm-app', ['ui.router', 'ngDialog', 'pascalprecht.translate', 'ui.bootstrap',
                                       'angular-table', 'angularTreeview', 'ngAnimate', 'cgBusy', 'ngTouch',
                                       'angucomplete-alt', 'tm-confirm-button']);

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
					templateUrl : 'resources/pages/projectsManagerView.jsp',
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