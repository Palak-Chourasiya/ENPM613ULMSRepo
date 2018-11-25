angular.module('ULMS')
  .component('login', {
    templateUrl: 'components/login/logintemplate.html',
    bindings: {},

    controller: function($scope, $http, $state) {

      var ctrl = this;
      
      $scope.loginForm = {
              userName : "",
              accountId : -1,
              password: ""
          };
      
      this.$onInit = function() {
        
      };
      
      $scope.submitLogin = function() {

          var method = "GET";
          var url = "login";
          
          var temp = angular.toJson($scope.loginForm);

          $http({
        	method: "GET",
            url: "token"
          }).then(function(token) {
        	$http({
        	  method : "GET",
              url : "login",
              headers : {
                'X-Auth-Token' : token.token//,
                //authorization : "Basic " + btoa($scope.loginForm.userName + ":" + $scope.loginForm.password)
              }
            }).then(function(data) {
              $scope.greeting = data;
            });
          })
          
          /*
          $http({
              method : method,
              url : url,
              //data : angular.toJson($scope.loginForm),
              headers : {
            	  authorization : "Basic " + btoa($scope.loginForm.userName + ":" + $scope.loginForm.password),
                  'Content-Type' : 'application/json'
              }
          }).then( _success, _error );
          */
      };
      
      function _success(response) {
          _clearFormData()
      }

      function _error(response) {
          $state.go('error', {status:response.status, statusText:response.statusText});
      }

      //Clear the form
      function _clearFormData() {
          $scope.loginForm.userName = "";
          $scope.loginForm.accountId = -1;
          $scope.loginForm.password = "";
      
      };
    }
  })