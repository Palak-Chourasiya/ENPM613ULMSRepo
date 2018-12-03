angular.module('ULMS')
  .component('student', {
    templateUrl: 'components/student/student.html',
    bindings: {},

    controller: function($scope, $http, $stateParams) {

      var ctrl = this;
      
      this.$onInit = function() {
        
      };
     // $scope.student = [];
      $scope.students=[];
      _fetchStudentData();
      
      function _fetchStudentData() {
      	  $http({
              method : 'GET',
              url : 'http://localhost:8080/studentList/course/'+ $stateParams.id
          }).then(function successCallback(response) {
              $scope.students= response.data;
          }, function errorCallback(response) {
              console.log(response.statusText);
          });

      }
    }

  })