angular.module('ULMS').config(function($stateProvider, $urlServiceProvider, $urlRouterProvider) {
  // State to display HTTP Request errors
  $stateProvider.state('error', {
	  url: '/error',
	  component: 'error',
	  params: { status: null, statusText: null }
  })
	
  // State to login to ULMS; NOTE: NOW STATIC TEMPLATE PAGE
  /*
  $stateProvider.state('login', {
	  url: '/login',
	  component: 'login'
  })
  */
	
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
  // State to view single student 
  $stateProvider.state('student', {
	  url: '/student',
	  component: 'student'
  })
  // State to view courses
  $stateProvider.state('courses', {
	  url: '/courses',
	  component: 'courses'
  })
  // State to view a single course
  $stateProvider.state('course', {
    url: '/course',
    component: 'course'
  })
  // State to view modules
  $stateProvider.state('modules', {
	  url: '/modules',
	  component: 'modules'
  })
  // State to view a single module
  $stateProvider.state('module', {
    url: '/module',
    component: 'module'
  })
  // State to view account 
  $stateProvider.state('account', {
	    url: '/account',
	    component: 'account'
  })
  // State to view message 
  $stateProvider.state('messages', {
	    url: '/messages',
	    component: 'messages'
  })
  // What to do if no state is specified
  $urlServiceProvider.rules.otherwise({
    state: 'courses'
  })   	
})