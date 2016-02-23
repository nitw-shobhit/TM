var module = angular.module('tm-app', ['ui.router', 'ngDialog', 'pascalprecht.translate', 'ui.bootstrap',
                                       'angular-table', 'angularTreeview', 'ngAnimate', 'cgBusy', 'ngTouch',
                                       'angucomplete-alt', 'tm-confirm-button', 'LocalStorageModule', 
                                       'tm-tooltip']);

//I18N & L10N
module.config(function ($translateProvider) {
	
	$translateProvider.useStaticFilesLoader({
	    prefix: 'resources/locale/messages-',
	    suffix: '.json'
	});
	
	$translateProvider.preferredLanguage('en');
});

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
	};
});

//STATE ROUTES
module.config(function ($stateProvider, $urlRouterProvider, $provide) {
	$stateProvider.state('app',
		{
			url: "/",
			views: {
				'content' : {
					templateUrl : 'resources/pages/login.jsp',
					controller : 'loginController'
				},
				'userInfo' : {
					templateUrl : 'resources/pages/blankUserInfo.jsp',
					controller : 'userInfoController'
				},
				'messageBox' : {
					templateUrl : 'resources/pages/messageBox.jsp',
					controller : 'rootController'
				},
				'footer' : {
					templateUrl : 'resources/pages/footer.jsp',
					controller : 'rootController'
				}
			}
		}
	)
	.state('app.dboard',
		{
			url: "",
			views: {
				'userInfo@' : {
					templateUrl : 'resources/pages/userInfo.jsp',
					controller : 'userInfoController'
				},
				'content@' : {
					templateUrl : 'resources/pages/dashboard.jsp',
					controller : 'dashboardController'
				}
			}
		}
	)
	.state('app.dboard.calendar',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : 'resources/pages/calendar.jsp',
					controller : 'calendarController'
				}
			}
		}
	)
	.state('app.dboard.report',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : 'resources/pages/reports.jsp',
					controller : 'reportController'
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
	.state('app.dboard.about',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : 'resources/pages/about.jsp',
					controller : 'internalController'
				}
			}
		}
	)
	.state('app.dboard.notification',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : 'resources/pages/notifications.jsp',
					controller : 'notificationController'
				}
			}
		}
	)
	.state('app.dboard.log',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : 'resources/pages/logs.jsp',
					controller : 'loggerController'
				}
			}
		}
	)
	.state('app.dboard.notification.archived',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : 'resources/pages/archivedNotifications.jsp',
					controller : 'notificationController'
				}
			}
		}
	)
  	.state('app.dboard.module',
		{
			url: "",
			views: {
				'content@' : {
					templateUrl : 'resources/pages/modules.jsp',
					controller : 'moduleController'
				}
			}
		}
  	)
  	.state('app.dboard.module.release',
		{
			url: "",
			views: {
				'component' : {
					templateUrl : 'resources/pages/releases.jsp',
					controller : 'releaseController'
				}
			}
		}
  	)
  	.state('app.dboard.module.issue',
		{
			url: "",
			views: {
				'component' : {
					templateUrl : 'resources/pages/issues.jsp',
					controller : 'issueController'
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