define(function(require) {
  'use strict';

  var Backbone = require('backbone');
  var podcastsTemplate = require('hbs!app.templates/podcasts.view');
  var PodcastView = require('views/podcast.view');

  var PodcastsView = Backbone.View.extend({
    collection: null,
    template: podcastsTemplate,

    initialize: function(collection) {
      this.collection = collection;
    },

    render: function() {
      this.setElement(this.template());
      this.renderAll();
      return this;
    },

    renderAll: function() {
      var podcastView;
      var ul = this.$el.find('#podcastList');
      this.collection.each(function(podcast) {
        podcastView = new PodcastView({ model: podcast });
        ul.append(podcastView.render().el);
      });
    }
  });

  return PodcastsView;
});