define(function(require) {
  'use strict';

  var Backbone = require('backbone');
  var testTemplate = require('hbs!app.templates/home');

  var TestView = Backbone.View.extend({
    template: testTemplate,

    render: function() {
      this.setElement(this.template());
      return this;
    }
  });
  return TestView;
});