angular.module('ULMS')
  .component('module', {
    templateUrl: 'components/module/module.html',
    bindings: {},
    
    controller: function($scope, $http) {

        var ctrl = this;
        
        this.$onInit = function() {
          
        };
        
        $scope.modules = [];

      
        //Now load the data from server
        _refreshCourseModuleData();

            var method = "";
            var url = "";
         
        //HTTP GET- get all courses collection
        function _refreshCourseModuleData() {
            $http({
                method : 'GET',
                url : 'http://localhost:8080/module/courseModule/1'
            }).then(function successCallback(response) {
                $scope.modules = response.data;
            }, function errorCallback(response) {
                console.log(response.statusText);
            });
        }
        
      }
    })