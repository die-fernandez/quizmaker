(function(angular) {
  var ExamFactory = function($resource, ENV) {
    return $resource('http://' + ENV.server + '/exams/:id', {
      id: '@id'
    }, {
      query: {
        method: "GET"
      }
    });
  };

  ExamFactory.$inject = ['$resource', 'ENV'];
  angular.module("myApp.services")
    .factory("Exam", ExamFactory);

  var AttemptFactory = function($resource, ENV) {
    return $resource('http://' + ENV.server + '/attempts/:id', {
      id: '@id'
    }, {
      query: {
        method: "GET"
      }
    });
  };

  ExamFactory.$inject = ['$resource', 'ENV'];
  angular.module("myApp.services")
    .factory("Attempt", AttemptFactory);


  var SessionService = function($window) {

    var started = false;

    this.started = function() {
      return isStarted
    }

    this.start = function() {
      started = true;
    }

    this.saveToken = function(token){
       $window.sessionStorage.token = token;
    }

  }

  SessionService.$inject = ['$window'];
  angular.module("myApp.services")
    .service("SessionSvc", SessionService);

  angular.module('config', [])

  .constant('ENV', {
    server: 'localhost:8080'
  });



}(angular));