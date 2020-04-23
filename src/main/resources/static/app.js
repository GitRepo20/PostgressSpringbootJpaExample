var appName = angular.module('appName', ['ui.router']);

appName.config(function($stateProvider,$locationProvider) {//,$urlProvider

	$stateProvider
	.state("view1", {
		url:'/view1',
		templateUrl: 'view1.html',
		controller : 'View1Controller'
	})
	.state("view2", {
		url:'/view2',
		templateUrl: 'view2.html',
		controller : 'View2Controller'
	})
	.state("view3", {
		url:'/view3',
		templateUrl: 'view3.html',
		controller : 'View3Controller'
	})
	
	//$urlProvider.otherwise("/");

});