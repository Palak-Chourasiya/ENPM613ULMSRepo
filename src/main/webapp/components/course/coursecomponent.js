angular.module('ULMS')
  .component('course', {
    templateUrl: 'components/course/course.html',
    bindings: {},
    
    controller: function($scope, $http, $stateParams) {

        var ctrl = this;
        
        this.$onInit = function() {
          
        };
        
        $scope.course = [];
        $scope.courseForm = {
            id : -1,
            title : "",
            details : "",
            start_date : "",
            instructor_id : -1
        };

        //Now load the data from server
        _refreshCourseData();

            var method = "";
            var url = "";
         
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
        
        $scope.addCourse = function() { 
            $http({
                method : "POST",
                url : 'course/add',
                data : angular.toJson($scope.courseForm),
                headers : {
                    'Content-Type' : 'application/json'
                }
            }).then( _success, _error );
        };
        

  /*      $scope.deleteCourseModule = function(module){
        	$http({
                method : 'DELETE',
                url : 'http://localhost:8080/module/delete' + module
            }).then(_success, _error)
        }
        
     function _success(response) {  
    	 _refreshCourseData();
    }

    function _error(response) {
        console.log(response.statusText);
    }*/
        
      }
    })