define(function(require) {
  'use strict';

  var Backbone = require('backbone');
  var blogTemplate = require('hbs!app.templates/add.blog');
  var MarkdownEditor = require('jsx!components/editor');
  var React = require('react');

  var BlogView = Backbone.View.extend({
    template: blogTemplate,

    render: function() {
      this.setElement(this.template());
      React.renderComponent(new MarkdownEditor(), this.$el.find('#editor').get(0));
      return this;
    }
  });

  return BlogView;
});