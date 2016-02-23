angular.module('tm-app').controller("calendarController", function($scope, $rootScope, $state, $timeout, ngDialog) {

	var todaysDate = new Date();
	$scope.currentSetMonth = todaysDate.getMonth();
	$scope.currentSetYear = todaysDate.getYear() + 1900;
	
	getCalendar(true);
	
	function getCalendar(filterFlag) {
		if(filterFlag) {
			$scope.calendarChkAll = true;
			$scope.calendarChkIssues = true;
			$scope.calendarChkReleases = true;
			$scope.calendarChkMeetings = true;
		}
		$.ajax({
		    url: '/tm-web/tmCalendar/createCalendar.do?month=' + $scope.currentSetMonth 
		    	+ '&year=' + $scope.currentSetYear,
		    type: 'GET',
		    dataType: 'json',
		    async: false,
		    success: function(data) {
		    	$scope.calendar = data;
		    	
		    	if(filterFlag) {
		    		$.ajax({
					    url: '/tm-web/tmCalendar/getCalendar.do?userId=' + $rootScope.userBean.id,
					    type: 'GET',
					    dataType: 'json',
					    async: false,
					    success: function(data) {
					    	$scope.calendarDetailsBean = data;
					    }
					}).fail(function() {
				    	$rootScope.panelMessage = "Could not retrieve the calendar at this moment.";
				    	$rootScope.errorBoxFlag = true;
				    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
					});
		    	}
		    	
		    	for(var i = 0; i < 7; i ++) {
		    		for(var j = 0; j < 6; j ++) {
		    			var events = extractEventsList($scope.calendar.days[i].dates[j].value);
		    			$scope.calendar.days[i].dates[j].events = events;
		    		}
		    	}
		    	console.log($scope.calendar);
		    }
		}).fail(function() {
	    	$rootScope.panelMessage = "Could not retrieve the calendar at this moment.";
	    	$rootScope.errorBoxFlag = true;
	    	$timeout( function(){ $rootScope.autoHide(); }, 2000);
		});
	}
	
	$scope.reduceYear = function() {
		$scope.currentSetYear = $scope.currentSetYear - 1;
		getCalendar(false);
	};
	
	$scope.reduceMonth = function() {
		if($scope.currentSetMonth == 0) {
			$scope.currentSetMonth = 11;
			$scope.currentSetYear = $scope.currentSetYear - 1;
		} else {
			$scope.currentSetMonth = $scope.currentSetMonth - 1;
		}
		getCalendar(false);
	};
	
	$scope.increaseYear = function() {
		$scope.currentSetYear = $scope.currentSetYear + 1;
		getCalendar(false);
	};
	
	$scope.increaseMonth = function() {
		if($scope.currentSetMonth == 11) {
			$scope.currentSetMonth = 0;
			$scope.currentSetYear = $scope.currentSetYear + 1;
		} else {
			$scope.currentSetMonth = $scope.currentSetMonth + 1;
		}
		getCalendar(false);
	};
	
	$scope.setMonth = function(month) {
		$scope.currentSetMonth = month;
		ngDialog.close();
		getCalendar(false);
	};
	
	$scope.setYear = function(year) {
		$scope.currentSetYear = year;
		ngDialog.close();
		getCalendar(false);
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
	
	function extractEventsList(date) {
		var key = "";
		if(date < 10) {
			key += "0";
		}
		key = key + date;
		var month = $scope.currentSetMonth + 1;
		if(month < 10) {
			month = "0" + month;
		}
		
		key += month;
		key += $scope.currentSetYear;
		var events = {
			"issues" : $scope.calendarDetailsBean[key],
			"releases" : ["hi", "hellow"],
			"meetings" : ["hi", "hellow", "eef"]
		};
		return events;
	}
	
	$scope.updateCalendarFilters = function(type) {
		if(type === "All") {
			$scope.calendarChkIssues = $scope.calendarChkAll;
			$scope.calendarChkReleases = $scope.calendarChkAll;
			$scope.calendarChkMeetings = $scope.calendarChkAll;
		} else {
			if($scope.calendarChkIssues && $scope.calendarChkReleases && $scope.calendarChkMeetings) {
				$scope.calendarChkAll = true;
			} else {
				$scope.calendarChkAll = false;
			}
		}
	}
});