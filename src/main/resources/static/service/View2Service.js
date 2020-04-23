appName.service("View2Service",function($http,$q){
	
	this.getData = function() {
		
		var defer = $q.defer();
		
		return $http.get('http://localhost:8080/getdata').then(function(response) {
		  defer.resolve(response.data);
		  return defer.promise;
		},function(response) {
			defer.reject(reponse);
			return defer.promise;
		}
		);
	};
})