angular.module('ULMS')
  .component('messages', {
    templateUrl: 'components/messages/messages.html',
    bindings: {},

    controller: function($scope, $http, $stateParams) {

      var ctrl = this;
      
      this.$onInit = function() {
        
      };
      
      $scope.unreadMessagesData=[];
      $scope.readMessagesData=[];
      $scope.deletedIds=[];
      $scope.count = 0;
      $scope.message = "test";

      getUnreadMessageData();
      function getUnreadMessageData(){
    	  $http({
    		  method: 'GET',
    		  url : 'http://localhost:8080/messages/getEmail'
    	  }).then(function successCallback(response){
    		  $scope.unreadMessagesData = response.data;
    	  }, function errorCallback(response){
    		  console.log(response.statusText);
    	  });
      }


      $scope.deleteMessage = function(unreadMessagesData)
      {
    	  var message = unreadMessagesData.length;
    	  for (var i = 0; i < unreadMessagesData.length; i++){
    		  if (unreadMessagesData[i].selected){
    			  $scope.deletedIds.push(unreadMessagesData[i].id);
    	    	  }
    	  }
      var url = 'http://localhost:8080/messages/ReceiverDelete/'+$scope.deletedIds;
      $scope.message = url;
      $http({
		  method: 'GET',
		  url : url
	  }).then(function successCallback(response){
		  getUnreadMessageData();
		  $scope.message = "success";
	  }, function errorCallback(response){
		  $scope.message = "failed";
		  console.log(response.statusText);
	  });
    	  
      }
    }
  })