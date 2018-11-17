angular.module('ULMS')
  .component('recipes', {
    templateUrl: 'components/recipes/recipestemplate.html',
    bindings: {},

    controller: function($scope, $http) {

      var ctrl = this;
      
      this.$onInit = function() {
        
      };
      
      $scope.recipes = [];
      $scope.recipeForm = {
          id : -1,
          accountId : -1,
          courseId : -1,
          title: ""
      };

      //Now load the data from server
      _refreshRecipeData();

      //HTTP POST/PUT methods for add/edit country 
      // with the help of id, we are going to find out whether it is put or post operation
      
      $scope.submitRecipe = function() {

          var method = "";
          var url = "";
          if ($scope.recipeForm.id == -1) {
              //Id is absent in form data, it is create new recipe operation
              method = "POST";
              url = 'recipes/add';
          } else {
              //Id is present in form data, it is edit country operation
              method = "PUT";
              url = 'recipes/' + recipe.id;
          }

          $http({
              method : method,
              url : url,
              data : angular.toJson($scope.recipeForm),
              headers : {
                  'Content-Type' : 'application/json'
              }
          }).then( _success, _error );
      };

      //HTTP DELETE- delete country by Id
      $scope.deleteRecipe = function(recipe) {
          $http({
              method : 'DELETE',
              url : 'recipes/' + country.id
          }).then(_success, _error);
      };

   // In case of edit, populate form fields and assign form.id with recipe id
      $scope.editRecipe = function(recipe) {
          $scope.recipeForm.id = recipe.id;
          $scope.recipeForm.accountId = recipe.accountId;
          $scope.recipeForm.courseId = recipe.courseId;
          $scope.recipeForm.title = recipe.title;
      };

      /* Private Methods */
      //HTTP GET- get all countries collection
      function _refreshRecipeData() {
      	$http({
              method : 'GET',
              url : 'http://localhost:8080/recipes/1'
          }).then(function successCallback(response) {
              $scope.recipes.push(response.data);
          }, function errorCallback(response) {
              console.log(response.statusText);
          });
          $http({
              method : 'GET',
              url : 'http://localhost:8080/recipes/'
          }).then(function successCallback(response) {
              $scope.recipes = response.data;
          }, function errorCallback(response) {
              console.log(response.statusText);
          });
      }

      function _success(response) {
          _refreshCountryData();
          _clearFormData()
      }

      function _error(response) {
          console.log(response.statusText);
      }

      //Clear the form
      function _clearFormData() {
          $scope.recipeForm.id = -1;
          $scope.recipeForm.accountId = -1;
          $scope.recipeForm.courseId = -1;
          $scope.recipeForm.title = "";
      
      };


    }
  })