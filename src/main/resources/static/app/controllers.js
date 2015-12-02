(function(angular) {

  var AppController = function($scope, Exam) {
    Exam.query({"id":1},
        function(response) {
            $scope.exam = response ? response : [];
        },
        function(error){
             console.log(error);
           });


  };

  AppController.$inject = ['$scope', 'Exam'];
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