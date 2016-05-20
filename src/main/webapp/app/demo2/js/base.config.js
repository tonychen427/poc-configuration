require.config({
	//baseUrl: 'scripts',
        urlArgs: "bust=" + (new Date()).getTime(),
	paths: {
		'angular': '../../../bower_components/angular/angular',
		'angular.route': '../../../bower_components/angular-route/angular-route',

		'underscore': '../../../bower_components/lodash/lodash',

		'log': 'logging/console-logger',

		'text': '../../../bower_components/requirejs-text/text',

		'partials': '../partials'
	},

	shim: {
		'angular': {
			exports: 'angular'
		},
		'angular.route': ['angular']
	}
});
