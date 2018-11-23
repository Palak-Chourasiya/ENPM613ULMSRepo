angular.module('ULMS')
  .component('recipe', {
    templateUrl: 'components/recipe/recipetemplate.html',
    bindings: {},

    controller: function($scope, $http) {

      var ctrl = this;
      
      this.$onInit = function() {
        
      };
      
      $scope.recipes = [];

      //Now load the data from server
      _refreshRecipeData();

      //HTTP POST/PUT methods for add/edit country 
      // with the help of id, we are going to find out whether it is put or post operation
      
      $scope.submitRecipe = function() {

          var method = "";
          var url = "";
          
          //Id is present in form data, it is edit country operation
          method = "PUT";
          url = 'recipes/' + recipe.id;

          $http({
              method : method,
              url : url,
              data : angular.toJson($scope.recipeForm),
              headers : {
                  'Content-Type' : 'application/json'
              }
          }).then( _success, _error );
      };

      // In case of edit, populate form fields and assign form.id with recipe id
      $scope.editRecipe = function(recipe) {
          $scope.recipeForm.id = recipe.id;
          $scope.recipeForm.accountId = recipe.accountId;
          $scope.recipeForm.courseId = recipe.courseId;
          $scope.recipeForm.title = recipe.title;
          $scope.recipeForm.overview = recipe.overview;
      };

      /* Private Methods */
      //HTTP GET- get single recipe
      function _refreshRecipeData() {
      	  $http({
              method : 'GET',
              url : 'http://localhost:8080/recipes/1'
          }).then(function successCallback(response) {
              $scope.recipes.push(response.data);
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
    }
  })