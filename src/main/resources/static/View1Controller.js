var view1Controller = function($scope,$rootScope,View1Service,$state) {

	$scope.user={
			"createdOn" : "2019-01-01",
			"lastLogin" : "2020-22-01"
	};
	$scope.subscription={};
	$scope.saveDetails = function() {
	
		$scope.user.subscription=$scope.subscription;
		$scope.user;
		debugger;
		View1Service.saveUserSubscription($scope.user).then(function(success) {
			console.log(success);
			$rootScope.loggedInUser = success
			alert("Sign Up Successful...");
			$state.go('view2');
		},function(failure) {
			alert("Sign Up Failed...");
			console.log(failure);
		});		
	}
}
appName.controller("View1Controller", view1Controller);


