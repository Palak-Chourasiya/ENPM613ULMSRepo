angular.module('ULMS')
  .component('moduleadd', {
    templateUrl: 'components/moduleadd/moduleadd.html',
    bindings: {},
    
    controller: function($scope, $http, $stateParams) {

        var ctrl = this;
        $scope.message=null;
        $scope.createModuleForm = {
        	module_number: -1,
           course_id : $stateParams.id,
            title : "",
            date_published : "",
            recipe_link : ""
        };     
        
        this.$onInit = function() {
        	
        };       
        
        $scope.addModule = function() {         	
           var temp=angular.toJson($scope.createModuleForm);
           var method = "POST";
           var url = "module/add";
           
        	$http({
                method : "POST",
                url : 'module/add',
                data : angular.toJson($scope.createModuleForm),
                headers : {
                    'Content-Type' : 'application/json'
                }
            }).then( _success, _error );
        };
        
        
     function _success(response) {  
    	 $scope.message="Successfully created";
    	 console.log(response.statusText);
    }

    function _error(response) {
        console.log(response.statusText);
    }
        
      }
    })