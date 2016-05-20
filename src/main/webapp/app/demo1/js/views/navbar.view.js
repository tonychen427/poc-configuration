define(function(require) {
  'use strict';

  var Backbone = require('backbone');
  var navbarTemplate = require('hbs!app.templates/navbar.view');
  var NavDropdown = require('jsx!components/nav.dropdown');
  var React = require('react');

  var NavbarView = Backbone.View.extend({
    template: navbarTemplate,

    render: function() {
      this.setElement(this.template());
      React.renderComponent(new NavDropdown(), this.$el.find('#navDropdown').get(0));
      return this;
    }
  });
  return NavbarView;
});