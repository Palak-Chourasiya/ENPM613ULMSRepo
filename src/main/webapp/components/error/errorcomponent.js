angular.module('ULMS')
  .component('error', {
    templateUrl: 'components/error/errortemplate.html',
    bindings: {},

    controller: function($scope, $http, $stateParams) {

      var ctrl = this;
      
      this.$onInit = function() {
        
      };
      
      switch ($stateParams.status) {
      	case 500:
    	  $scope.errortitle = "Internal Server Error Occurred";
    	  $scope.errormessage = "Please contact your system administrator";
    	  break;
    	default:
    	  $scope.errortitle = "Unexpected Server Error Occurred";
    	  $scope.errormessage = "Please contact your system administrator";
    	  break;
      }
    }
  })