angular.module('ULMS')
  .component('moduleadd', {
    templateUrl: 'components/moduleadd/moduleadd.html',
    bindings: {},
    
    controller: function($scope, $http, $state, $stateParams) {

        var ctrl = this;
        $scope.message=null;
        $scope.createModuleForm = {
        	moduleNumber: -1,
            courseId : $stateParams.id,
            title : "",
            datePublished : "",
            recipeLink : ""
        };     
        
        this.$onInit = function() {
        	
        };       
        $scope.modules=[];
        $scope.addModule = function() {         	
           var temp= angular.toJson($scope.createModuleForm);
           var method = "POST";
           var url = "module/add";
           
        	$http({
                method : "POST",
                url : 'module/add',
                data : temp
            }).then(function successCallback(response) {
            	$state.go('course', {id:response.data.courseId});
            }, function errorCallback(response) {
                console.log(response.statusText);
            });
       
        }
        
      }
    })