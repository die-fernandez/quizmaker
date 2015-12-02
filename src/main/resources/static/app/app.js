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
            templateUrl: 'app/views/exam.html',
            controller: 'AppCtrl'
          })
      .when('/questions', {
        templateUrl: 'app/views/questions.html',
        controller: 'QuestionCtrl'
      })
      .when('/result', {
        templateUrl: 'app/views/goal/result.html',
        controller: 'AttemptCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
    });

}(angular));