angular.module('ULMS')
  .component('messages', {
    templateUrl: 'components/messages/messages.html',
    bindings: {},

    controller: function($scope, $http, $stateParams) {

      var ctrl = this;
      
      this.$onInit = function() {
        
      };
      
      $scope.messagesData=[];
      getMessageData();
      function getMessageData(){
    	  $http({
    		  method: 'GET',
    		  url : 'http://localhost:8080/messages/get/ij@umd.edu/not_read'
    	  }).then(function successCallback(response){
    		  $scope.messagesData = response.data;
    	  }, function errorCallback(response){
    		  console.log(response.statusText);
    	  });
      }
    }
  })