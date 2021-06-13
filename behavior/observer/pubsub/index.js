const pubsub = {};

(function(channel) {
  const events = {};
  let uid = 0;
  
  channel.publish = function(topic, data) {
    if (!events[topic]) {
      return false;
    }

    const list = events[topic];
    list.forEach(function(obj) {
      obj.func(data);
    });

    return this;
  }

  channel.subscribe = function(topic, func) {
    if (!events[topic]) {
      events[topic] = [];
    }
    const token = uid++;
    events[topic].push({
      token,
      func,
    });
    return token;
  }

  channel.unsubscribe = function(token) {
    // ..
    return this;
  }

})(pubsub);

pubsub.subscribe('message', function(data) {
  console.log('data', data);
});
pubsub.subscribe('message', function(data) {
  console.log('data1', data);
});

pubsub.publish('message', {});
