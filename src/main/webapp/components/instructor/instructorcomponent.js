angular.module('ULMS')
  .component('instructor', {
    templateUrl: 'components/instructor/instructor.html',
    bindings: {},

    controller: function($scope, $http, $stateParams) {

      var ctrl = this;
      
      this.$onInit = function() {
        
      };
      $scope.instructor;
      
      _fetchInstructorData();
      
      function _fetchInstructorData() {
      	  $http({
              method : 'GET',
              url : 'http://localhost:8080/accounts/'+ $stateParams.id
          }).then(function successCallback(response) {
              $scope.instructor= response.data;
          }, function errorCallback(response) {
              console.log(response.statusText);
          });

      }
    }

  })