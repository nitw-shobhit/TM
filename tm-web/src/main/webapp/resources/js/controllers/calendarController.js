angular.module('tm-app').controller("calendarController", function($scope, $rootScope, $state, $timeout, ngDialog) {

	var todaysDate = new Date();
	$scope.currentSetMonth = todaysDate.getMonth();
	$scope.currentSetYear = todaysDate.getYear() + 1900;
	
	getCalendar();
	
	function getCalendar() {
		$.ajax({
		    url: '/tm-web/tmCalendar/getCalendar.do?month=' + $scope.currentSetMonth 
		    	+ '&year=' + $scope.currentSetYear,
		    type: 'GET',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	$scope.calendar = data;
		    }
		}).fail(function() {
	    	$rootScope.panelMessage = "Could not retrieve the calendar at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	}
	
	$scope.reduceYear = function() {
		$scope.currentSetYear = $scope.currentSetYear - 1;
		getCalendar();
	};
	
	$scope.reduceMonth = function() {
		if($scope.currentSetMonth == 0) {
			$scope.currentSetMonth = 11;
			$scope.currentSetYear = $scope.currentSetYear - 1;
		} else {
			$scope.currentSetMonth = $scope.currentSetMonth - 1;
		}
		getCalendar();
	};
	
	$scope.increaseYear = function() {
		$scope.currentSetYear = $scope.currentSetYear + 1;
		getCalendar();
	};
	
	$scope.increaseMonth = function() {
		if($scope.currentSetMonth == 11) {
			$scope.currentSetMonth = 0;
			$scope.currentSetYear = $scope.currentSetYear + 1;
		} else {
			$scope.currentSetMonth = $scope.currentSetMonth + 1;
		}
		getCalendar();
	};
	
	$scope.setMonth = function(month) {
		$scope.currentSetMonth = month;
		ngDialog.close();
		getCalendar();
	};
	
	$scope.setYear = function(year) {
		$scope.currentSetYear = year;
		ngDialog.close();
		getCalendar();
	};
	
	$scope.openMonthsPopUp = function() {
		var month = {
			value : $scope.currentSetMonth
		};
		ngDialog.open({
			template: 'months',
			className: 'ngdialog-theme-default months',
			scope: $scope,
			data: month,
			preCloseCallback: function(value) {
				return true;
			}
		});
	};
	
	$scope.openYearsPopUp = function() {
		var year = {
			value : $scope.currentSetYear	
		};
		ngDialog.open({
			template: 'years',
			className: 'ngdialog-theme-default years',
			scope: $scope,
			data: year,
			preCloseCallback: function(value) {
				return true;
			}
		});
	};
	
	$scope.openDateBox = function(selectedDate, selectedMonth, selectedYear) {
		var selectedData = {
			"selectedDate" : selectedDate,
			"selectedMonth" : selectedMonth,
			"selectedYear" : selectedYear
		};
		ngDialog.open({
			template: 'dateBox',
			className: 'ngdialog-theme-default dateBox',
			scope: $scope,
			data: selectedData,
			preCloseCallback: function(value) {
				return true;
			}
		});
	};
});