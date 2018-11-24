angular.module('ULMS')
  .component('login', {
    templateUrl: 'components/login/logintemplate.html',
    bindings: {},

    controller: function($scope, $http) {

      var ctrl = this;
      
      $scope.loginForm = {
              userName : "",
              accountId : -1,
              password: ""
          };
      
      this.$onInit = function() {
        
      };
      
      $scope.submitLogin = function() {

          var method = "";
          var url = "";
          //Id is absent in form data, it is create new recipe operation
          method = "POST";
          url = 'login';

          $http({
              method : method,
              url : url,
              data : angular.toJson($scope.loginForm),
              headers : {
                  'Content-Type' : 'application/json'
              }
          }).then( _success, _error );
      };
      
      // In case of login, populate form fields
      $scope.editLogin = function(login) {
          $scope.loginForm.userName = login.userName;
          $scope.loginForm.accountId = login.accountId;
          $scope.loginForm.password = login.password;
      };
    }
  })