angular.module('ULMS').config(function($stateProvider, $urlServiceProvider, $urlRouterProvider) {
  // State to view hello
  $stateProvider.state('recipes', {
	url: '/hello',
	component: 'hello'
  })
	
  // State to view recipes
  $stateProvider.state('recipes', {
    url: '/recipes',
    component: 'recipes'
  })

  // State to view courses
  $stateProvider.state('courses', {
    url: '/courses',
    component: 'courses'
  })

  // What to do if no state is specified
  $urlServiceProvider.rules.otherwise({
    state: 'courses'
  });
})