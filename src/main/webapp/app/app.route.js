angular.module('ULMS').config(function($stateProvider, $urlServiceProvider, $urlRouterProvider) {
	
  // State to view recipes
  $stateProvider.state('recipes', {
    url: '/recipes',
    component: 'recipes'
  })
  // State to view header
  $stateProvider.state('header', {
	  url: '/header',
	  component: 'header'
  })
  // State to view footer
  $stateProvider.state('footer', {
	  url: '/footer',
	  component: 'footer'
  })
  // State to view baselayout
  $stateProvider.state('baselayout', {
	  url: '/baselayout',
	  component: 'baselayout'
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