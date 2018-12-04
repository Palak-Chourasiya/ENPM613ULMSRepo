angular.module('ULMS')
  .component('inbox', {
    templateUrl: 'components/messages/inbox.html',
    bindings: {},

    controller: function($scope, $http) {

      var ctrl = this;
      
      this.$onInit = function() {
        
      };
    }
  })