define(function(require) {
  'use strict';

  var Backbone = require('backbone');
  var podcastTemplate = require('hbs!app.templates/podcast.view');

  var PodcastView = Backbone.View.extend({
    template: podcastTemplate,

    render: function() {
      this.setElement(this.template(this.model.toJSON()));
      return this;
    }
  });

  return PodcastView;
});