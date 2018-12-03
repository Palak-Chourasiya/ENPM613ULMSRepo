angular.module('ULMS')
  .component('course', {
    templateUrl: 'components/course/course.html',
    bindings: {},
    
    controller: function($scope, $http, $stateParams) {

        var ctrl = this;
        
        this.$onInit = function() {
          
        };
        
        $scope.course = [];

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
      }
    })