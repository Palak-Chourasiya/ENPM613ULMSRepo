angular.module('ULMS').config(function($stateProvider, $urlServiceProvider, $urlRouterProvider) {
	
  // State to view list of recipes
  $stateProvider.state('recipes', {
    url: '/recipes',
    component: 'recipes'
  })
  // State to view single recipe
  $stateProvider.state('recipe', {
	  url: '/recipe',
	  component: 'recipe'
  })
  // State to view student List
  $stateProvider.state('studentList', {
	  url: '/studentList',
	  component: 'studentList'
  })
/*
  // State to view courses
  $stateProvider.state('courses', {
    url: '/courses',
    component: 'courses'
  })
*/
  // What to do if no state is specified
  $urlServiceProvider.rules.otherwise({
    state: 'recipes'
  });
})