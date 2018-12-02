angular.module('ULMS')
  .component('course', {
    templateUrl: 'components/course/course.html',
    bindings: {},
    
    controller: function($scope, $http) {

        var ctrl = this;
        
        this.$onInit = function() {
          
        };
        
        $scope.courses = [];

        //Now load the data from server
        _refreshCourseData();

            var method = "";
            var url = "";
         
        //HTTP GET- get all courses collection
        function _refreshCourseData() {
            $http({
                method : 'GET',
                url : 'http://localhost:8080/courses/'
            }).then(function successCallback(response) {
                $scope.courses = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText);
            });
        }
      }
    })