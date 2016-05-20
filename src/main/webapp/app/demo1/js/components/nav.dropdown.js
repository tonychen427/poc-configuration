/** @jsx React.DOM */

define(function(require) {
  'use strict';

  var React = require('react');

  var NavDropdown = React.createClass({
    getInitialState: function() {
      return {
        auth: false
      };
    },
    render: function() {
      var cx = React.addons.classSet;
      var classes = cx({
        'hidden': this.state.auth
      });

      return (
      <ul className="nav navbar-nav navbar-right">
        <li><a href="#blog">Blog</a></li>
        <li className="dropdown">
          <a href="#" className="dropdown-toggle" data-toggle="dropdown">Other <b className="caret"></b></a>
          <ul className="dropdown-menu">
            <li><a className={classes} href="#books">Books</a></li>
            <li><a href="#podcasts">Podcasts</a></li>
            <li><a href="#addBlog">Add a Blog</a></li>
          </ul>
        </li>
      </ul>
        );
    }
  });

  return NavDropdown;
});