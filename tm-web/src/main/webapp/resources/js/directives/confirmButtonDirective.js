angular.module('tm-confirm-button',['ngDialog']).directive("confirmButton", function (ngDialog){
	return {
		restrict: "E",
		scope: {
			buttonConf:"=",
			bAction:"=",
			bClass:"="
		},
		templateUrl: "resources/js/directives/templates/confirmButton.html",
		controller: function($scope){
			console.log($scope.bName);
			console.log($scope.bAction);
			console.log($scope.bClass);
		},
		link: function($scope, element) {
			element.on('click',function(){
				console.log($scope.message);
				ngDialog.open({
	    			template: 'confirmButton',
	    			className: 'ngdialog-theme-default confirmBox',
	    			controller: 'rootController',
	    			preCloseCallback: function(value) {
	    				return true;
	    			}
	    		});
			});
		}
	};
});