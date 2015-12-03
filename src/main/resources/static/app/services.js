(function(angular) {
  var ExamFactory = function($resource,ENV) {
    return $resource('http://'+ENV.server+'/exams/:id', {
      id: '@id'
    }, {
      query: {
        method: "GET"
      }
    });
  };

  ExamFactory.$inject = ['$resource', 'ENV'];
  angular.module("myApp.services").factory("Exam", ExamFactory);

  var AttemptFactory = function($resource,ENV) {
      return $resource('http://'+ENV.server+'/attempts/:id', {
        id: '@id'
      }, {
        query: {
          method: "GET"
        }
      });
    };

    ExamFactory.$inject = ['$resource', 'ENV'];
    angular.module("myApp.services").factory("Attempt", AttemptFactory);

     angular.module('config', [])

    .constant('ENV', {server:'localhost:8080'})
    ;

}(angular));