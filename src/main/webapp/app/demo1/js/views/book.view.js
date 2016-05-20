define(function(require) {
  'use strict';

  var Backbone = require('backbone');
  var bookTemplate = require('hbs!app.templates/book.view');

  var BookView = Backbone.View.extend({
    template: bookTemplate,

    render: function() {
      this.setElement(this.template(this.model.toJSON()));
      return this;
    }
  });

  return BookView;
});