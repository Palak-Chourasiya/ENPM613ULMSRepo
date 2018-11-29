angular.module('ULMS')
  .component('student', {
    templateUrl: 'components/student/student.html',
    bindings: {},

    controller: function($scope, $http) {

      var ctrl = this;
      
      this.$onInit = function() {
        
      };
     // $scope.student = [];
     /* $scope.demo='demo';
      _fetchStudentData();
      function _fetchStudentData() {
      	  $http({
              method : 'GET',
              url : 'http://localhost:8080/studentList/1'
          }).then(function successCallback(response) {
              $scope.student.push(response.data);
          }, function errorCallback(response) {
              console.log(response.statusText);
          });

      }
    }*/

  })