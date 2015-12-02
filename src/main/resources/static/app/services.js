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

  ItemFactory.$inject = ['$resource'];
  angular.module("myApp.services").factory("Exam", ExamFactory);
}(angular));