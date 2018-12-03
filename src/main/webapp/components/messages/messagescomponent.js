angular.module('ULMS')
  .component('messages', {
    templateUrl: 'components/messages/messages.html',
    bindings: {},

    controller: function($scope, $http) {

      var ctrl = this;
      
      this.$onInit = function() {
        
      };
      
      $scope.receivers = "";
      $scope.subject = "";
      $scope.message = "";
      
      
      $scope.sendMessage = function() {

    	  var method = "POST";
          var url = "message/ngan.ngo";
          var data = $scope.messageForm;

          $http({
              method : method,
              url : url,
              data : angular.toJson($scope.messageForm),
              headers : {
                  'Content-Type' : 'application/json'
              }
          }).then( _success, _error );
      };


    }
  })