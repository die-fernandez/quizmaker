(function(angular) {
  angular.module("myApp.controllers", []);
  angular.module("myApp.services", []);
  angular.module("myApp", [
    "ngResource",
    "myApp.controllers",
    "myApp.services",
    'ngRoute'
    ])
    .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
            templateUrl: 'views/exam.html',
            controller: 'QuestionCtrl'
          })
      .when('/questions', {
        templateUrl: 'views/questions.html',
        controller: 'QuestionCtrl'
      })
      .when('/result', {
        templateUrl: 'views/goal/result.html',
        controller: 'ResultCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
    });

}(angular));