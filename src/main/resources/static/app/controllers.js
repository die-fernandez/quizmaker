(function(angular) {

  var AppController = function($scope,$http, Exam, ENV) {
    Exam.query({"id":1},
        function(response) {
            $scope.exam = response ? response : [];
        },
        function(error){
             console.log(error);
           });
    $scope.start = function(){

        $http({
            method: 'POST',
            url: 'http://'+ENV.server+'/oauth/token',
            params: {
                password: $scope.password,
                username: $scope.user,
                grant_type: "password",
                scope: "read write",
                client_id: "clientapp",
                client_secret: "123456",         
            },
            headers: {
                    'Accept': 'application/json',
                    'Authentication': 'Basic '+ btoa("clientapp:123456"),
                    'Content-Type': 'application/x-www-form-urlencoded'
                     }
        }).success(function (data, status, headers, config) {
            console.log("started with token" + data.access_token);

        }).error(function (data, status, headers, config) {
            console.log("started with token" + data.access_token);
        });
    }

  };

  AppController.$inject = ['$scope','$http', 'Exam', 'ENV'];
  angular.module("myApp.controllers").controller("AppCtrl", AppController);


  var QuestionController = function($scope, Question) {

    };
  QuestionController.$inject =  ['$scope', 'Question'];
  angular.module("myApp.controllers").controller("QuestionCtrl", QuestionController);

  var AttemptController = function($scope, Attempt) {

    };
  AttemptController.$inject = ['$scope', 'Attempt'];
  angular.module("myApp.controllers").controller("AttemptCtrl", AttemptController);

  var TimerController = function($scope, Attempt) {

      };
  TimerController.$inject = ['$scope', 'Attempt'];
  angular.module("myApp.controllers").controller("TimerCtrl", TimerController);



}(angular));