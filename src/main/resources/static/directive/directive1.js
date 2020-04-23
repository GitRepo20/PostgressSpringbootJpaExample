appName.directive("dirExample",function(){
	
	return {
		restrict:'E',
		scope: {
			cinfo:'=info'
		},
		templateUrl: 'directive/DirTemplate.html',
		controller: 'DirController'
	};
});