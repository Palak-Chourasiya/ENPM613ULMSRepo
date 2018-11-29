angular.module('ULMS')
  .component('studentList', {
    templateUrl: 'components/studentList/studentDetails.html',
    bindings: {},

    controller: function($scope, $http) {

      var ctrl = this;
      
      this.$onInit = function() {
        
      };
      
      $scope.students = [];

      //Now load the data from server
      _refreshStudentData();

          var method = "";
          var url = "";
       
      //HTTP GET- get all countries collection
      function _refreshStudentData() {
          $http({
              method : 'GET',
              url : 'http://localhost:8080/studentList/EnrolledStudents'
          }).then(function successCallback(response) {
              $scope.students = response.data;
          }, function errorCallback(response) {
              console.log(response.statusText);
          });
      }

      function _error(response) {
          console.log(response.statusText);
      }
    }
  })