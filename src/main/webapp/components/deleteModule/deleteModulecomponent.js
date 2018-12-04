angular.module('ULMS')
  .component('deleteModule', {
    templateUrl: 'components/deleteModule/deleteModule.html',
    bindings: {},
    
    controller: function($scope, $http, $stateParams) {

        var ctrl = this;
        
        this.$onInit = function() {
          
        };

        deleteCourseModule();
        $scope.message=null;

        var method = "";
        var url = "";

         
      
        function deleteCourseModule(){
        	$http({
                method : 'GET',
                url : 'http://localhost:8080/module/delete/' + $stateParams.id
            }).then(_success, _error)
        }
    
        function _success(response) {  
        	 $scope.message="Successfully deleted!";
        	console.log("Successfully deleted!");
        }

        function _error(response) {
        	console.log(response.statusText);
        }
      }
    })