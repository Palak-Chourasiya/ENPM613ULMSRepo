angular.module('ULMS')
  .component('moduleadd', {
    templateUrl: 'components/moduleadd/moduleadd.html',
    bindings: {},
    
    controller: function($scope, $http, $stateParams) {

        var ctrl = this;
        
        this.$onInit = function() {
          
        };
        
        $scope.course = [];
        $scope.moduleForm = {
        	module_number: -1,
            course_id : $stateParams.id,
            title : "",
            date_published : "",
            recipe_link : ""
        };

        //Now load the data from server
        _refreshCourseData();
         
        //HTTP GET- get all courses collection
        function _refreshCourseData() {
            $http({
                method : 'GET',
                url : 'http://localhost:8080/courses/' + $stateParams.id
            }).then(function successCallback(response) {
                $scope.course = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText);
            });
        }
        
        $scope.addModule = function() { 
            $http({
                method : "POST",
                url : 'module/add',
                data : angular.toJson($scope.moduleForm),
                headers : {
                    'Content-Type' : 'application/json'
                }
            }).then( _success, _error );
        };
        

        $scope.deleteCourseModule = function(module){
        	$http({
                method : 'DELETE',
                url : 'http://localhost:8080/module/delete' + module.module_number
            }).then(_success, _error)
        }
        
     function _success(response) {  
    	 _refreshCourseData();
    }

    function _error(response) {
        console.log(response.statusText);
    }
        
      }
    })