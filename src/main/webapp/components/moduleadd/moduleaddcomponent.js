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
        $scope.modules=[];
        $scope.addModule = function() {         	
           var temp=angular.toJson($scope.createModuleForm);
           var method = "POST";
           var url = "module/add";
           var headers ="";
           
        	$http({
                method : "POST",
                url : 'module/add',
                data : temp,
                headers : {
                    'Content-Type' : 'application/json'
                }
            }).then(function successCallback(response) {
                $scope.modules= response.data;
            }, function errorCallback(response) {
                console.log(response.statusText);
            });
       
        }
        
      }
    })