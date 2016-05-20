define(function(require) {
  'use strict';

  var Backbone = require('backbone');
  var bookTemplate = require('hbs!app.templates/books.view');
  var BookView = require('views/book.view');

  var BooksView = Backbone.View.extend({
    template: bookTemplate,
    collection: null,

    initialize: function(collection) {
      this.collection = collection;
    },

    render: function() {
      this.setElement(this.template());
      this.renderAll();
      return this;
    },

    renderAll: function() {
      var bookView;
      var ul = this.$el.find('#bookList');
      this.collection.each(function(book) {
        bookView = new BookView({ model: book });
        ul.append(bookView.render().el);
      });
    }
  });

  return BooksView;
});