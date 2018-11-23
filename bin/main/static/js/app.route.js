angular.module('ULMS').config(function($stateProvider, $urlServiceProvider, $urlRouterProvider) {

  // State to view grooming
  $stateProvider.state('recipes', {
    url: '/recipes',
    component: 'recipes'
  })

  // State to view sprint planning
  $stateProvider.state('courses', {
    url: '/courses',
    component: 'courses'
  })

  // What to do if no state is specified
  $urlServiceProvider.rules.otherwise({
    state: 'courses'
  });
})