angular.module('ULMS')
  .component('account', {
    templateUrl: 'components/account/account.html',
    bindings: {},

    controller: function($scope, $http) {

      var ctrl = this;
      
      this.$onInit = function() {
        
      };
      
      $scope.account;

      //Now load the data from server
      _refreshAccountData();

          var method = "";
          var url = "";
       
      //HTTP GET- get all countries collection
      function _refreshAccountData() {
          $http({
              method : 'GET',
              url : 'http://localhost:8080/accounts/authenticatedAccount'
          }).then(function successCallback(response) {
        	  $scope.account = response.data;
          }, function errorCallback(response) {
              console.log(response.statusText);
          });
      }

      function _error(response) {
          console.log(response.statusText);
      }
    }
  })