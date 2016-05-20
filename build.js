({
    appDir: './src/main/webapp/app/demo1',
    baseUrl: './js',
    dir: './src/main/webapp/dist',
    modules: [{name: 'main'}],
    
//    baseUrl: './src/main/webapp/app/demo1',
//    out: 'build/main.js',
//    name: '../../bower_components/almond/almond',
//    include: ['./js/main'],
    
    fileExclusionRegExp: /^(r|build)\.js$/,
    optimizeCss: 'standard', 
    optimize: 'uglify2',
    wrap: true,
    removeCombined: true,
    hbs: {
        templateExtension: 'hbs',
        disableHelpers: true,
        // // `true` it won't load locales and the i18n helper won't work
        disableI18n: true
    },
    shim: {
        'backbone': {
            deps: [
                'underscore',
                // 'underscoreStrings',
                'jquery'
            ],
            exports: 'Backbone'
        },
        bootstrap: {
            deps: ['jquery']
        },
        'jqueryMockAjax': {
            exports: '$.mockjax',
            deps: ['jquery']
        },
        json2: {
            exports: "JSON"
        },
        'underscore': {
            exports: '_'
        }
    },
    paths: {
        backbone: '../../../bower_components/backbone/backbone',
        bootstrap: '../../../bower_components/bootstrap/dist/js/bootstrap',
        jquery: '../../../bower_components/jquery/jquery',
        jqueryMockAjax: '../../../bower_components/jquery-mockjax/jquery.mockjax',
        underscore: '../../../bower_components/underscore/underscore',
        hbs: '../../../bower_components/hbs/hbs',
        handlebars: '../../../bower_components/hbs/Handlebars',
        i18nprecompile: '../../../bower_components/hbs/hbs/i18nprecompile',
        json2: '../../../bower_components/hbs/hbs/json2',
        showdown: '../../../bower_components/showdown/src/showdown',
        react: '../../../bower_components/react/react-with-addons',
        jsx: '../../../bower_components/require-jsx/jsx',
        JSXTransformer: '../../../bower_components/react/JSXTransformer',
        'app.templates': '../templates/'

    }
});