define(function() {
	'use strict';

	var routeConfig = function($routeProvider) {
		$routeProvider
			.otherwise({
				redirectTo: '/home'
			});
	};

	routeConfig.$inject = ['$routeProvider'];

	return routeConfig;
});
