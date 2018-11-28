angular.module('ULMS')
  .component('recipes', {
    templateUrl: 'components/studentList/studentList.css',
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
       
           Private Methods 
      //HTTP GET- get all countries collection
      function _refreshStudentData() {
      	  $http({
              method : 'GET',
              url : 'http://localhost:8080/studentList/'
          }).then(function successCallback(response) {
              $scope.students.push(response.data);
          }, function errorCallback(response) {
              console.log(response.statusText);
          });
          $http({
              method : 'GET',
              url : 'http://localhost:8080/studentList/'
          }).then(function successCallback(response) {
              $scope.students = response.data;
          }, function errorCallback(response) {
              console.log(response.statusText);
          });
      }

      function _success(response) {
          _refreshCountryData();
          _clearFormData()
      }

      function _error(response) {
          console.log(response.statusText);
      }

      //Clear the form
      function _clearFormData() {
          $scope.recipeForm.id = -1;
          $scope.recipeForm.accountId = -1;
          $scope.recipeForm.courseId = -1;
          $scope.recipeForm.title = "";
          $scope.recipeForm.overview = "";
      
      };


    }
  })