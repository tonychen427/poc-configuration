/* global define*/

define(function(require) {
  'use strict';

  var Router = require('router/app.router');
  var Backbone = require('backbone');
  require('bootstrap');

  var App = function() {
    this.initialize = function() {
      new Router();
      Backbone.history.start();
    };
  };

  return App;
});