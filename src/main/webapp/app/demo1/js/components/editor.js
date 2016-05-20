/** @jsx React.DOM */

define(function(require) {
  'use strict';

  var React = require('react');

  var MarkdownEditor = React.createClass({
    getInitialState: function() {
      return {value: 'Type some *markdown* here!'};
    },
    handleChange: function() {
      this.setState({value: this.refs.textarea.getDOMNode().value});
    },
    render: function() {
      var Showdown = require('showdown');
      var converter = new Showdown.converter();
      return (
        <div className="MarkdownEditor">
          <h3>Input</h3>
          <textarea className="converter"
          onChange={this.handleChange}
          ref="textarea"
          defaultValue={this.state.value} />
          <h3>Output</h3>
          <div
          className="content"
          dangerouslySetInnerHTML={{
            __html: converter.makeHtml(this.state.value)
          }}
          />
        </div>
        );
    }
  });

  return MarkdownEditor;

});