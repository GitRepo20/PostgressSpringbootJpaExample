var view2Controller = function($scope,$rootScope, View2Service) {

	$scope.firstName="";
	$scope.lastName = "";
	
	/*$scope.view2Var={};
	$scope.getData = function() {
		View2Service.getData().then(function(response){
			$scope.view2Var=response;
		},function(response){
			console.log(response);
		});
	}*/
	//$scope.getData();
	
	$scope.getUserDetails = function() {
		debugger;
		$scope.firstName = $rootScope.loggedInUser.firstName;
		$scope.lastName =  $rootScope.loggedInUser.lastName;
	}
	$scope.getUserDetails();
}
appName.controller("View2Controller", view2Controller);
