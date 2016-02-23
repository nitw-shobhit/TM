angular.module('tm-confirm-button', [ 'ngDialog' ]).directive('confirmButton', function(ngDialog) {
	return {
		link : function(scope, element, attr) {
			var msg = attr.confirmButton || "Are you sure you want to continue?";
			var clickAction = attr.confirmAction;
			element.bind('click', function(event) {
				ngDialog.openConfirm({
					scope : scope,
					template : 'confirmButton',
					className : 'ngdialog-theme-default confirmBox',
				}).then(function(confirm) {
					ngDialog.close();
					scope.$eval(clickAction);
				});
			});
		}
	};
});