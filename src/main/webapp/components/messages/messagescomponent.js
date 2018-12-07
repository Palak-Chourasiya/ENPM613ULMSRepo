angular.module('ULMS')
  .component('messages', {
    templateUrl: 'components/messages/messages.html',
    bindings: {},

    controller: function($scope, $http, $window) {

      var ctrl = this;
      
      this.$onInit = function() {
          getUnreadMessageData();

      };
      
      $scope.unreadMessagesData=[];
      $scope.deletedIds=[];
      $scope.messageTest = "Test";
      $scope.popupFormIsVisible = false;
      $scope.showDeleteBtn = false;
      $scope.showSentBtn = false;
      $scope.showReplyBtn = false;
      $scope.deleteMessageBtnVisibility = true;



      $scope.getUnreadMessageData = function(){
          $scope.deleteMessageBtnVisibility = true;
          $scope.popupFormIsVisible = false;
          $scope.unreadMessagesData=[];
    	  $http({
    		  method: 'GET',
    		  url : 'http://localhost:8080/messages/getEmail'
    	  }).then(function successCallback(response){
    		  $scope.unreadMessagesData = response.data;
    	  }, function errorCallback(response){
    		  console.log(response.statusText);
    	  });
      }
      
      //Delete Messages
      $scope.deleteMessage = function(unreadMessagesData)
      {
    	  for (var i = 0; i < unreadMessagesData.length; i++){
    		  if (unreadMessagesData[i].selected){
    			  $scope.deletedIds.push(unreadMessagesData[i].id);
    	    	  }
    	  }
      var url = 'http://localhost:8080/messages/ReceiverDelete/'+$scope.deletedIds;
      $http({
		  method: 'GET',
		  url : url
	  }).then(function successCallback(response){
		  $scope.getUnreadMessageData();
		  $scope.message = "success";
	  }, function errorCallback(response){
		  $scope.message = "failed";
		  console.log(response.statusText);
	  });    	  
      }

      $scope.openMessage = function(messageData)
      {
          $scope.popupFormIsVisible = true;
          $scope.showDeleteBtn = true;
          $scope.showSentBtn = false;
          $scope.showReplyBtn = true;
          $scope.subjectText = messageData.subject;
          $scope.emailText = messageData.user_name;
          $scope.messageText = messageData.message;
      }
      
      $scope.openComposeForm = function() {
          $scope.popupFormIsVisible = true;
          $scope.showDeleteBtn = false;
          $scope.showSentBtn = true;
          $scope.showReplyBtn = false;
    	}

    	$scope.openSent = function(){
    	  $scope.deleteMessageBtnVisibility = false;
    	  $scope.unreadMessagesData=[];

      	  $http({
    		  method: 'GET',
    		  url : 'http://localhost:8080/messages/sent'
    	  }).then(function successCallback(response){
    		  $scope.unreadMessagesData = response.data;
    	  }, function errorCallback(response){
    		  console.log(response.statusText);
    	  });
    	}

    	$scope.openTrash = function(){
    		
    		$scope.deleteMessageBtnVisibility = false;
      	  	$scope.unreadMessagesData=[];

        	  $http({
      		  method: 'GET',
      		  url : 'http://localhost:8080/messages/trash'
      	  }).then(function successCallback(response){
      		  $scope.unreadMessagesData = response.data;
      	  }, function errorCallback(response){
      		  console.log(response.statusText);
      	  });
        	  
        	  
    	}
    	$scope.closeForm = function() {
      		$scope.popupFormIsVisible = false;
            $scope.subjectText = "";
            $scope.emailText = "";
            $scope.messageText = "";
    	}
    	$scope.sendMessage = function() {
      		$scope.popupFormIsVisible = false;

    	}
      
      
      
      
    }
  })