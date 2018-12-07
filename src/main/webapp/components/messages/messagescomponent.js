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
      $scope.ComposeLabel = "COMPOSE";
      
      $scope.emailIsReadOnly = false;
      $scope.subjectIsReadOnly = false;
      $scope.messageIsReadOnly = false;
      var currentMessage = [];
      
      
      $scope.myForm = {
    		  emailText: "",
    		  subjectText: "",
    		  messageText: ""
      };



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
    	  $scope.ComposeLabel = "MESSAGE";
    	  currentMessage = messageData;
          $scope.popupFormIsVisible = true;
          $scope.showDeleteBtn = true;
          $scope.showSentBtn = false;
          $scope.showReplyBtn = true;
          $scope.emailIsReadOnly = true;
          $scope.subjectIsReadOnly = true;
          $scope.messageIsReadOnly = true;
          $scope.myForm = {
        		  emailText: messageData.user_name,
        		  subjectText: messageData.subject,
        		  messageText: messageData.message
          };
      }
      
      $scope.openComposeForm = function() {
    	  $scope.ComposeLabel = "COMPOSE";
          $scope.myForm = {
        		  emailText: "",
        		  subjectText: "",
        		  messageText: ""
          };
          $scope.popupFormIsVisible = true;
          $scope.showDeleteBtn = false;
          $scope.showSentBtn = true;
          $scope.showReplyBtn = false;
  	      $scope.emailIsReadOnly = false;
  	      $scope.subjectIsReadOnly = false;
  	      $scope.messageIsReadOnly = false;
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
            $scope.myForm = {
          		  emailText: "",
          		  subjectText: "",
          		  messageText: ""
            };
    	}
    	$scope.sendMessage = function() {
    		var temp = angular.toJson($scope.myForm);
    		String stringValue = "";//"emailText="+$scope.myForm.emailText + "&subjectText="+$scope.myForm.emailText+"&messageText="+$scope.myForm.messageText;
      	  $http({
<<<<<<< HEAD
      		  method: 'GET',
      		  url : "http://localhost:8080/messages/addMessage?",// + stringValue,
              headers : {
                  'Content-Type' : 'application/json'
              }
=======
      		  method: 'POST',
      		  url : 'http://localhost:8080/messages/add',
      		  data: angular.toJson($scope.myForm)
>>>>>>> 4b7b492be66b1cbddc8bc8adb6daf0c98c8b0319
      	  }).then(function successCallback(response){
      		  $scope.messageTest = response.data;
    		  $scope.popupFormIsVisible = false;
    		  }, function errorCallback(response){
        		  $scope.messageTest = "Failed: " + temp;
          		  $scope.popupFormIsVisible = false;
          		  });
    	}
    	
        //Delete Messages
        $scope.deleteAMessage = function()
        {
	        var url = 'http://localhost:8080/messages/ReceiverDelete/'+ currentMessage.id;
	        $http({
	  		  method: 'GET',
	  		  url : url
	  	  }).then(function successCallback(response){
	  		  $scope.getUnreadMessageData();
	  		  $scope.message = "success";
      		  $scope.popupFormIsVisible = false;
	  	  }, function errorCallback(response){
	  		  $scope.message = "failed";
	  		  console.log(response.statusText);
      		  $scope.popupFormIsVisible = false;

	  	  }); 
        }
        $scope.replyMessage = function()
        {
            $scope.popupFormIsVisible = false;
            $scope.showDeleteBtn = false;
            $scope.showSentBtn = true;
            $scope.showReplyBtn = false;
    	      $scope.emailIsReadOnly = false;
    	      $scope.subjectIsReadOnly = false;
    	      $scope.messageIsReadOnly = false;
  	      
            $scope.myForm = {
          		  emailText: currentMessage.senderEmail,
          		  subjectText: "Re: " + currentMessage.subject,
          		  messageText: "\n\n\n\------------------reply-------------\n" + currentMessage.message
            };
  		  $scope.popupFormIsVisible = true;

        }
    
      
    }
  })