(function(angular) {
  var ExamFactory = function($resource) {
    return $resource('/exams/:id', {
      id: '@id'
    }, {
      query: {
        method: "GET"
      }
    });
  };

  ExamFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Exam", ExamFactory);

  var AttemptFactory = function($resource) {
      return $resource('/attempts/:id', {
        id: '@id'
      }, {
        query: {
          method: "GET"
        }
      });
    };

    ExamFactory.$inject = ['$resource'];
    angular.module("myApp.services").factory("Attempt", AttemptFactory);

}(angular));