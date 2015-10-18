angular.module('tm-confirm-button', ['ngDialog']).directive('confirmButton', function (ngDialog) {
	return {
		restrict: "A",
		link: function(scope, element, attrs) {
			element.on('click',function(){
				ngDialog.open({
	    			template: 'confirmButton',
	    			preCloseCallback: function(value) {
	    				return true;
	    			}
	    		});
			});
		}
	};
});