appName.service("View1Service", function($http,$q){

	this.saveUserSubscription = function(user){		

		var defer = $q.defer();
		return $http.post('http://localhost:8080/saveusersubscription',JSON.stringify(user))		
			.then(function(response) {
				defer.resolve(response.data);
				return defer.promise;
			}, function(response) {
				defer.reject(response);
				return defer.promise;
			});
	};
})